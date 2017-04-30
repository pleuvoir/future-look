## logback

### maven坐标
```xml
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
	<version>1.2.1</version>
</dependency>
```


### logback.xml
将文件放在根目录下并且不要改名字 默认只识别`logback.xml`或者 `logback-test.xml`
```xml
<?xml version="1.0"?>  
<configuration>  
    <!-- ch.qos.logback.core.ConsoleAppender 控制台输出 -->  
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">  
        <encoder>  
            <pattern>[%-5level] %d{HH:mm:ss.SSS} [%thread] %logger{36} - %msg%n</pattern>  
        </encoder>  
    </appender>  
  
    <!-- 日志级别 -->  
    <root level="DEBUG">  
       <level value="INFO" />    
      <appender-ref ref="console" />  
    </root>  
  
</configuration>   
```

### java
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private static Logger logger = LoggerFactory.getLogger(GenerateHelp.class);
//使用占位符
logger.info("db.url:{}",Constant.DB_URL);
```