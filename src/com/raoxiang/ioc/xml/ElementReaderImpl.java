package com.raoxiang.ioc.xml;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.raoxiang.ioc.xml.autowire.Autowire;
import com.raoxiang.ioc.xml.autowire.ByNameAutowire;
import com.raoxiang.ioc.xml.autowire.NoAutowire;
import com.raoxiang.ioc.xml.construct.DataElement;
import com.raoxiang.ioc.xml.construct.RefElement;
import com.raoxiang.ioc.xml.construct.ValueElement;
import com.raoxiang.ioc.xml.property.PropertyElement;

public class ElementReaderImpl implements ElementReader{ 
    public boolean isLazy(Element element){
        //获得lazy-init属性值
        String lazy = getAttribute(element, "lazy-init");
        Element parent = element.getParent();
        //获得父节点beans的default-lazy-init属性值
        Boolean parentLazy = new Boolean(getAttribute(parent, "default-lazy-init"));
        if(parentLazy){
            //beans节点需要延迟加载
            if("false".equals(lazy))return false;
            return true;
        }else{
            //根节点不需要延迟加载
            if("true".equals(lazy))return true;
            return false;
        }
    }

    public String getAttribute(Element element, String name){
        String value = element.attributeValue(name);
        return value;
    }

    @SuppressWarnings("unchecked")
    public List<Element> getConstructorElements(Element element){
        List<Element> children = element.elements();
        List<Element> result = new ArrayList<Element>();
        for(Element e : children){
            if("constructor-arg".equals(e.getName())){
                result.add(e);
            }
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public List<Element> getPropertyElements(Element element){
        List<Element> children = element.elements();
        List<Element> result = new ArrayList<Element>();
        for(Element e : children){
            if("property".equals(e.getName())){
                result.add(e);
            }
        }
        return result;
    }

    public boolean isSingleton(Element element){
        Boolean singleton = new Boolean(getAttribute(element, "singleton"));
        return singleton;
    }

    public Autowire getAutowire(Element element){
        String value = this.getAttribute(element, "autowire");
        String parentValue = this.getAttribute(element.getParent(), "default-autowire");
        if("no".equals(parentValue)){
            if("byName".equals(value)) return new ByNameAutowire(value);
            return new NoAutowire(value);
        }else if("byName".equals(parentValue)){
            if("no".equals(value))return new NoAutowire(value);
            return new ByNameAutowire(value);
        }
        return new NoAutowire(value);
    }

    
    @SuppressWarnings("unchecked")
    public List<DataElement> getConstructorValue(Element element){
        List<Element> cons = getConstructorElements(element);
        List<DataElement> result = new ArrayList<DataElement>();
        for(Element e : cons){
            List<Element> els = e.elements();
            DataElement dataElement = getDataElement(els.get(0));
            result.add(dataElement);
        }
        return result;
    }

   private DataElement getDataElement(Element dataElement){
        String name = dataElement.getName();
        if("value".equals(name)){
            String classTypeName = dataElement.attributeValue("type");
            String data = dataElement.getText();
            return new ValueElement(getValue(classTypeName, data));
        }else if("ref".equals(name)){
            return new RefElement(this.getAttribute(dataElement, "bean"));
        }
        return null;
    }

    private Object getValue(String className, String data){
        if(isType(className, "Integer")){
            return Integer.parseInt(data);
        }else if(isType(className,"Boolean")){
            return Boolean.parseBoolean(className);
        }else if(isType(className,"Long")){
            return Long.parseLong(className);
        }else if(isType(className,"Short")){
            return Short.parseShort(className);
        }else if(isType(className,"Double")){
            return Double.parseDouble(className);
        }else if(isType(className,"Float")){
            return Float.parseFloat(className);
        }else if(isType(className,"Character")){
            return className.toCharArray()[0];
        }else if(isType(className,"Byte")){
            return Byte.parseByte(className);
        }else{
            return data;
        }
    }

    private boolean isType(String className, String type){
        if(className.indexOf(type) != -1)return true;
        return false;
    }

    
    @SuppressWarnings("unchecked")
    public List<PropertyElement> getPropertyValue(Element element){
        List<Element> properties = getPropertyElements(element);
        List<PropertyElement> result = new ArrayList<PropertyElement>();
        for(Element e : properties){
            List<Element> els = e.elements();
            DataElement dataElement = getDataElement(els.get(0));
            String propertyNameAtt = this.getAttribute(e, "name");
            PropertyElement pe = new PropertyElement(propertyNameAtt, dataElement);
            result.add(pe);
        }
        return result;
    }
}