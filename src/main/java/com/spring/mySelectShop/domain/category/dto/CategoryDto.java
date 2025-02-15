package com.spring.mySelectShop.domain.category.dto;

import static com.spring.mySelectShop.domain.category.entity.Category.*;

import com.spring.mySelectShop.domain.category.entity.Category;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CategoryDto(
        UUID id,
        String name,
        Boolean isActive
) {

    public static CategoryDto fromEntity(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getIsActive());
    }

    public static List<CategoryDto> fromEntities(List<Category> categories) {
        return categories.stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    public Category toEntity() { // 새로운 데이터 생성(ID 없음)
        return create(name, isActive);
    }
}
