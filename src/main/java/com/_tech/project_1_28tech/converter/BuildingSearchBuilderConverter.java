package com._tech.project_1_28tech.converter;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.util.MapUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params){
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtil.getObject(params,"name",String.class))
                .setWard(MapUtil.getObject(params,"ward",String.class))
                .setStreet(MapUtil.getObject(params,"street",String.class))
                .setDistrictId(MapUtil.getObject(params,"districtId", Long.class))
                .setFloorArea(MapUtil.getObject(params,"floorArea", Long.class))
                .setLevel(MapUtil.getObject(params,"level",Long.class))
                .setDirection(MapUtil.getObject(params,"direction",String.class))
                .setArea1(MapUtil.getObject(params,"area1", Long.class))
                .setArea2(MapUtil.getObject(params,"area2", Long.class))
                .setRentPrice1(MapUtil.getObject(params,"rentPrice1", Long.class))
                .setRentPrice2(MapUtil.getObject(params,"rentPrice2", Long.class))
                .setManagerName(MapUtil.getObject(params,"managerName", String.class))
                .setManagerPhoneNumber(MapUtil.getObject(params,"managerPhoneNumber", String.class))
                .setNumberOfBasement(MapUtil.getObject(params,"numberOfBasement", Integer.class))
                .setStaffId(MapUtil.getObject(params,"staffId", Long.class))
                .setTypeCode(MapUtil.getObject(params,"typeCode",String.class))
                .build();
        System.out.println(buildingSearchBuilder);
        return buildingSearchBuilder;
    }
}
