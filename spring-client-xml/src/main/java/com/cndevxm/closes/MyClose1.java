package com.cndevxm.closes;

import java.io.Closeable;
import java.io.IOException;

public class MyClose1 implements Closeable {

	@Override
	public void close() throws IOException {
		System.out.println("调用了销毁方法1");
	}

	public MyClose1() {
		System.out.println("实例化MyClose1");
	}
}
