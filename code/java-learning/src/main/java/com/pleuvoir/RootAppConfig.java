package com.pleuvoir;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.pleuvoir.config.XmlConfig;
import com.pleuvoir.loader.ConfigLoader;
import com.pleuvoir.loader.XmlConfigLoader;
import com.pleuvoir.plugin.DefaultServicePlugin;
import com.pleuvoir.plugin.ServicePlugin;

/**@author pleuvoir
 * 创建时间: 2017年5月4日 下午9:30:53
 */
@Configuration
@EnableScheduling
@PropertySource({"classpath:config.properties"})
@ComponentScan({"com.pleuvoir"})   //or @ComponentScan(basePackageClasses = RootAppConfig.class)
public class RootAppConfig {
	
	
	@Bean(name="terminalServicePlugin", initMethod="load")
	public ServicePlugin getTerminalServicePlugin() throws ClassNotFoundException, IOException, DocumentException{
		DefaultServicePlugin plugin = new DefaultServicePlugin();
		plugin.setLocation("classpath:plugin/*.xml");
		return plugin;
	}
	
	
	/**
	 * 容器启动时映射xml文件属性到实体对象
	 * @return
	 */
	@Bean(name="configLoader", initMethod="load")
	public ConfigLoader getConfigLoader(){
		ConfigLoader loader = new XmlConfigLoader();
		loader.setLocation("classpath:config.xml");
		loader.setTargetClass(XmlConfig.class);
		return loader;
	}
	
	
	@Bean
	@Description("ppc配置")
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
}
