package com._tech.project_1_28tech.api;
import com._tech.project_1_28tech.Builder.BuildingSearchBuilder;
import com._tech.project_1_28tech.converter.BuildingSearchBuilderConverter;
import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.model.BuildingRequestDTO;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import com._tech.project_1_28tech.repository.entity.DistrictEntity;
import com._tech.project_1_28tech.service.BuildingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Transactional
@PropertySource("classpath:application.properties")
public class BuildingAPI {
//    @GetMapping(value = "api/building/") // == @RequestMapping(value = "api/building/", method = RequestMethod.GET)
//    public List<BuildingDTO> building(@RequestParam(value = "name", required = false) String name,
//                                     @RequestParam(value = "number", required = false) Integer num,
//                                     @RequestParam(value = "age", required = false) Integer age) {
////        BuildingDTO dto = new BuildingDTO();
////        dto.setName(name);
////        dto.setNumber(num);
////        dto.setAge(age);
//        List<BuildingDTO> listBuilding = new ArrayList<>();
//        BuildingDTO buildingDTO1 = new BuildingDTO();
//        buildingDTO1.setName("quan");
//        buildingDTO1.setNumber(220204);
//        buildingDTO1.setAge(20);
//        BuildingDTO buildingDTO2 = new BuildingDTO();
//        buildingDTO2.setName("trang");
//        buildingDTO2.setNumber(290804);
//        buildingDTO2.setAge(18);
//        listBuilding.add(buildingDTO1);
//        listBuilding.add(buildingDTO2);
//        return listBuilding;
//    }
//    @RequestMapping(value = "api/building/", method = RequestMethod.GET)
//    public Object building2(@RequestParam(value = "name", required = false) String name,
//                             @RequestParam(value = "number", required = false) Integer num,
//                             @RequestParam(value = "age", required = false) Integer age) {
//
//        try {
//            System.out.println(5/0);
//        }
//        catch (Exception e) {
//            ErrorBE errorbe = new ErrorBE();
//            errorbe.setName(e.getMessage());
//            List<String> details = new ArrayList<>();
//            details.add("lỗi vãi loz");
//            errorbe.setDetails(details);
//            return errorbe;
//        }
//        BuildingDTO buildingDTO = new BuildingDTO();
//        buildingDTO.setName(name);
//        buildingDTO.setAge(age);
//        buildingDTO.setNumber(num);
//        return buildingDTO;
//    }
    @Autowired
    private BuildingService buildingService;

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${dev.bui}")
    private String data;
    @GetMapping(value = "api/building/")
    public List<BuildingDTO> getbuilding(@RequestParam Map<String, Object> params) {
        List<BuildingDTO> result = buildingService.findAll(params);
        return result;
    }

    //    @Transactional phải khai báo annotation này nếu dùng entityManager
    @PostMapping(value = "api/building/")
    public void createbuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());
        DistrictEntity districtEntity = new DistrictEntity();
        districtEntity.setId(buildingRequestDTO.getDistrictId());
        buildingEntity.setDistrict(districtEntity);
        buildingEntity.setName(buildingRequestDTO.getName());
        buildingEntity.setWard(buildingRequestDTO.getWard());
        buildingEntity.setStreet(buildingRequestDTO.getStreet());
        entityManager.persist(buildingEntity);
        System.out.println(buildingEntity);
    }

    @PutMapping(value = "api/building/")
    public void updatebuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setId(buildingRequestDTO.getId());
        buildingEntity.setName(buildingRequestDTO.getName());
        buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());
        DistrictEntity districtEntity = new DistrictEntity();
        districtEntity.setId(buildingRequestDTO.getDistrictId());
        buildingEntity.setDistrict(districtEntity);
        buildingEntity.setWard(buildingRequestDTO.getWard());
        buildingEntity.setStreet(buildingRequestDTO.getStreet());
        entityManager.merge(buildingEntity);
        System.out.println(buildingEntity);
    }

    @DeleteMapping(value = "api/building/{id}")
    public void deletebuilding(@PathVariable long id) {
        BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id);
        entityManager.remove(buildingEntity);
    }

//    public void valiDate(BuildingDTO buildingDTO) {
//        if (buildingDTO.getName() == null || buildingDTO.getNumberofbasement() == null || buildingDTO.getAge() == null
//        || buildingDTO.getName().equals("")) {
//            throw new RequireException("data null");
//        }
//    }
}
