package com.lexx7.chat.model.list;


public enum Color {
    BLACK("Чёрный"),
    RED("Красный"),
    BLUE("Синий"),
    GREEN("Зелёный");

    private String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
