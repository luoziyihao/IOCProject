package com.raoxiang.ioc.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.raoxiang.ioc.context.BeanCreator;
import com.raoxiang.ioc.context.BeanCreatorImpl;
import com.raoxiang.ioc.context.object.BeanCreatorObject1;
import com.raoxiang.ioc.context.object.BeanCreatorObject2;

/**
* @Description
* @Copyright: Copyright (c) 2016 
* @Create Date: 2016-3-21 
* @Company: CITIC BANK 
* @author raoxiang
* @version $Id: BeanCreatorTest.java v 1.0 2016-3-21 下午04:28:21 raoxiang Exp $
*/
public class BeanCreatorTest extends TestCase{

    BeanCreator creator;

	protected void setUp() throws Exception{
	    creator = new BeanCreatorImpl();
	}
	
	protected void tearDown() throws Exception{
	    creator = null;	
	}
	
    public void testCreateBeanUseDefaultConstruct(){
        String className = "com.raoxiang.ioc.context.object.BeanCreatorObject2";
        BeanCreatorObject2 obj = (BeanCreatorObject2)creator.createBeanUseDefaultConstruct(className);
        System.out.println(obj);
        System.out.println(obj.getName());
        System.out.println(obj.getName());
    }

	public void testCreateBeanUseDefineConstruct(){
        String className = "com.raoxiang.ioc.context.object.BeanCreatorObject1";
        List<Object> args = new ArrayList<Object>();
        args.add("nametest");
        args.add("valueTest");
        BeanCreatorObject1 obj = (BeanCreatorObject1)creator.createBeanUseDefineConstruct(className, args);
        System.out.println(obj.getName());
        System.out.println(obj.getValue());
	}
}
