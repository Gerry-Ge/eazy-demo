package org.gerry;

import org.gerry.Utils.applicationAware;
import org.gerry.model.User;
import org.gerry.services.UserInterface;
import org.gerry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("org.gerry.mapper")
public class SpringBootMain {
    public static void main(String[] args){
        SpringApplication.run(new SpringBootMain().getClass(),args);
    }

    @Bean
    public Object testGetClass(){
        return "dsada";
    }
}
