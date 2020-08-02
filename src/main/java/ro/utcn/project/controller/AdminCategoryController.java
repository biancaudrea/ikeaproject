package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.utcn.project.dto.CategoryDto;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.dto.RoomDto;
import ro.utcn.project.entities.Category;
import ro.utcn.project.entities.Room;
import ro.utcn.project.mapper.CategoryMapper;
import ro.utcn.project.mapper.RoomMapper;
import ro.utcn.project.service.CategoryService;
import ro.utcn.project.service.RoomService;
import ro.utcn.project.validator.NameValidator;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/admin/")
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RoomService roomService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        log.info("Admin is viewing all categories.");
        List<Category> categories=categoryService.getAllCategories();
        CategoryMapper categoryMapper=new CategoryMapper();
        List<CategoryDto> categoryDtos=categoryMapper.getCategories(categories);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("categoryDto",new CategoryDto());
        List<Room> rooms=roomService.getAllRooms();
        List<RoomDto> roomDtos=new RoomMapper().getRooms(rooms);
        model.addAttribute("rooms",roomDtos);
        return "admin/categories";
    }

    @PostMapping( "/categories")
    public String processForm(@Valid CategoryDto categoryDto,Model model)
    {
        NameValidator categoryValidator=new NameValidator();
        if(categoryValidator.validateName(categoryDto.getName())==false) {
            log.warn("Admin has tried to create an invalid category.");
            model.addAttribute("notValid", "This name is not right, please try again.");
        }
        else {
            Room room = roomService.findByName(categoryDto.getRoomName());
            categoryService.insertCategory(new Category(categoryDto.getName(),room));
            List<Category> categories=categoryService.getAllCategories();
            CategoryMapper categoryMapper=new CategoryMapper();
            List<CategoryDto> categoryDtos=categoryMapper.getCategories(categories);
            model.addAttribute("categories",categoryDtos);
            List<Room> rooms=roomService.getAllRooms();
            List<RoomDto> roomDtos=new RoomMapper().getRooms(rooms);
            model.addAttribute("rooms",roomDtos);
            log.info("Admin has created a new category: "+categoryDto.getName());
        }

        return "admin/categories";
    }


}