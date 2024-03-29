package io.epoxi.repository.exception;

import io.epoxi.cloud.logging.BaseException;
import io.epoxi.cloud.logging.StatusCode;
import lombok.Getter;

public class DuplicateMemberException extends BaseException {
 
    public DuplicateMemberException(String message, String memberName) {
        super(message, StatusCode.INVALID_ARGUMENT);
        this.memberName = memberName; 
    }

    @Getter
    private final String memberName;

    /**
     *
     */
    private static final long serialVersionUID = 6240495467050536228L;

   
    
}