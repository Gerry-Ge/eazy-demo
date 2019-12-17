package org.gerry.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String mobileParameter = "mobile";
    private boolean postOnly = true;

    public SmsCodeAuthenticationFilter(){
        super(new AntPathRequestMatcher("/auth/mobile","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !httpServletRequest.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication not support :" + httpServletRequest.getMethod());
        } else {

            String mobile = obtainMobile(httpServletRequest);
            if(StringUtils.isEmpty(mobile)){
                mobile = "";
            }

            mobile = mobile.trim();

            SmsCodeAuthenticationToken token = new SmsCodeAuthenticationToken(mobile);

            token.setDetails(this.authenticationDetailsSource.buildDetails(httpServletRequest));

            return this.getAuthenticationManager().authenticate(token);
        }

    }

    protected String obtainMobile(HttpServletRequest req){
        return req.getParameter(mobileParameter);
    }

    public String getMobileParameter() {
        return mobileParameter;
    }

    public void setMobileParameter(String mobileParameter) {
        this.mobileParameter = mobileParameter;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
