package com.cndevxm.aop;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IntroductionServiceImpl extends DelegatingIntroductionInterceptor implements IntroductionService {

	@Override
	public String decrypt(String str) {
		System.out.println("对数据进行解密");
		return "";
	}

	@Override
	public String encrypt(String str) {
		System.out.println("对数据进行加密");
		return "";
	}
}
