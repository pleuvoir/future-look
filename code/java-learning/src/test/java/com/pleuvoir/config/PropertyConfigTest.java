package com.pleuvoir.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pleuvoir.base.BaseTest;

public class PropertyConfigTest extends BaseTest{

	@Autowired
	PropertyConfig ppc;
	
	@Test
	public void testGetName() {
		System.out.println(ppc.getName());
	}

	@Test
	public void testGetUri() {
		System.out.println(ppc.getUri());
	}

}
