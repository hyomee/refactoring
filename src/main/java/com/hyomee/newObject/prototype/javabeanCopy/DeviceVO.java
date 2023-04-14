package com.hyomee.newObject.prototype.javabeanCopy;

import java.util.LinkedList;
import java.util.List;

public class DeviceVO extends DeviceModelVO {
    private String company;
    private List<FunctionVO> functionVOs;


    public DeviceVO( String model,
                     String serialNo,
                     String company,
                     List<FunctionVO> functionVO) {
        super();
        super.setModel(model);
        super.setSerialNo(serialNo);
        this.company =  company;
        this.functionVOs =functionVO;
    }

    private DeviceVO(DeviceVO deviceVO,
                    List<FunctionVO> functionVOs) {
        super(deviceVO);
        if (deviceVO != null ) {
            this.company =  deviceVO.company;
            this.functionVOs = functionVOs;
        }
    }

    @Override
    public DeviceModelVO clone() {
        List<FunctionVO> functionVOs = new LinkedList<>();
        for (FunctionVO functionVO : this.functionVOs) {
            functionVOs.add(functionVO.clone() );
        }
        return new DeviceVO(this, functionVOs);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<FunctionVO> getFunctionVOs() {
        return functionVOs;
    }

    public void setFunctionVOs(List<FunctionVO> functionVOs) {
        this.functionVOs = functionVOs;
    }

    @Override
    public String toString() {
        return "DeviceVO{" +
                "model='" + super.getModel() + '\'' +
                ", serialNo='" + super.getSerialNo() + '\'' +
                ", company='" + company + '\'' +
                "      \n\t\t functionVOs=" + functionVOs.toString() +
                '}';
    }


}
