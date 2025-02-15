package com.spring.mySelectShop.domain.category.exception.custom;

public class CategoryIsActiveBlankException extends RuntimeException {

    public CategoryIsActiveBlankException(String message) {
        super(message);
    }
}
