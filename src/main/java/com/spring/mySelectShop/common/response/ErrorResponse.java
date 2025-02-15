package com.spring.mySelectShop.common.response;

import java.util.Objects;
import lombok.Getter;

@Getter
public class ErrorResponse implements ResponseCodeInterface {

    private final Integer code;
    private final String message;
    private final String serviceName;

    public ErrorResponse(Integer code, String message, String serviceName) {
        this.code = code;
        this.message = message;
        this.serviceName = serviceName;
    }

    public ErrorResponse(ResponseCodeInterface responseCode, String serviceName) {
        this(responseCode.getCode(), responseCode.getMessage(), serviceName);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (ErrorResponse) obj;
        return Objects.equals(this.code, that.code) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, serviceName);
    }

    @Override
    public String toString() {
        return "ErrorResponse[" +
                "code=" + code + ", " +
                "message=" + message + ", " +
                "serviceName=" + serviceName + ']';
    }

}

