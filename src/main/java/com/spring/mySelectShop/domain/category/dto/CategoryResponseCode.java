package com.spring.mySelectShop.domain.category.dto;

import com.spring.mySelectShop.common.response.ResponseCodeInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryResponseCode implements ResponseCodeInterface {
    SUCCESS(1000, "요청이 성공적으로 처리되었습니다."),
    FAILURE(1001, "요청 처리에 실패했습니다."),

    CATEGORY_CREATED(2001, "카테고리 등록에 성공했습니다."),
    CATEGORY_UPDATED(2002, "카테고리 정보가 수정되었습니다."),
    CATEGORY_DELETED(2003, "카테고리가 삭제되었습니다."),
    CATEGORY_FETCHED(2004, "카테고리 정보를 성공적으로 조회했습니다."),
    CATEGORIES_FETCHED(2005, "전체 카테고리 목록을 성공적으로 조회했습니다.");

    private final Integer code;
    private final String message;
}
