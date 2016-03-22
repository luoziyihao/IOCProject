package com.raoxiang.ioc.xml;

import java.util.List;

import org.dom4j.Element;

import com.raoxiang.ioc.xml.autowire.Autowire;
import com.raoxiang.ioc.xml.construct.DataElement;
import com.raoxiang.ioc.xml.property.PropertyElement;

public interface ElementReader {
    //判断一个bean元素是否要延迟加载
    boolean isLazy(Element element);
    //获得一个bean元素下的constructor-arg
    List<Element> getConstructorElements(Element element);
    //得到元素属性为name的属性值
    String getAttribute(Element element, String name);
    //判断一个元素是否为单例
    boolean isSingleton(Element element);
    //活动一个bean元素下的所有property
    List<Element> getPropertyElements(Element element);
    //返回一个bean元素对应的Autowire对象
    Autowire getAutowire(Element element);
    //获取bean元素下所有constuctor-arg的值（包括vlaue和ref）
    List<DataElement> getConstructorValue(Element element);
    //获取bean元素下的所有的property元素的值(包括value和ref)
    List<PropertyElement> getPropertyValue(Element element);
}
