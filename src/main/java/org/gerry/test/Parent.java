package org.gerry.test;

import java.lang.reflect.ParameterizedType;

public abstract class Parent<Mapper,Record,Example> {

    public Mapper mapper;

    /**
     * 获取类泛型class
     * @return
     */
    public Class<Mapper> getMapperClass() {
        return (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
