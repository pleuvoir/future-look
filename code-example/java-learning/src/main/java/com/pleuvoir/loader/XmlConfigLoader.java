package com.pleuvoir.loader;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.pleuvoir.common.AbstractLog;
import com.pleuvoir.config.XmlConfig;

public class XmlConfigLoader extends AbstractLog implements ConfigLoader {

	
	private Resource res;
	private String location;
	private XmlConfig config;
	
	@Override
	public void setLocation(String location) {
		this.location = location;
		this.res = ResourcePatternUtils.getResourcePatternResolver(new PathMatchingResourcePatternResolver()).getResource(location);
		if(!res.exists()){
			logger.error("无效的配置路径：" + location);
			System.exit(1);
		}
	}

	@Override
	public void load() {
		InputStream input = null;
		try {
			input = res.getInputStream();
			JAXBContext context = JAXBContext.newInstance(XmlConfig.class);
			Object configObj = context.createUnmarshaller().unmarshal(input);
			config = (XmlConfig)configObj;
			logger.info("加载配置完成：{}", location);
		} catch (JAXBException | IOException e) {
			logger.error("加载配置失败：" + location, e);
			System.exit(1);
		} 
	}

	@Override
	public XmlConfig get() {
		return config;
	}


}
