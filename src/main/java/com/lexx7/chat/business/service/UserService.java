package com.lexx7.chat.business.service;

import java.util.List;

import com.lexx7.chat.model.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	Long createUser(User user);

	void updateUser(User user);

	User getUser(Long id);
	
	User getUserByLogin(String login);
}
