package com.brovada.document;

public interface Event {

    // TODO : the serialization to JSON must support/conform...
    //   -1   // if not http is given.
    //   {http:200, code:-1}
    //   [-1, -5, 0]
    //   {http:200, code:[-1, -5, 0]}
    //   [8..100]
    //   {http:200, code:[8.100]}
    //   { http:[200,201,404], code:33 }
    //   ... and so on.

    default EventCode getHttpCode() { return EventCode.forHttpStatus; }
    default boolean matches(int httpCode, int code) { return getHttpCode().matches(httpCode) && getEventCode().matches(code);}
    EventCode getEventCode();


    static Event forCode(int code) {
        // TODO : how will this be serialized into JSON? 
        return new Event() {
            @Override
            public EventCode getEventCode() {
                return new EventCode(code);
            }
        };
    }


}
