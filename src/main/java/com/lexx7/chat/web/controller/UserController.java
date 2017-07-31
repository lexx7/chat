package com.lexx7.chat.web.controller;


import javax.validation.Valid;


import com.lexx7.chat.business.service.SecurityService;
import com.lexx7.chat.web.map.UserMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lexx7.chat.business.service.UserService;
import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.web.dto.UserForm;


@Controller
@RequestMapping("autologin")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

//    @Autowired
//    @Qualifier("passwordEncoder")
//    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String autologin(Model model) {
        LOGGER.debug("show new userForm");

        model.addAttribute("userForm", new UserForm());

        return "autologin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String autologin(@Valid UserForm userForm, BindingResult result) {
        LOGGER.debug("submit SendUserForm: " + userForm.toString());

        if (result.hasErrors()) {
            return "autologin";
        }

        userForm.setPassword("");
        User user = userService.save(userForm);

        securityService.autologin(user.getLogin(), user.getPassword());

        return "redirect:/";
    }
}
