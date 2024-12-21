package com._tech.project_1_28tech.service.impl;

import com._tech.project_1_28tech.controllerAdvice.BuildingSearchRequest;
import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.DistrictRepository;
import com._tech.project_1_28tech.repository.RentAreaRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import com._tech.project_1_28tech.repository.entity.DistrictEntity;
import com._tech.project_1_28tech.repository.entity.RentAreaEntity;
import com._tech.project_1_28tech.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository repo;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BuildingDTO> findAll(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildingEntities = repo.findAll(buildingSearchRequest);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO dto = modelMapper.map(item, BuildingDTO.class);

            DistrictEntity districtEntity = districtRepository.fillName(item.getDistrictId());
            dto.setAddress(item.getStreet() + ", "+item.getWard() + ", " + districtEntity.getName());
            List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(item.getId());
            String rentAreaStrings = rentAreas.stream().map(rent -> rent.getValue().toString()).collect(Collectors.joining(","));
            System.out.println(rentAreaStrings);
            dto.setRentArea(rentAreaStrings);
            result.add(dto);
        }
        return result;
    }
}
