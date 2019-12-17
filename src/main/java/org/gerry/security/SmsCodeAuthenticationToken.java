package org.gerry.security;

import com.sun.org.apache.xml.internal.dtm.ref.IncrementalSAXSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

    private final Object prinpical;

    public SmsCodeAuthenticationToken(Object mobile) {
        super((Collection)null);
        this.prinpical = mobile;
        this.setAuthenticated(false);
    }

    public SmsCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.prinpical = principal;
        super.setAuthenticated(true);
    }

    public void setAuthenticated(boolean isAuthenticated){
        if(isAuthenticated){
            throw new IllegalArgumentException("can not set token to be trusted");
        }else{
            super.setAuthenticated(false);
        }
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.prinpical;
    }
}
