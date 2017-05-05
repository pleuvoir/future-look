package com.pleuvoir.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pleuvoir.base.BaseTest;
import com.pleuvoir.loader.Bootstrap;
import com.pleuvoir.loader.ConfigLoader;

public class XmlConfigTest extends BaseTest{

	@Autowired
	ConfigLoader configLoader;
	@Test
	public void test() {
		/*XmlConfig config = Bootstrap.getConfig();
		config.printJson();*/
		configLoader.get().printJson();
	}

	
	public static void main(String[] args) {
		//ConfigLoader bean = (ConfigLoader) Bootstrap.getBean("ConfigLoader");
		ConfigLoader bean = Bootstrap.getBean(ConfigLoader.class);
		bean.get().printJson();
	}
}
