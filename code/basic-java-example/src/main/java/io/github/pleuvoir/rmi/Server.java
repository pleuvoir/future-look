package io.github.pleuvoir.rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 服务端
 * <p> 1. 导出远程对象
 * <p> 2. 将该实例绑定到Java RMI注册表中
 * @author pleuvoir
 *
 */
public class Server {

	//  一旦远程对象在服务器上注册，调用方可以按名称查找对象，获取远程对象引用，然后调用对象上的远程方法。
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		try {
			Remote stub = UnicastRemoteObject.exportObject(service, 0);
			// Stub（存根） 可以理解为方法的描述，从而让 Client 知道 Server 提供了哪些方法及参数
			// 然后起名并绑定到 RMI 注册表中
			
			//注意：对LocateRegistry.getRegistry的调用只返回注册表的适当存根。
			// 该调用不检查是否注册注册表正在运行。如果调用绑定方法时本地主机的TCP端口1099上没有注册表运行，则服务器将以ReleExtExchange失败。
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Service", stub);
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
}
