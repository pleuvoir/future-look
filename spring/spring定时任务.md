# spring定时任务

spring定时任务支持 使用Cron expression


## 1.基于xml
* ### app-task.xml
	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xmlns:context="http://www.springframework.org/schema/context"
	       xmlns:task="http://www.springframework.org/schema/task"
	       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
	            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd
	           	http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.1.xsd">
	
	    <context:component-scan base-package="com.pleuvoir"/>
	    <task:scheduler id="taskScheduler" pool-size="100" /> 
	    <task:scheduled-tasks scheduler="taskScheduler">
		<!-- 每半分钟触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute1" cron="30 * * * * ?" />
		<!-- 每小时的10分30秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute2" cron="30 10 * * * ?" />
		<!-- 每天1点10分30秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute3" cron="30 10 1 * * ?" />
		<!-- 每月20号的1点10分30秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute4" cron="30 10 1 20 * ?" />
		<!-- 每年10月20号的1点10分30秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute5" cron="30 10 1 20 10 ?" />
		<!-- 每15秒、30秒、45秒时触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute6" cron="15,30,45 * * * * ?" />
		<!-- 15秒到45秒每隔1秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute7" cron="15-45 * * * * ?" />
		<!-- 每分钟的每15秒时任务任务，每隔5秒触发一次 -->
		<task:scheduled ref="shedulerTasks" method="execute8" cron="15/5 * * * * ?" />
		<!-- 每分钟的15到30秒之间开始触发，每隔5秒触发一次 -->
		<task:scheduled ref="shedulerTasks" method="execute9" cron="15-30/5 * * * * ?" />
		<!-- 每小时的0分0秒开始触发，每隔3分钟触发一次 -->
		<task:scheduled ref="shedulerTasks" method="execute10" cron="0 0/3 * * * ?" />
		<!-- 星期一到星期五的10点15分0秒触发任务 -->
		<task:scheduled ref="shedulerTasks" method="execute11" cron="0 15 10 ? * MON-FRI" />
	    </task:scheduled-tasks> 
	</beans>
	```
* ### 定时任务业务类
	```java
	/**
	 * 定时任务逻辑
	 */
	@Component("shedulerTasks")
	public class ShedulerTasks {
		
		private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
		private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
		public void execute1() {
			logger.info("Task: 1, Current time: {}", format.format(new Date()));
		}
	
		public void execute2() {
			logger.info("Task: 2, Current time: {}", format.format(new Date()));
		}
	
		public void execute3() {
			logger.info("Task: 3 Current time: {}", format.format(new Date()));
		}
	
		public void execute4() {
			logger.info("Task: 4, Current time: {}", format.format(new Date()));
		}
	
		public void execute5() {
			logger.info("Task: 5, Current time: {}", format.format(new Date()));
		}
	
		public void execute6() {
			logger.info("Task: 6, Current time: {}", format.format(new Date()));
		}
	
		public void execute7() {
			logger.info("Task: 7, Current time: {}", format.format(new Date()));
		}
	
		public void execute8() {
			logger.info("Task: 8, Current time: {}", format.format(new Date()));
		}
	
		public void execute9() {
			logger.info("Task: 9, Current time: {}", format.format(new Date()));
		}
	
		public void execute10() {
			logger.info("Task: 10, Current time: {}", format.format(new Date()));
		}
	
		public void execute11() {
			logger.info("Task: 11, Current time: {}", format.format(new Date()));
		}
	
	}
	```

## 2.基于注解
* ### app-task.xml
	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xmlns:context="http://www.springframework.org/schema/context"
	       xmlns:task="http://www.springframework.org/schema/task"
	       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
	            			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd
	           				http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.1.xsd">
	
	    <context:component-scan base-package="com.pleuvoir"/>
	</beans>
	```
* ### 配置
  1. 启用定时任务
	```java
	 @Configuration
	 @EnableScheduling
	 public class MyConfig {
	     // Here it goes your configuration
	 }
	```
  2. 定时任务业务类
	```java
	@Component
	public class Scheduler {
	    @Scheduled(cron = "*/1 * * * * *")
	    public void excute() {
	    	System.out.println("hello world");
	    }
	}
	
	```

**Cron表达式:**
![](http://i.imgur.com/4berq03.png)