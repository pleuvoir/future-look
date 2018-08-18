package com.pleuvoir.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**@author pleuvoir
 * 抽象日志
 * 创建时间: 2017年5月4日 下午11:07:19
 */
public abstract class AbstractLog {
	  protected Logger logger;
	  public AbstractLog(){
		  logger =  LoggerFactory.getLogger(this.getClass());
	  }
}
