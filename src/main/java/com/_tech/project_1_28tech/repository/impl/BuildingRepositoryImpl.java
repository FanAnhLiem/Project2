package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.controllerAdvice.BuildingSearchRequest;
import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String url = "jdbc:mysql://localhost:3306/estatebasic";
    static final String username = "root";
    static final String password = "123456";

    public void JoinTable(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
        if(buildingSearchRequest.getStaffId() != null){
            sql.append("INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
        }
        if(buildingSearchRequest.getTypeCode() != null && !buildingSearchRequest.getTypeCode().equals("")){
            sql.append("INNER JOIN buildingrenttype ON  b.id = buildingrenttype.buildingid " +
                       "INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
        }
        if(buildingSearchRequest.getArea1() != null || buildingSearchRequest.getArea2() != null){
            sql.append("INNER JOIN rentarea ON rentarea.buildingid = b.id ");
        }
    }
    @Override
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
        JoinTable(buildingSearchRequest, sql);
        StringBuilder where = new StringBuilder(" where 1=1 ");
        sql.append(where);
        if(buildingSearchRequest.getName() != null && !buildingSearchRequest.getName().equals("")){
            sql.append(" and b.name like '%" + buildingSearchRequest.getName() + "%' ");
        }
        if(buildingSearchRequest.getDistrictId() != null){
            sql.append(" and b.districtid = " + buildingSearchRequest.getDistrictId());
        }
        if(buildingSearchRequest.getFloorArea() != null){
            sql.append(" and b.floorarea = " + buildingSearchRequest.getFloorArea());
        }
        if (buildingSearchRequest.getWard() != null && !buildingSearchRequest.getWard().equals("")){
            sql.append(" and b.ward like '%" + buildingSearchRequest.getWard() + "%' ");
        }
        if (buildingSearchRequest.getStreet() != null && !buildingSearchRequest.getStreet().equals("")){
            sql.append(" and b.street like '%" + buildingSearchRequest.getStreet() + "%' ");
        }
        if(buildingSearchRequest.getNumberOfBasement() != null){
            sql.append(" and b.numberofbasement = " + buildingSearchRequest.getNumberOfBasement());
        }
        if (buildingSearchRequest.getDirection() != null && !buildingSearchRequest.getDirection().equals("")){
            sql.append(" and b.direction like '%" + buildingSearchRequest.getDirection() + "%' ");
        }
        if(buildingSearchRequest.getLevel() != null){
            sql.append(" and b.level = " + buildingSearchRequest.getLevel());
        }
        if(buildingSearchRequest.getArea1() != null || buildingSearchRequest.getArea2() != null){
            sql.append(" and (");
            if (buildingSearchRequest.getArea1() != null) {
                sql.append(" rentarea.value >= " + buildingSearchRequest.getArea1());
            }
            if (buildingSearchRequest.getArea1() != null && buildingSearchRequest.getArea2() != null) {
                sql.append(" and ");
            }
            if (buildingSearchRequest.getArea2() != null) {
                sql.append(" rentarea.value  <= " + buildingSearchRequest.getArea2());
            }
            sql.append(") ");
        }
        if(buildingSearchRequest.getRentPrice1() != null || buildingSearchRequest.getRentPrice2() != null){
            sql.append(" and (");
            if (buildingSearchRequest.getRentPrice1() != null) {
                sql.append("b.rentprice >= " + buildingSearchRequest.getRentPrice1());
            }
            if (buildingSearchRequest.getArea1() != null && buildingSearchRequest.getArea2() != null) {
                sql.append(" and ");
            }
            if (buildingSearchRequest.getArea2() != null) {
                sql.append("b.rentprice <= " + buildingSearchRequest.getArea2());
            }
            sql.append(") ");
        }

        if (buildingSearchRequest.getManagerName() != null && !buildingSearchRequest.getManagerName().equals("")){
            sql.append(" and b.managername like '%" + buildingSearchRequest.getManagerName() + "%' ");
        }
        if (buildingSearchRequest.getManagerPhoneNumber() != null && !buildingSearchRequest.getManagerPhoneNumber().equals("")){
            sql.append(" and b.managerphonenumber like '%" + buildingSearchRequest.getDirection() + "%' ");
        }
        if(buildingSearchRequest.getStaffId() != null){
            sql.append(" and assignmentbuilding.staffid = " + buildingSearchRequest.getStaffId());
        }
        if(buildingSearchRequest.getTypeCode() != null && !buildingSearchRequest.getTypeCode().equals("")){
            sql.append(" and renttype.code like '%" + buildingSearchRequest.getTypeCode() + "%' ");
        }
        sql.append(" GROUP BY b.id ");
        List<BuildingEntity> buildings = new ArrayList<>();
        System.out.println(sql.toString());
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.    executeQuery(sql.toString());){
            while (rs.next()){
                BuildingEntity building = new BuildingEntity();
                building.setId(rs.getLong("id"));
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setDistrictId(rs.getLong("districtid"));
                building.setNumberOfBasement(rs.getInt("numberofbasement"));
                building.setFloorArea(rs.getLong("floorarea"));
                building.setManagerName(rs.getString("managername"));
                building.setManagerPhoneNumber(rs.getString("managerphonenumber"));
                building.setRentPrice(rs.getLong("rentprice"));
                building.setServiceFee(rs.getLong("servicefee"));
                building.setBrokerageFee(rs.getLong("brokeragefee"));
                buildings.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildings;
    }
}
