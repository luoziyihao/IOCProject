package com.raoxiang.ioc.xml.property;

import com.raoxiang.ioc.xml.construct.DataElement;

public class PropertyElement{

    //property元素的name属性值
    private String name;
    //property元素下的ref或者value属性对象
    private DataElement dataElement;
    public PropertyElement(String name, DataElement dataElement){
        this.name = name;
        this.dataElement = dataElement;
   }

   public void setName(String name){
       this.name = name;
   }

   public void setDataElement(DataElement dataElement){
       this.dataElement= dataElement;
   }

   public String getName(){
       return this.name;
   }

   public DataElement getDataElement(){
       return this.dataElement;
   }
}
