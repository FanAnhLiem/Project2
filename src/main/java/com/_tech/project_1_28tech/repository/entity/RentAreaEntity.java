package com._tech.project_1_28tech.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Long value;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
