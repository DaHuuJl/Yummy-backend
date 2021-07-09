package com.yummy.restful.model.enums;

import lombok.Getter;

@Getter
public enum ProductType {

    PIZZA("Пицца"),
    DRINKS("Напитки"),
    SNACKS("Закуски"),
    BANNER("Баннер"),
    BACKGROUND("Фон");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }
}