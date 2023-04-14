package com.hyomee.newObject.prototype.javabeanCopy;

public abstract class DeviceModelVO  implements Cloneable {
    private String model;
    private String serialNo;

    public DeviceModelVO() {}


    protected DeviceModelVO(DeviceModelVO deviceModelVO) {
        if (deviceModelVO != null ) {
            this.model = deviceModelVO.getModel();
            this.serialNo = deviceModelVO.getSerialNo();
        }
    }

    @Override
    protected abstract DeviceModelVO clone();

    public String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    protected void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
