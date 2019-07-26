package org.gerry.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class applicationAware implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<add context>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public static <T> T getBean(Class<T> clazz){
        T t=context.getBean(clazz);

        Map<String,T> maps=context.getBeansOfType(clazz);
        for(Map.Entry<String,T> inst:maps.entrySet()){
            System.out.println(inst.getKey()+"----"+inst.getClass()+"-----"+inst.getValue());
        }
        return t;
    }
}
