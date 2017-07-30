package com.lexx7.chat.web.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Time;

public class MessageForm {

    private String id;

    @NotNull(message = "Сообщение не должно быть пустым")
    @Size(max = 2000, message = "Сообщение не должно быть длиннее 2000 символов")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageForm{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
