package com.lexx7.chat.web.map;

import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.web.dto.UserForm;


public class UserMap {

    public static User mapUserFormToUser(UserForm userForm) {

        User user = new User();
        user.setId(userForm.getId() == null || userForm.getId().isEmpty() ? null : Long.valueOf(userForm.getId()));
        user.setLogin(userForm.getLogin());
        user.setColor(userForm.getColor());

        return user;
    }
}
