package com.raoxiang.ioc.test;
import org.dom4j.Document;
import org.dom4j.Element;

import com.raoxiang.ioc.xml.ElementLoader;
import com.raoxiang.ioc.xml.ElementLoaderImpl;
import com.raoxiang.ioc.xml.XmlDocumentHolder;

import junit.framework.TestCase;

/**
* @Title XmlHolderTest
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 11:23:55 PM
* @version 1.0
*/
public class XmlHolderTest extends TestCase{

//    需要测试的对象
    XmlDocumentHolder holder;
    ElementLoader elementLoader;

    protected void setUp() throws Exception {
        holder = new XmlDocumentHolder();
        elementLoader = new ElementLoaderImpl();
    }

    protected void tearDown() throws Exception{
        holder = null;
        elementLoader = null;
    }
	
    public void testGetDoc(){
    	/*config路径 是文件路径，项目下的文件路径*/
        String filePath = "src/config/XmlHolder.xml";
//        String filePath = "config/XmlHolder.xml";
        //获取Document 对象
        Document doc = holder.getDocument(filePath);
        Element root = doc.getRootElement();
        System.out.println(root.getName());
        //重新取一次，判断两个Document的对象是否一致
        Document doc2 = holder.getDocument(filePath);
        System.out.println(doc);
        System.out.println(doc2);
    }

    public void testGetElements(){
        String filePath = "src/config/XmlHolder.xml";
        Document doc = holder.getDocument(filePath);
        elementLoader.addElements(doc);
        Element e = elementLoader.getElement("test1");
        System.out.println("element " + e);
        System.out.println("size " + elementLoader.getElements().size());
    }
    
}
