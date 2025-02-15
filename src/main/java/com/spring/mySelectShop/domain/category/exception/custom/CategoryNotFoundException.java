package com.spring.mySelectShop.domain.category.exception.custom;

public class CategoryNotFoundException extends RuntimeException  {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
