package com.pleuvoir.common;

import java.util.Date;

import org.junit.Test;

public class AbstractLogTest extends AbstractLog{

	@Test
	public void test() {
		logger.info("AbstractLog日志测试:{}",new Date());
	}

}
