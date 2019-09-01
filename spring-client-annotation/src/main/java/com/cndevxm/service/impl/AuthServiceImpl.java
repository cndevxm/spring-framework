package com.cndevxm.service.impl;

import com.cndevxm.aop.InDto;
import com.cndevxm.aop.annotation.Mark;
import com.cndevxm.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Mark
@Service("authService")
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

	@Override
	@Mark
	public String logout(String username) {
		String result;
		if (!"123".equals(username)) {
			result = "无此用户";
		} else {
			result = "退出成功";
		}
		return result;
	}

	@Override
	public String login(InDto inDto) {

		String result;
		if (StringUtils.isBlank(inDto.getUsername()) || StringUtils.isBlank(inDto.getPassword())) {
			throw new IllegalArgumentException("用户名或者密码为空");
		} else if ("123".equals(inDto.getUsername()) && "123".equals(inDto.getPassword())) {
			result = "校验通过";
		} else {
			result = "校验失败";
		}
		return result;
	}
}
