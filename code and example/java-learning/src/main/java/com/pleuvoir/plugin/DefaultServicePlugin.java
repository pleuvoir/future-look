package com.pleuvoir.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.google.common.collect.Maps;
import com.pleuvoir.common.AbstractLog;
import com.pleuvoir.common.enums.Dbtypes;

public class DefaultServicePlugin extends AbstractLog implements ServicePlugin {

	private static final String ELEM_TYPE = "type";
	private static final String ELEM_SERVICE = "service";
	private static final String ELEM_BEAN = "bean";
	
	private static final String ATTR_ID = "id";
	private static final String ATTR_CLASS = "class";
	
	private String location;
	
	private Map<Dbtypes,Class<?>> services = Maps.newConcurrentMap();
	
	
	@Override
	public void load() throws ClassNotFoundException, IOException, DocumentException {
		Resource[] resources = scanning();
		for (Resource res : resources) {
			InputStream in = res.getInputStream();
				logger.info("加载服务实现类：{}", res.getFile().getAbsolutePath());
				SAXReader reader = new SAXReader();
				Document doc = reader.read(in);
				Element root = doc.getRootElement();
				if(root==null)
					continue;
				Dbtypes type = parseType(root);
				putInto(type, root);
			}
		}		
	
	private Dbtypes parseType(Element rootElem){
		String type = rootElem.elementTextTrim(ELEM_TYPE);
		return Dbtypes.toEnum(type);
	}
	
	@SuppressWarnings("unchecked")
	private void putInto(Dbtypes type, Element rootElem) throws ClassNotFoundException {
		Element transElem = rootElem.element(ELEM_SERVICE);
		if(transElem==null)
			return;
		Iterator<Element> it = transElem.elementIterator(ELEM_BEAN);
		
		while(it.hasNext()){
			Element beanElem = it.next();
			String id = beanElem.attributeValue(ATTR_ID);
			String className = beanElem.attributeValue(ATTR_CLASS);
			
			services.put(type, Class.forName(className));
		}
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	public Resource[] scanning() {
		try {
			return ResourcePatternUtils
					.getResourcePatternResolver(new PathMatchingResourcePatternResolver())
					.getResources(location);
		} catch (IOException e) {
			logger.error("加载服务实现类失败: " + location, e);
		}
		return null;
	}

	@Override
	public Class<?> getServiceName(String dbType) {
		return services.get(Dbtypes.toEnum(dbType));
	}

}
