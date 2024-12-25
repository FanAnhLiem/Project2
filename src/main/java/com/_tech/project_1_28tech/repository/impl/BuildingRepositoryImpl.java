package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        //JPQL
//        String sql = "FROM BuildingEntity b";
//        Query query = entityManager.createQuery(sql, BuildingEntity.class);  //map du lieu thay cho việc set như jdbc
//        return query.getResultList();

        //SQL native
        String sql = "SELECT * FROM building";
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }
}
