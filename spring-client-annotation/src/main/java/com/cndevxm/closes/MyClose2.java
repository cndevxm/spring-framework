package com.cndevxm.closes;

import org.springframework.stereotype.Component;

@Component
public class MyClose2 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("调用了销毁方法2");
	}

	public MyClose2() {
		System.out.println("实例化MyClose2");
	}
}
