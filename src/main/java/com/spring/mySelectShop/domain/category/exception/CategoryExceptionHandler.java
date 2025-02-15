package com.spring.mySelectShop.domain.category.exception;

import com.spring.mySelectShop.common.response.HttpResponse;
import com.spring.mySelectShop.domain.category.dto.CategoryDto;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryAlreadyExistsException;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryIsActiveBlankException;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryNameInvalidException;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 카테고리 도메인 전용 예외 처리 핸들러
 */
@Order(1)
@RestControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<HttpResponse<Void>> categoryNotFound(CategoryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new HttpResponse<>(CategoryExceptionCode.CATEGORY_NOT_FOUND, null)
        );
    }


    @ExceptionHandler(CategoryNameInvalidException.class)
    public ResponseEntity<HttpResponse<CategoryDto>> categoryNameInvalid(CategoryNameInvalidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new HttpResponse<>(CategoryExceptionCode.CATEGORY_NAME_INVALID, null)
        );
    }

    @ExceptionHandler(CategoryIsActiveBlankException.class)
    public ResponseEntity<HttpResponse<CategoryDto>> categoryIsActiveBlank(CategoryIsActiveBlankException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new HttpResponse<>(CategoryExceptionCode.CATEGORY_IS_ACTIVE_INVALID, null)
        );
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<HttpResponse<Void>> categoryAlreadyExists(CategoryAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new HttpResponse<>(CategoryExceptionCode.CATEGORY_ALREADY_EXISTS, null)
        );
    }

}
