package com.spring.mySelectShop.common.excepetion;

import com.spring.mySelectShop.common.response.ResponseCodeInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * MSA 확장성을 고려한 글로벌 예외 코드 Enum
 */
@RequiredArgsConstructor
@Getter
public enum GlobalExceptionCode implements ResponseCodeInterface {
    // 1xxx: 잘못된 요청 관련 예외
    INVALID_REQUEST(1001, "잘못된 요청입니다."),
    MISSING_REQUEST_PARAMETER(1002, "필수 요청 파라미터가 누락되었습니다."),
    UNSUPPORTED_MEDIA_TYPE(1003, "지원되지 않는 미디어 타입입니다."),

    // 2xxx: 인증 및 인가 관련 예외
    UNAUTHORIZED(2001, "인증이 필요합니다."),
    FORBIDDEN(2002, "권한이 없습니다."),
    ACCESS_DENIED(2003, "접근이 거부되었습니다."),
    TOKEN_EXPIRED(2004, "토큰이 만료되었습니다."),
    INVALID_TOKEN(2005, "유효하지 않은 토큰입니다."),

    // 3xxx: 데이터 관련 예외
    DATA_NOT_FOUND(3001, "요청한 데이터를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(3002, "이미 존재하는 데이터입니다."),
    DATABASE_ERROR(3003, "데이터베이스 오류가 발생했습니다."),
    DATA_INTEGRITY_VIOLATION(3004, "데이터 무결성 제약 조건을 위반했습니다."),

    // 4xxx: 서버 오류 관련 예외
    INTERNAL_SERVER_ERROR(4001, "서버 내부 오류가 발생했습니다."),
    SERVICE_UNAVAILABLE(4002, "현재 서비스를 사용할 수 없습니다."),
    TIMEOUT_ERROR(4003, "요청 시간이 초과되었습니다."),
    EXTERNAL_SERVICE_ERROR(4004, "외부 서비스 연동 중 오류가 발생했습니다."),

    // 5xxx: 파일 처리 및 기타 예외
    FILE_UPLOAD_FAILED(5001, "파일 업로드에 실패했습니다."),
    FILE_NOT_FOUND(5002, "요청한 파일을 찾을 수 없습니다."),
    UNSUPPORTED_FILE_TYPE(5003, "지원되지 않는 파일 형식입니다.");

    private final Integer code;
    private final String message;
}
