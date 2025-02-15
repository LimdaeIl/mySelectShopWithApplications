package com.spring.mySelectShop.domain.category.exception.custom;

public class CategoryNameInvalidException extends RuntimeException {

    public CategoryNameInvalidException(String message) {
        super(message);
    }
}
