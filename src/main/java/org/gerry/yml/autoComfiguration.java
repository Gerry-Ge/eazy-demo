package org.gerry.yml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({readYml.class})
public class autoComfiguration {

    @Autowired
    private readYml Yml;

    @Bean
    public String testYml(){
        System.out.println("-------------------------"+this.Yml.getUrl());
        return "";
    }
}
