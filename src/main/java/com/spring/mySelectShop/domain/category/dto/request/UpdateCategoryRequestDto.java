package com.spring.mySelectShop.domain.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record UpdateCategoryRequestDto(

        @NotBlank(message = "카테고리 이름: 필수 정보입니다.")
        @Pattern(
                regexp = "^[가-힣0-9·!\\s]{1,16}$",
                message = "카테고리 이름은 한글, 숫자, 특수 문자(·, !), 공백만 입력 가능하며, 1~16글자 이내여야 합니다."
        )
        String name
) {
}
