package io.github.pleuvoir.rmi;

import java.rmi.Remote;

/**
 * 定义远程接口
 * <p> 1. 必须继承 {@link java.rmi.Remote} 接口
 * <p> 2. 每个方法必须抛出  {@link java.rmi.RemoteException} 异常或者其父类异常，当然其他应用程序异常也可抛出
 * @author pleuvoir
 *
 */
public interface Service extends Remote {
	
	String sayHello(String name) throws java.rmi.RemoteException;
	
	String sayByeBye(String name) throws java.rmi.RemoteException;
}
