package com.lexx7.chat.web.controller;


import javax.validation.Valid;


import com.lexx7.chat.web.map.UserMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lexx7.chat.business.service.UserService;
import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.web.dto.UserForm;


@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public UserForm showUserForm() {
    	LOGGER.debug("show new userForm");

        return new UserForm();
    }

	@RequestMapping(method = RequestMethod.POST)
    public String submitNewUserForm(@Valid UserForm userForm, BindingResult result) {
    	LOGGER.debug("submitNewUserForm: " + String.valueOf(userForm));
    	if (!result.hasErrors()) {
    		User user = UserMap.mapUserFormToUser(userForm);
    		user.setPassword(passwordEncoder.encode(""));
            userService.createUser(user);
            // Redirect to the user after create successful
            return "redirect:/";
    	} else {
    		LOGGER.debug("submitNewUserForm error: " + result.toString());
    		return "user";
    	}
    }
}
