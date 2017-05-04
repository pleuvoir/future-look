package com.pleuvoir;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**@author pleuvoir
 * 创建时间: 2017年5月4日 下午9:30:53
 */
@Configuration
@EnableScheduling
@PropertySource({"classpath:config.properties"})
@ComponentScan({"com.pleuvoir"})   //or @ComponentScan(basePackageClasses = RootAppConfig.class)
public class RootAppConfig {
	
	//ppc配置
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
}
