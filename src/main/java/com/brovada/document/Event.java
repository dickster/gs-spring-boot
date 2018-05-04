package com.brovada.document;

public class Event {


    // TODO : event can carry payload.  need a way to get it back to the workflow.
    
    private EventCode httpCode = EventCode.forHttpStatus;
    private EventCode code;

    // TODO : the serialization to JSON must support/conform...
    //   -1   // if not http is given.
    //   {http:200, code:-1}
    //   [-1, -5, 0]
    //   {http:200, code:[-1, -5, 0]}
    //   [8..100]
    //   {http:200, code:[8.100]}
    //   { http:[200,201,404], code:33 }
    //   ... and so on.


    public Event(EventCode code) {
        this.code = code;
    }

    private Event() {

    }

    public Event(EventCode httpCode, EventCode code) {
        this.code = code;
        this.httpCode = httpCode;
    }

    public Event(int code) {
        this.code = new EventCode(code);
    }

    public Event(int httpCode, int code) {
        this( new EventCode(httpCode), new EventCode(code));
    }

    public boolean matches(int httpCode, int code) {
        return getHttpCode().matches(httpCode) && getCode().matches(code);
    }
    

    public EventCode getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(EventCode httpCode) {
        this.httpCode = httpCode;
    }

    public EventCode getCode() {
        return code;
    }

    public void setCode(EventCode code) {
        this.code = code;
    }


    public boolean matches(Event event) {
        return getHttpCode().matches(event.getHttpCode()) && getCode().matches(event.getCode());
    }

    @Override
    public String toString() {
        return "Event{" +
                "code=" + code +
                ", httpCode=" + httpCode +
                '}';
    }

    public static class EventAny extends Event {
        @Override
        public boolean matches(int httpCode, int code) {
            return true;
        }
    }
}
