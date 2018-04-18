package com.brovada.document.config;

public class ErrorMessage {

    // TODO : add localization.
    private String msg;
    private int code;
    private String key;

    public ErrorMessage(String msg) {
        this.msg = msg;
        this.key = msg;
    }

    public <T extends ErrorMessage> T withKey(String key) {
        this.key = key;
        // need to localize msg here or at some time.
        return (T) this;
    }

    public <T extends ErrorMessage> T withCode(int code) {
        this.code = code;
        return (T) this;
    }

    public <T extends ErrorMessage> T withMsg(String msg) {
        this.msg = msg;
        return (T) this;
    }


    public String getMessage() {
        return msg==null ? key : msg;
    }
    public String getKey() {
        return key;
    }

    public int getCode() {
        return 0;
    }


}
