package com.raoxiang.ioc.context;

import java.util.List;

public interface BeanCreator{
    Object createBeanUseDefaultConstruct(String className);
    Object createBeanUseDefineConstruct(String className, List<Object> args);
}
