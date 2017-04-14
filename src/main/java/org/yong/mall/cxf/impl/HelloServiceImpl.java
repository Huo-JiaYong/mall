package org.yong.mall.cxf.impl;

import javax.jws.WebService;

import org.yong.mall.cxf.HelloService;

@WebService(serviceName = "HelloService", endpointInterface = "org.yong.mall.cxf.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("hello " + name);
		return "hello " + name;
	}

}
