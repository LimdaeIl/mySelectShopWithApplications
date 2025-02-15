package com.spring.mySelectShop.common.response;

import java.util.Objects;
import lombok.Getter;

/**
 *
 */
@Getter
public class HttpResponse<T> implements ResponseCodeInterface {

    private final Integer code;
    private final String message;
    private final T data;

    /**
     * 
     * @param code: 응답 코드
     * @param message: 메시지
     * @param data: 데이터
     */
    public HttpResponse(
            Integer code,
            String message,
            T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public HttpResponse(ResponseCodeInterface responseCode, T data) {
        this(responseCode.getCode(), responseCode.getMessage(), data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (HttpResponse) obj;
        return Objects.equals(this.code, that.code) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return "HttpResponse[" +
                "code=" + code + ", " +
                "message=" + message + ", " +
                "data=" + data + ", " +
                ']';
    }

}
