package com.cndevxm.service;

public interface AuthService extends BaseService {

	String login(String username, String password);

	String logout(String username);
}
