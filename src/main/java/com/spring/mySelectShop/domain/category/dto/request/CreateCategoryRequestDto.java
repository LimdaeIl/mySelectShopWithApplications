package com.spring.mySelectShop.domain.category.dto.request;

import static com.spring.mySelectShop.domain.category.dto.CategoryValidationMessages.CATEGORY_IS_ACTIVE_BLANK;
import static com.spring.mySelectShop.domain.category.dto.CategoryValidationMessages.CATEGORY_NAME_BLANK;
import static com.spring.mySelectShop.domain.category.dto.CategoryValidationMessages.CATEGORY_NAME_INVALID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateCategoryRequestDto(

        @NotBlank(message = CATEGORY_NAME_BLANK)
        @Pattern(
                regexp = "^[가-힣0-9·!\\s]{1,16}$",
                message = CATEGORY_NAME_INVALID
        )
        String name,

        @NotNull(message = CATEGORY_IS_ACTIVE_BLANK)
        Boolean isActive
) {

}
