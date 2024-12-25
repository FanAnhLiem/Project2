package com._tech.project_1_28tech.service;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.model.BuildingDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface BuildingService {
    List<BuildingDTO> findAll(Map<String, Object> params);
}
