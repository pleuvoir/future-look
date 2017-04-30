
## 单独使用log4j

### 添加maven坐标
```xml
<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency> 
```	

### 配置log4j.properties
```java
log4j.rootLogger=INFO, Console

#Console
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.layout=org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n

log4j.logger.java.sql.ResultSet=INFO
log4j.logger.org.apache=INFO
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG 
```
这只是基础配置 详细配置参照官方文档
### 声明日志对象
```java
private final Logger logger = Logger.getLogger(this.getClass());
```
### 尝试输出
```
logger.info("log4j test");
```

### 结果
![](http://i.imgur.com/yjl8RjS.png)


## slf4j+log4j
### 添加maven坐标
```xml
  <dependency>  
      <groupId>org.slf4j</groupId>  
      <artifactId>slf4j-log4j12</artifactId>  
      <version>1.7.2</version>  
  </dependency>  
```
查看pom依赖发现多了如下3个jar包

![](http://i.imgur.com/OScv3oY.png)

接着配置配置log4j.properties,同上

### 代码中添加

这里和单独使用log4j有所不同,使用slf4j提供的接口,
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private final Logger logger = LoggerFactory.getLogger(this.getClass());
```
输出方式同上
```
logger.info("log4j test");
```


完成logger的日志输出以供备忘