package com._tech.project_1_28tech.api;
import com._tech.project_1_28tech.controllerAdvice.BuildingSearchRequest;
import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
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

    @GetMapping(value = "api/building/")
    public List<BuildingDTO> getbuilding(@ModelAttribute BuildingSearchRequest buildingSearchRequest) {
        List<BuildingDTO> result = buildingService.findAll(buildingSearchRequest);
        return result;
    }

//    public void valiDate(BuildingDTO buildingDTO) {
//        if (buildingDTO.getName() == null || buildingDTO.getNumberofbasement() == null || buildingDTO.getAge() == null
//        || buildingDTO.getName().equals("")) {
//            throw new RequireException("data null");
//        }
//    }
}
