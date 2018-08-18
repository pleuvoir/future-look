package com.pleuvoir.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pleuvoir.RootAppConfig;

/**@author pleuvoir
 * junit测试基类
 * 创建时间: 2017年5月4日 下午10:40:01
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootAppConfig.class})
public abstract class TestBase {

}
