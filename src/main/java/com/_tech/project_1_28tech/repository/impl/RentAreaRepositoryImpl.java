package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.repository.RentAreaRepository;
import com._tech.project_1_28tech.repository.entity.RentAreaEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
    static final String url = "jdbc:mysql://localhost:3306/estatebasic";
    static final String username = "root";
    static final String password = "123456";
    @Override
    public List<RentAreaEntity> getValueByBuildingId(Long buildingId) {
        List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();
        String sql = "SELECT * FROM rentarea r WHERE r.buildingId = " + buildingId;
        System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){
            while (rs.next()){
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(rs.getLong("value"));
                rentAreas.add(rentAreaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentAreas;
    }
}
