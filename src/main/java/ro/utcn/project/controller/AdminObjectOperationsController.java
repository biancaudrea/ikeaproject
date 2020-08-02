package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.utcn.project.dto.CategoryDto;
import ro.utcn.project.dto.ObjectDto;
import ro.utcn.project.dto.ObjectPriceDto;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.entities.Category;
import ro.utcn.project.entities.Object;
import ro.utcn.project.mapper.CategoryMapper;
import ro.utcn.project.mapper.ObjectMapper;
import ro.utcn.project.service.CategoryService;
import ro.utcn.project.service.ObjectService;
import ro.utcn.project.validator.NameValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminObjectOperationsController {
    @Autowired
    private ObjectService objectService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/allobjects")
    public String getAllObjectsToAdmin(Model model) {
        log.info("Admin is viewing all products.");
        List<Object> objects=objectService.getAllObjects();
        ObjectMapper objectMapper=new ObjectMapper();
        List<ObjectDto> objectsDto= objectMapper.getObjects(objects);
        model.addAttribute("objects",objectsDto);
        return "/admin/allobjects";
    }


    @GetMapping("/createobject")
    public String getCreateObject(Model model)
    {
        List<CategoryDto> categories=new CategoryMapper().getCategories(categoryService.getAllCategories());
        model.addAttribute("categories",categories);
        model.addAttribute("objectDto",new ObjectDto());
        return "/admin/createobject";
    }

    @PostMapping("/createobject")
    public String processForm(@Valid ObjectDto objectDto,Model model)
    {
        List<CategoryDto> categories=new CategoryMapper().getCategories(categoryService.getAllCategories());
        model.addAttribute("categories",categories);
        NameValidator objectValidator=new NameValidator();
        if(objectValidator.validateName(objectDto.getName())==false) {
            model.addAttribute("notValid","Sorry but the name you have entered is not valid. Size should be larger than 2.");
            log.warn("Admin has tried to create an invalid product.");
        }
        else {
            Category category = categoryService.findByName(objectDto.getCategoryName());
            objectService.insertObject(new Object(objectDto.getName(), objectDto.getManufacturer(), objectDto.getPrice(), category));
            model.addAttribute("success","You have succesfully created the product: "+objectDto.getName()+"!");
            log.info("Admin has created a new product.");
        }
        return "/admin/createobject";
    }

    @GetMapping("/updateprice/{id}")
    public String getUpdatePrice(Model model)
    {
        model.addAttribute("objectDto",new ObjectPriceDto());
        return "/admin/updateprice";
    }

    @PostMapping("/updateprice/{id}")
    public String updatePrice(@Valid ObjectDto objectDto, @PathVariable int id,Model model)
    {
        objectService.updatePrice(id,objectDto.getPrice());
        model.addAttribute("success","You have succesfully updated the price as: "+objectDto.getPrice());
        return "/admin/updateprice";
    }

    @GetMapping("/deleteobject/{id}")
    public String deleteByIdObject(Model model)
    {
        return "/admin/deleteobject";
    }

    @PostMapping("/deleteobject/{id}")
    public String deleteById(@PathVariable int id,Model model){
        objectService.deleteById(id);
        model.addAttribute("success","You have successfully deleted the product.");
        return "/admin/deleteobject";
    }

    @GetMapping("/sortbyprice")
    public String sortByPrice(Model model)
    {
        List<Object> objects=objectService.sortByPrice();
        model.addAttribute("objects",new ObjectMapper().getObjects(objects));
        return "/admin/sortbyprice";
    }
}