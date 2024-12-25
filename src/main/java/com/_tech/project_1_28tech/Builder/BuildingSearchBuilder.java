package com._tech.project_1_28tech.Builder;

public class BuildingSearchBuilder {
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

    public BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.districtId = builder.districtId;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.direction = builder.direction;
        this.level = builder.level;
        this.area1 = builder.area1;
        this.area2 = builder.area2;
        this.rentPrice1 = builder.rentPrice1;
        this.rentPrice2 = builder.rentPrice2;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.staffId = builder.staffId;
        this.typeCode = builder.typeCode;
    }

    public String getName() {
        return name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public Long getLevel() {
        return level;
    }

    public Long getArea1() {
        return area1;
    }

    public Long getArea2() {
        return area2;
    }

    public Long getRentPrice1() {
        return rentPrice1;
    }

    public Long getRentPrice2() {
        return rentPrice2;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getTypeCode() {
        return typeCode;
    }


    public static class Builder {
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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloorArea(Long floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setDistrictId(Long districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(Long level) {
            this.level = level;
            return this;
        }

        public Builder setArea1(Long area1) {
            this.area1 = area1;
            return this;
        }

        public Builder setArea2(Long area2) {
            this.area2 = area2;
            return this;
        }

        public Builder setRentPrice1(Long rentPrice1) {
            this.rentPrice1 = rentPrice1;
            return this;
        }

        public Builder setRentPrice2(Long rentPrice2) {
            this.rentPrice2 = rentPrice2;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setTypeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}
