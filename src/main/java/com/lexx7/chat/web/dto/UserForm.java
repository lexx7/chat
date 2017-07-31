package com.lexx7.chat.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserForm {

    private String id;

    @NotNull(message = "Имя должно быть заполнено")
    @Pattern(regexp = "^[a-zA-Z0-9а-яА-Я]+$", message = "Недопустимый логин. Рарешены символы: a-zA-Z0-9а-яА-Я")
    @Size(min = 3, max = 255, message = "Логин должен содержать от 3 до 255 символов")
    private String login;

    @NotNull(message = "Цвет должен быть выбран")
    private String color;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", color='" + color + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

