package com.cndevxm.service.impl;

import com.cndevxm.service.AuthService;
import org.apache.commons.lang3.StringUtils;

public class AuthServiceImpl implements AuthService {

	@Override
	public String login(String username, String password) {

		String result;
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			throw new IllegalArgumentException("用户名或者密码为空");
		} else if ("123".equals(username) && "123".equals(password)) {
			result = "校验通过";
		} else {
			result = "校验失败";
		}
		return result;
	}
}
