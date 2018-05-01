package com.brovada.document;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

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

    public boolean matches(int code) {
        return this.code == code;
    }

    public static class EventCodeRange extends EventCode {

        final IntStream range;
        public EventCodeRange(int start, int end) {
            this.range = range(start,end);
        }

        @Override
        public boolean matches(int code) {
            return range.anyMatch(c->code==c);
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
