package io.epoxi.repository.event;

import com.google.pubsub.v1.PubsubMessage;

import io.epoxi.cloud.logging.BaseException;
import io.epoxi.cloud.logging.StatusCode;

public class EventException extends BaseException {

    private static final long serialVersionUID = -4600540053967489323L;

 
    private final PubsubMessage pubsubMessage;

    public EventException(String message, StatusCode statusCode) {
        super(message, statusCode);
       
        this.pubsubMessage = null;
    }

    public EventException(String message, Throwable cause, StatusCode statusCode) {
        super(message, cause, statusCode);      
        this.pubsubMessage = null;
    }

    public EventException(String message, PubsubMessage pubsubMessage, Throwable cause, StatusCode statusCode) 
    {
        super(message, cause, statusCode);   
        this.pubsubMessage = pubsubMessage;
    }   

    public PubsubMessage getPubsubMessage()
    {
        return pubsubMessage;
    }
   
    
}