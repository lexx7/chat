package com.lexx7.chat.business.service;


import com.lexx7.chat.model.entity.Message;
import com.lexx7.chat.model.entity.User;

import java.util.List;

public interface MessageService {

    Long createMessage(Message message);

    void removeAddress(Long id);

    Message getMessage(Long id);

    List<Message> getList(Integer page, Integer limit, String sidx, String sord, User user);
}
