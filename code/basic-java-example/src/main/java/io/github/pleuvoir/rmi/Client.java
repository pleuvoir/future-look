package io.github.pleuvoir.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) {
		try {
			// 如果没有指定主机名，则使用NULL作为主机名，指示应该使用本地主机地址。
			Registry registry = LocateRegistry.getRegistry(null);
			Service stub = (Service) registry.lookup("Service");
			String response = stub.sayHello("pleuvoir");
			System.out.println("response: " + response);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
