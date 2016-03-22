package com.raoxiang.ioc.xml.construct;

public class RefElement implements DataElement{
    private Object value;
    public RefElement(Object value){
        this.value = value;
    }

    public String getType(){
        return "ref";
    }

    public Object getValue(){
        return this.value;
    }

}
