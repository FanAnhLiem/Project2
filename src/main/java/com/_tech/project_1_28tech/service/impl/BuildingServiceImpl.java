package com._tech.project_1_28tech.service.impl;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.converter.BuildingSearchBuilderConverter;
import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import com._tech.project_1_28tech.repository.entity.DistrictEntity;
import com._tech.project_1_28tech.repository.entity.RentAreaEntity;
import com._tech.project_1_28tech.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params);
        List<BuildingEntity> buildingEntities = repo.findAll(buildingSearchBuilder);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO dto = modelMapper.map(item, BuildingDTO.class);
            DistrictEntity districtEntity = item.getDistrict();
            dto.setAddress(item.getStreet() + ", "+item.getWard() + ", " + districtEntity.getName());
            List<RentAreaEntity> rentAreas = item.getRentAreas();
            String rentAreaStrings = rentAreas.stream().map(rent -> rent.getValue().toString()).collect(Collectors.joining(","));
            System.out.println(rentAreaStrings);
            dto.setRentArea(rentAreaStrings);
            result.add(dto);
        }
        return result;
    }
}
