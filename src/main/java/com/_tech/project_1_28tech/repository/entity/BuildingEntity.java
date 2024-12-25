package com._tech.project_1_28tech.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng dần
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "ward")
    private String ward;

    @Column(name = "street")
    private String street;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column(name = "managername")
    private String managerName;

    @Column(name = "managerphonenumber")
    private String managerPhoneNumber;

    @Column(name = "floorarea")
    private Long floorArea ;

    @Column(name = "rentprice" , nullable = false)
    private Long rentPrice;

    @Column(name = "servicefee")
    private Long serviceFee;

    @Column(name = "brokeragefee")
    private Long brokerageFee;

    @ManyToOne
    @JoinColumn(name = "districtid")
    private DistrictEntity district;

    @OneToMany(mappedBy = "building" , fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreas = new ArrayList<>();

    public List<RentAreaEntity> getRentAreas() {
        return rentAreas;
    }

    public void setRentAreas(List<RentAreaEntity> rentAreas) {
        this.rentAreas = rentAreas;
    }

    public DistrictEntity getDistrict() {
        return district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
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
