package com._tech.project_1_28tech.model;

public class BuildingDTO {
    private String name;
    private Integer numberOfBasement;
    private String address;
    private String managerName;
    private String managerNumberPhone;
    private Long floorArea;
    private String rentArea;
    private Long areaEmpty;
    private Long rentPrice;
    private Long serviceFee;
    private Long brokerageFee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerNumberPhone() {
        return managerNumberPhone;
    }

    public void setManagerNumberPhone(String managerNumberPhone) {
        this.managerNumberPhone = managerNumberPhone;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public Long getAreaEmpty() {
        return areaEmpty;
    }

    public void setAreaEmpty(Long areaEmpty) {
        this.areaEmpty = areaEmpty;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Long getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Long serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Long getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Long brokerageFee) {
        this.brokerageFee = brokerageFee;
    }
}
