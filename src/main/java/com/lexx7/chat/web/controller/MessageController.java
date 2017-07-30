package com.lexx7.chat.web.controller;


import com.lexx7.chat.business.service.MessageService;
import com.lexx7.chat.business.service.UserService;
import com.lexx7.chat.model.entity.Message;
import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.web.dto.MessageForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("message")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public String submitSendMessageForm(@Valid MessageForm messageForm, BindingResult result) {
        LOGGER.debug("submit SendMessageForm: " + messageForm.toString());

        if (!result.hasErrors()) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // Select only current authentication user
            User user = new User();
            if (authentication != null && authentication.isAuthenticated() && authentication.getName() != "anonymousUser") {
                user = userService.getUserByLogin(authentication.getName());
            }

            Message message = mapMessageFormToMessage(messageForm);
            message.setToUser(user);
            messageService.createMessage(message);

            return "message-send";
        } else {
            LOGGER.debug("submit SendMessageForm error: " + result.toString());
            return "message-send";
        }
    }

    private Message mapMessageFormToMessage(MessageForm messageForm) {

        Message message = new Message();
        message.setId(messageForm.getId() == null || messageForm.getId().isEmpty() ? null :
                Long.valueOf(messageForm.getId()));
//        message.setToUser(new User(Long.valueOf(messageForm.getUserTo())));
        message.setMessage(messageForm.getMessage());

        return message;
    }
}
