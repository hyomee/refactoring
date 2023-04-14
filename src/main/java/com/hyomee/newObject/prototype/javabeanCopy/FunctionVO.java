package com.hyomee.newObject.prototype.javabeanCopy;

public class FunctionVO implements Cloneable {
    private String functionId;
    private String functionName;


    public FunctionVO(String functionId, String functionName) {
        this.functionId = functionId;
        this.functionName = functionName;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public FunctionVO clone() {
        FunctionVO functionVO = null;
        try {
            functionVO = (FunctionVO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return functionVO;
    }

        @Override
    public String toString() {
        return "FunctionVO{" +
                "functionId='" + functionId + '\'' +
                ", functionName='" + functionName + '\'' +
                '}';
    }
}
