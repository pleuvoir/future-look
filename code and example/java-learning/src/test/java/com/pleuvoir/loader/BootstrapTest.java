package com.pleuvoir.loader;

import com.pleuvoir.plugin.ServicePlugin;

public class BootstrapTest {

	public static void main(String[] args) {
		ServicePlugin service = (ServicePlugin) Bootstrap.getBean("terminalServicePlugin");
		System.out.println(service.getServiceName("oracle"));
	}
}
