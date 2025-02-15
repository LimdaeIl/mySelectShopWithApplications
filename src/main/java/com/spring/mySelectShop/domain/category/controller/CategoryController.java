package com.spring.mySelectShop.domain.category.controller;

import static com.spring.mySelectShop.domain.category.dto.CategoryResponseCode.CATEGORY_CREATED;
import static com.spring.mySelectShop.domain.category.dto.CategoryResponseCode.CATEGORY_FETCHED;

import com.spring.mySelectShop.common.response.HttpResponse;
import com.spring.mySelectShop.domain.category.dto.CategoryDto;
import com.spring.mySelectShop.domain.category.dto.CategoryResponseCode;
import com.spring.mySelectShop.domain.category.dto.request.CreateCategoryRequestDto;
import com.spring.mySelectShop.domain.category.dto.request.UpdateCategoryRequestDto;
import com.spring.mySelectShop.domain.category.service.CategoryService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<HttpResponse<CategoryDto>> createCategory(
            @RequestBody @Valid CreateCategoryRequestDto requestDto) {
        return new ResponseEntity<>(
                new HttpResponse<>(CATEGORY_CREATED,
                        categoryService.createCategory(requestDto)),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<HttpResponse<Page<CategoryDto>>> getAllCategories(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") Boolean isAsc) {

        return ResponseEntity.ok(new HttpResponse<>(CategoryResponseCode.CATEGORIES_FETCHED,
                categoryService.getAllActiveCategories(page - 1, size, sortBy, isAsc)
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse<CategoryDto>> getCategoryById(@PathVariable UUID id) {
        return new ResponseEntity<>(
                new HttpResponse<>(CATEGORY_FETCHED, categoryService.getCategoryById(id)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse<CategoryDto>> deleteCategoryById(@PathVariable UUID id) {
        return new ResponseEntity<>(
                new HttpResponse<>(CategoryResponseCode.CATEGORY_DELETED,
                        categoryService.deleteCategoryById(id)),
                HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpResponse<CategoryDto>> updateCategoryByName(@PathVariable UUID id,
            @RequestBody UpdateCategoryRequestDto requestDto) {
        return new ResponseEntity<>(
                new HttpResponse<>(CategoryResponseCode.CATEGORY_UPDATED,
                        categoryService.updateCategoryByName(id, requestDto)),
                HttpStatus.OK);
    }
}
