package com._tech.project_1_28tech.controllerAdvice;

import java.util.List;

public class BuildingSearchRequest {
    private String name;
    private Long floorArea;
    private Long districtId;
    private String ward;
    private String street;
    private Integer numberOfBasement;
    private String direction;
    private Long level;
    private Long area1;
    private Long area2;
    private Long rentPrice1;
    private Long rentPrice2;
    private String managerName;
    private String managerPhoneNumber;
    private Long staffId;
    private String typeCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getArea1() {
        return area1;
    }

    public void setArea1(Long area1) {
        this.area1 = area1;
    }

    public Long getArea2() {
        return area2;
    }

    public void setArea2(Long area2) {
        this.area2 = area2;
    }

    public Long getRentPrice1() {
        return rentPrice1;
    }

    public void setRentPrice1(Long rentPrice1) {
        this.rentPrice1 = rentPrice1;
    }

    public Long getRentPrice2() {
        return rentPrice2;
    }

    public void setRentPrice2(Long rentPrice2) {
        this.rentPrice2 = rentPrice2;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
