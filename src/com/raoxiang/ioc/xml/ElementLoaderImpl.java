package com.raoxiang.ioc.xml;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

public class ElementLoaderImpl implements ElementLoader{
    //提供一个Map 来保存，Map的key为bean元素的id，value为bean对应的Element对象
    private Map<String, Element> elements = new HashMap<String, Element>();
    
    @SuppressWarnings("unchecked")
    public void addElements(Document doc){
        //读取根节点beans,再得到所有的bean节点
        List<Element> eles = doc.getRootElement().elements();
        for(Element e : eles){
            //得到bean 的id属性
            String id = e.attributeValue("id");
            //添加到map中
            elements.put(id, e);
        }
    }

    public Element getElement(String id){
        return elements.get(id);
    }

    public Collection<Element> getElements(){
        return this.elements.values();
    }
}
