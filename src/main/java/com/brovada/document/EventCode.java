package com.brovada.document;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;

public class EventCode {

    public static EventCode forHttpStatus = new EventCode(HttpStatus.OK);
    
    private int code;

    private EventCode() { }

    public EventCode(int code) {
        this.code = code;
    }

    public EventCode(HttpStatus status) {
        this.code = status.value();
    }

    public int getCode() {
        return code;
    }

    public boolean matches(int code) {
        return this.code == code;
    }

    public boolean matches(EventCode ec) {
        return matches(ec.getCode());
    }

    public static class EventCodeRange extends EventCode {


        private final int start;
        private final int end;

        public EventCodeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean matches(int code) {
            return code>=start && code<=end;
        }
    }

    public static class EventCodeList extends EventCode {

        final int[] codes;
        public EventCodeList(int... codes) {
            this.codes = codes;
        }

        @Override
        public boolean matches(int code) {
            return ArrayUtils.contains(codes, code);
        }
    }



}
