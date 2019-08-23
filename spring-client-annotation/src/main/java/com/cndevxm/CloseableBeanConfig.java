package com.cndevxm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Closeable;
import java.io.IOException;

@Configuration
public class CloseableBeanConfig {

	@Bean("myFirstCloseable")
	public Closeable myFirstCloseable() {
		return new Closeable() {
			@Override
			public void close() throws IOException {
				System.out.println("调用了第一个关闭方法");
			}
		};
	}

	@Bean("mySecondCloseable")
	public Closeable mySecondCloseable() {
		return new Closeable() {
			@Override
			public void close() throws IOException {
				System.out.println("调用了第二个关闭方法");
			}
		};
	}

	@Bean("myThirdCloseable")
	public AutoCloseable myThirdCloseable() {
		return new AutoCloseable() {
			@Override
			public void close() throws IOException {
				System.out.println("调用了第三个关闭方法");
			}
		};
	}
}
