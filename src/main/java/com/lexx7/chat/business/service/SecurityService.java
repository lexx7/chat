package com.lexx7.chat.business.service;


public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
