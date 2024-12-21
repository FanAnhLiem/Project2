package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.repository.DistrictRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import com._tech.project_1_28tech.repository.entity.DistrictEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class DistrictImpl implements DistrictRepository {
    static final String url = "jdbc:mysql://localhost:3306/estatebasic";
    static final String username = "root";
    static final String password = "123456";
    @Override
    public DistrictEntity fillName(Long id) {
        DistrictEntity districtEntity = new DistrictEntity();
        StringBuilder sql = new StringBuilder("SELECT district.name from district where district.id = " + id + "; ");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());){
            while (rs.next()){
                districtEntity.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districtEntity;
    }
}
