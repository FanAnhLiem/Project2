package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
@PropertySource("classpath:application-uat.properties")
@Transactional
@Primary
public class BuildingRepositoryImplJDBC implements BuildingRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void JoinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if(staffId != null){
            sql.append("INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
        }
        if(buildingSearchBuilder.getTypeCode() != null && !buildingSearchBuilder.getTypeCode().equals("")){
            sql.append("INNER JOIN buildingrenttype ON  b.id = buildingrenttype.buildingid " +
                       "INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
        }
        if(buildingSearchBuilder.getArea1() != null || buildingSearchBuilder.getArea2() != null){
            sql.append("INNER JOIN rentarea ON rentarea.buildingid = b.id ");
        }
    }
    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
        JoinTable(buildingSearchBuilder, sql);
        StringBuilder where = new StringBuilder(" where 1=1 ");
        sql.append(where);
        if(buildingSearchBuilder.getName() != null && !buildingSearchBuilder.getName().equals("")){
            sql.append(" and b.name like '%" + buildingSearchBuilder.getName() + "%' ");
        }
        if(buildingSearchBuilder.getDistrictId() != null){
            sql.append(" and b.districtid = " + buildingSearchBuilder.getDistrictId());
        }
        if(buildingSearchBuilder.getFloorArea() != null){
            sql.append(" and b.floorarea = " + buildingSearchBuilder.getFloorArea());
        }
        if (buildingSearchBuilder.getWard() != null && !buildingSearchBuilder.getWard().equals("")){
            sql.append(" and b.ward like '%" + buildingSearchBuilder.getWard() + "%' ");
        }
        if (buildingSearchBuilder.getStreet() != null && !buildingSearchBuilder.getStreet().equals("")){
            sql.append(" and b.street like '%" + buildingSearchBuilder.getStreet() + "%' ");
        }
        if(buildingSearchBuilder.getNumberOfBasement() != null){
            sql.append(" and b.numberofbasement = " + buildingSearchBuilder.getNumberOfBasement());
        }
        if (buildingSearchBuilder.getDirection() != null && !buildingSearchBuilder.getDirection().equals("")){
            sql.append(" and b.direction like '%" + buildingSearchBuilder.getDirection() + "%' ");
        }
        if(buildingSearchBuilder.getLevel() != null){
            sql.append(" and b.level = " + buildingSearchBuilder.getLevel());
        }
        if(buildingSearchBuilder.getArea1() != null || buildingSearchBuilder.getArea2() != null){
            sql.append(" and (");
            if (buildingSearchBuilder.getArea1() != null) {
                sql.append(" rentarea.value >= " + buildingSearchBuilder.getArea1());
            }
            if (buildingSearchBuilder.getArea1() != null && buildingSearchBuilder.getArea2() != null) {
                sql.append(" and ");
            }
            if (buildingSearchBuilder.getArea2() != null) {
                sql.append(" rentarea.value  <= " + buildingSearchBuilder.getArea2());
            }
            sql.append(") ");
        }
        if(buildingSearchBuilder.getRentPrice1() != null || buildingSearchBuilder.getRentPrice2() != null){
            sql.append(" and (");
            if (buildingSearchBuilder.getRentPrice1() != null) {
                sql.append("b.rentprice >= " + buildingSearchBuilder.getRentPrice1());
            }
            if (buildingSearchBuilder.getArea1() != null && buildingSearchBuilder.getArea2() != null) {
                sql.append(" and ");
            }
            if (buildingSearchBuilder.getArea2() != null) {
                sql.append("b.rentprice <= " + buildingSearchBuilder.getArea2());
            }
            sql.append(") ");
        }

        if (buildingSearchBuilder.getManagerName() != null && !buildingSearchBuilder.getManagerName().equals("")){
            sql.append(" and b.managername like '%" + buildingSearchBuilder.getManagerName() + "%' ");
        }
        if (buildingSearchBuilder.getManagerPhoneNumber() != null && !buildingSearchBuilder.getManagerPhoneNumber().equals("")){
            sql.append(" and b.managerphonenumber like '%" + buildingSearchBuilder.getDirection() + "%' ");
        }
        if(buildingSearchBuilder.getStaffId() != null){
            sql.append(" and assignmentbuilding.staffid = " + buildingSearchBuilder.getStaffId());
        }
        if(buildingSearchBuilder.getTypeCode() != null && !buildingSearchBuilder.getTypeCode().equals("")){
            sql.append(" and renttype.code like '%" + buildingSearchBuilder.getTypeCode() + "%' ");
        }
        sql.append(" GROUP BY b.id ");

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
