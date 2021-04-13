package com.loi.loanproposal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.Optional;

/**
 * @author Loi Nguyen
 *
 */
@Getter @Setter
@NoArgsConstructor
@JsonInclude(Include.NON_ABSENT)
public final class ApiResponse<T> {
    @UtilityClass
    public static class CommonResponseCode {
        public static final String OK = "OK";
    }
    
    private static final String VERSION = "1.0";

    // The ID of the response being returned
    private String code;

    // The error code in case of error
    private int errorCode;

    // The key of the full description in Resource Bundle
    @JsonIgnore
    private String messageKey;

    // The arguments for the full description in Resource Bundle
    @JsonIgnore
    private Object[] messageArgs;

    // Full description of the response
    @JsonIgnore
    private String message;

    /*
     * Special property to get a list of error messages from a StackableValidationException.
     * All applications must only use "message" to provide a single message in the response.
     */
    private Object responseMessage;

    // When the response was returned
    private long timestamp;

    // Optional extra details to be included in the body of the response
    @JsonInclude(Include.ALWAYS)
    @Nullable
    private T data;

    @Builder
    public ApiResponse(String code, String messageKey, Object[] messageArgs, String message, Long timestamp, @Nullable T data, int errorCode) {
        super();
        this.code        = code;
        this.messageKey  = messageKey;
        this.messageArgs = messageArgs;
        this.message     = message;
        this.timestamp   = Optional.ofNullable(timestamp).orElse(System.currentTimeMillis());
        this.data        = data;
        this.errorCode   = errorCode;
    }

    /**
     * This method is only meant for Jackson serializer to figure out if they need to
     * serialize a simple message or a list of errors from StackableValidationException.
     *
     */
    @JsonProperty("message")
    protected Object getResponseMessage() {
        if (this.responseMessage == null)
            return this.getMessage();
        else
            return this.responseMessage;
    }

    @JsonProperty("message")
    protected void setResponseMessage(Object responseMessage) {
        if (responseMessage instanceof String)
            this.message = (String) responseMessage;
        else
            this.responseMessage = responseMessage;
    }

    public String getMessage() {
        return this.message;
    }

    public ApiResponse<Map<String, Object>> addDetails(String key, Object value) {
        ((Map<String, Object>) this.data).put(key, value);
        
        return (ApiResponse<Map<String, Object>>) this;
    }

        public ApiResponse<T> succeed() {
            this.code = CommonResponseCode.OK;
            return this;
        }

        public ApiResponse<T> messageArgs(Object... messageArgs) {
            this.messageArgs = messageArgs;
            return this;
        }

}
