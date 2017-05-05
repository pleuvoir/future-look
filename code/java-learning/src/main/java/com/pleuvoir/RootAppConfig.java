package com.pleuvoir;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.pleuvoir.loader.ConfigLoader;
import com.pleuvoir.loader.XmlConfigLoader;

/**@author pleuvoir
 * 创建时间: 2017年5月4日 下午9:30:53
 */
@Configuration
@EnableScheduling
@PropertySource({"classpath:config.properties"})
@ComponentScan({"com.pleuvoir"})   //or @ComponentScan(basePackageClasses = RootAppConfig.class)
public class RootAppConfig {
	
	
	@Bean(name="configLoader", initMethod="load")
	public ConfigLoader getConfigLoader(){
		ConfigLoader loader = new XmlConfigLoader();
		loader.setLocation("classpath:config.xml");
		return loader;
	}
	
	
	@Bean
	@Description("ppc配置")
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
}
