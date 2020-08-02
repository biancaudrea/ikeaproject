package ro.utcn.project.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.utcn.project.dto.ObjectDto;
import ro.utcn.project.dto.OrderPlacedDto;
import ro.utcn.project.entities.Object;
import ro.utcn.project.mapper.ObjectMapper;
import ro.utcn.project.service.ObjectService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserObjectOperations {
    @Autowired
    private ObjectService objectService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @GetMapping("/all")
    public String getAllObjects(Model model) {
        log.info("User is viewing all products.");
        List<Object> objects=objectService.getAllObjects();
        ObjectMapper objectMapper=new ObjectMapper();
        List<ObjectDto> objectsDto= objectMapper.getObjects(objects);
        model.addAttribute("objects",objectsDto);
        return "/user/all";
    }


    @GetMapping("/sortobjectsbyprice")
    public String sortByPrice(Model model)
    {
        log.info("User is viewing the products sorted by price.");
        List<Object> objects=objectService.sortByPrice();
        model.addAttribute("objects",new ObjectMapper().getObjects(objects));
        return "/user/sortobjectsbyprice";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(Model model, @PathVariable int id)
    {
        model.addAttribute("order",new OrderPlacedDto());
        ObjectDto objectDto=new ObjectDto(objectService.findById(id));
        model.addAttribute("object",objectDto);
        log.info("User is viewing product: "+objectDto.getName());
        return "/user/view";
    }
}
