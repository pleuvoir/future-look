package com.pleuvoir.loader;

import com.pleuvoir.config.PropertyConfig;

public class BootstrapTest {

	public static void main(String[] args) {
		PropertyConfig ppc = Bootstrap.getBean(PropertyConfig.class);
		System.out.println(ppc.getName());
	}
}
