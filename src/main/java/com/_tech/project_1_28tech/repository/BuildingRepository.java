package com._tech.project_1_28tech.repository;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
