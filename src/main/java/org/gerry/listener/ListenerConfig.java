package org.gerry.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean<DemoListener> userServlet(){
        return new ServletListenerRegistrationBean<DemoListener>(new DemoListener());
    }
}
