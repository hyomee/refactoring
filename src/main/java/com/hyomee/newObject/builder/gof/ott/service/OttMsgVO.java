package com.hyomee.newObject.builder.gof.ott.service;

public class OttMsgVO {
    private String ottName;
    private Object obj;

    private OttMsgVO(String ottName, Object obj) {
        this.ottName = ottName;
        this.obj = obj;
    }


    public static OttMsgVO initOttMsgVO(String ottName, Object obj) {
        return new OttMsgVO(ottName, obj);
    }

    public String getOttName() {
        return ottName;
    }

    public Object getObj() {
        return obj;
    }
}
