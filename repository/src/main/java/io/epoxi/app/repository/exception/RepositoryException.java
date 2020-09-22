package io.epoxi.app.repository.exception;

import io.epoxi.app.cloud.logging.BaseException;
import io.epoxi.app.cloud.logging.StatusCode;

public class RepositoryException extends BaseException {
 
    public RepositoryException(String message, StatusCode code) {
        super(message, code);        
    }
  

    /**
     *
     */
    private static final long serialVersionUID = 6340495467050556228L;

   
    
}