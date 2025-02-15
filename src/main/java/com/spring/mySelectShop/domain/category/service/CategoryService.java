package com.spring.mySelectShop.domain.category.service;

import static com.spring.mySelectShop.domain.category.entity.Category.create;

import com.spring.mySelectShop.domain.category.dto.CategoryDto;
import com.spring.mySelectShop.domain.category.dto.request.CreateCategoryRequestDto;
import com.spring.mySelectShop.domain.category.dto.request.UpdateCategoryRequestDto;
import com.spring.mySelectShop.domain.category.entity.Category;
import com.spring.mySelectShop.domain.category.exception.CategoryExceptionCode;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryAlreadyExistsException;
import com.spring.mySelectShop.domain.category.exception.custom.CategoryNotFoundException;
import com.spring.mySelectShop.domain.category.repository.CategoryRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    private void validateCategoryNameDuplication(String name) {
        if (categoryRepository.existsByName(name)) {
            throw new CategoryAlreadyExistsException(name);
        }
    }

    public CategoryDto createCategory(CreateCategoryRequestDto requestDto) {
        validateCategoryNameDuplication(requestDto.name());

        Category category = create(requestDto.name(), requestDto.isActive());
        categoryRepository.save(category);

        return CategoryDto.fromEntity(category);
    }

    @Transactional(readOnly = true)
    public Page<CategoryDto> getAllActiveCategories(Integer page, Integer size, String sortBy,
            Boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Category> categoryPage = categoryRepository.findAllByIsActiveTrue(pageable);

        return categoryPage.map(CategoryDto::fromEntity);
    }

    @Transactional(readOnly = true)
    public CategoryDto getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id: " + id + " not found!"));
        return CategoryDto.fromEntity(category);
    }

    @Transactional
    public CategoryDto deleteCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id: " + id + " not found!"));

        category.update(category.getName(), false);
        return CategoryDto.fromEntity(category);
    }

    @Transactional
    public CategoryDto updateCategoryByName(UUID id, UpdateCategoryRequestDto requestDto) {
        validateCategoryNameDuplication(requestDto.name());

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        CategoryExceptionCode.CATEGORY_NOT_FOUND.getMessage()));

        category.update(requestDto.name(), category.getIsActive());
        categoryRepository.save(category);

        return CategoryDto.fromEntity(category);
    }

}
