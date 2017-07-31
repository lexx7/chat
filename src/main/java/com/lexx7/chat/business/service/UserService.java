package com.lexx7.chat.business.service;

import java.util.List;

import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.web.dto.UserForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	List<User> getAllUsers();
	
	Long createUser(User user);

	void updateUser(User user);

	User getUser(Long id);
	
	User getUserByLogin(String login);

	User save(UserForm userForm);
}
