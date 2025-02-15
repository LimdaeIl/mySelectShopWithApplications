package com.spring.mySelectShop.domain.category.exception;

import com.spring.mySelectShop.common.response.ResponseCodeInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryExceptionCode implements ResponseCodeInterface {
    CATEGORY_NOT_FOUND(6001, "해당 카테고리를 찾을 수 없습니다."),
    CATEGORY_ALREADY_EXISTS(6002, "이미 존재하는 카테고리입니다."),
    CATEGORY_UPDATE_FAILED(6003, "카테고리 업데이트에 실패했습니다."),
    CATEGORY_DELETE_FAILED(6004, "카테고리 삭제에 실패했습니다."),
    CATEGORY_NAME_INVALID(6005, "카테고리 이름이 유효하지 않습니다."),
    CATEGORY_IS_ACTIVE_INVALID(6006, "카테고리 활성화 여부가 유효하지 않습니다.");

    private final Integer code;
    private final String message;
}
