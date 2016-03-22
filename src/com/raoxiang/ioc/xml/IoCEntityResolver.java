package com.raoxiang.ioc.xml;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
* @Title IoCEntityResolver
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 11:13:42 PM
* @version 1.0
*/
public class IoCEntityResolver implements EntityResolver {
    
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException{
        if("http://www.crazyit.org/beans.dtd".equals(systemId)){
        	/*从classpath获取资源,父目录为classpath*/
            InputStream stream = IoCEntityResolver.class.getResourceAsStream("/config/beans.dtd");
            return new InputSource(stream);
        }else{
            return null;
        }
    }
}
