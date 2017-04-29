# spring读取配置文件

如果使用xml形式则set注入的时候可以比较灵活的改变值,使用注解形式虽然可以设置默认值,但是不可在`${}`中传入非static的值;也就是说不可以用其他方法的返回值作为参数 


### config.properties ###
```java
tablename=EMP
entityname=
```

## 1. 基于xml ##
* ### spring-core.xml
	```java
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xmlns:context="http://www.springframework.org/schema/context"
	       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
	            			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd">
	
	    <!-- 配置注解扫描 -->
	    <context:component-scan base-package="com.pleuvoir"/>
		<context:property-placeholder location="classpath*:config/*.properties" />
		
		<bean class="com.pleuvoir.utils.AppConfig">
			<property name="tableName" value="${tablename}" />
			<property name="entityName" value="${entityname}" />
		</bean>
	</beans>
	```
* ### pojo
	```java
	public class AppConfig {
	
		private String tableName;
		
		private String entityName;
	
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
	
		public void setEntityName(String entityName) {
			//set defaultValue
			if(entityName.equals("")){
				this.entityName = "defaultValue";
				return;
			}
			this.entityName = entityName;
		}
	
		@Override
		public String toString() {
			return "AppConfig [tableName=" + tableName + ", entityName=" + entityName + "]";
		}
		
	}
	```
## 2. 基于注解 ##	
* ### spring-core.xml 
	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
            			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd">

    <!-- 配置注解扫描 -->
    <context:component-scan base-package="com.pleuvoir"/>
	<!-- ppc location -->
	<context:property-placeholder location="classpath*:config/*.properties" />
	</beans>
	```
* ### pojo 
	```java
	@Component
	public class AppConfig {
	
		@Value("${tablename}")
		private String tableName;
		
		@Value("${entityname?:defaultValue}")
		private String entityName;
		
		public String getTableName() {
			return tableName;
		}
	
		public String getEntityName() {
			return entityName;
		}

		@Override
		public String toString() {
			return "AppConfig [tableName=" + tableName + ", entityName=" + entityName + "]";
		}
	}	
	```
* ### 测试
	```java
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/app-core.xml"});
		AppConfig config = context.getBean(AppConfig.class);
		System.out.println(config.toString());
		context.close();
		//output AppConfig [tableName=EMP, entityName=defaultValue]
	```

