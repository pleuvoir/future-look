eclipse生成junit

### 导入依赖
```
<!-- spring-test依赖 方便junit做spring单元测试 -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>4.1.7.RELEASE</version>
</dependency>

<!-- 使用junit4支持注解  而junit3使用编程方式-->
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.11</version>
  <scope>test</scope>
</dependency>
```

### 生成junit测试

![](http://i.imgur.com/pwLtP7p.png)
![](http://i.imgur.com/LAJnqgZ.png)
![](http://i.imgur.com/goV960s.png)
![](http://i.imgur.com/eaaRUT7.png)

### 添加spring-test支持
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({   ////扫描spring配置文件
				"classpath:spring.xml",
				"classpath:spring-mybatis.xml"})
public class SeckillServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//自动注入
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testQueryAll() {
		
		List<Seckill> seckillList = seckillService.queryAll();
		logger.info(JSON.toJSONString(seckillList));
	}

}
```


