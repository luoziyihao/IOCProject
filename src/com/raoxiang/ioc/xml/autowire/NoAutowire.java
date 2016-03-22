package com.raoxiang.ioc.xml.autowire;

public class NoAutowire implements Autowire{
    private String value;
    public NoAutowire(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
