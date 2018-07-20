package io.github.pleuvoir.rmi;

/**
 * 远程接口具体实现、
 * <br> 注意：方法本身可以不必抛出 {@link RemoteException} 异常 ， 该类可以也定义其他方法，但无法远程调用
 * @author pleuvoir
 *
 */
public class ServiceImpl implements Service {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public String sayByeBye(String name) {
		return "ByeBye " + name;
	}

}
