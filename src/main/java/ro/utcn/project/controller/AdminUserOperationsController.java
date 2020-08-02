package ro.utcn.project.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.utcn.project.dto.DisplayUserDto;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.dto.UserAddressDto;
import ro.utcn.project.entities.User;
import ro.utcn.project.entities.enums.Role;
import ro.utcn.project.mapper.UserMapper;
import ro.utcn.project.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserOperationsController {
    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @GetMapping("/allusers")
    public String getAll(Model model) {
        log.info("Admin is viewing all users.");
        List<User> users=userService.getAllUsers();
        List<User> justUsers=new ArrayList<>();
        for(User user:users)
        {
            if(user.getRole().equals(Role.USER))
                justUsers.add(user);

        }
        UserMapper userMapper=new UserMapper();
        List<DisplayUserDto> usersDto= userMapper.getUsers(justUsers);
        model.addAttribute("users",usersDto);
        return "admin/allusers";
    }
    @PostMapping("/allusers")
    public String postAllUsers(Model model)
    {
        List<User> users=userService.getAllUsers();
        List<User> justUsers=new ArrayList<>();
        for(User user:users)
        {
            if(user.getRole().equals(Role.USER))
                justUsers.add(user);

        }
        UserMapper userMapper=new UserMapper();
        List<DisplayUserDto> usersDto= userMapper.getUsers(justUsers);
        model.addAttribute("users",usersDto);
        return "admin/allusers";
    }


    @GetMapping("/updateuseraddress/{username}")
    public String updateUserAddress(Model model)
    {
        model.addAttribute("userAddressDto",new UserAddressDto());
        return "admin/updateuseraddress";
    }

    @PostMapping("/updateuseraddress/{username}")
    public String updateAddress(@Valid UserAddressDto userAddressDto, @PathVariable String username,Model model)
    {
        userService.updateAddress(username,userAddressDto.getAddress());
        model.addAttribute("addressValid","You have successfully updated the user address.");
        log.info("Admin has updated a user address.");
      return "admin/updateuseraddress";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable String id)
    {
        return "admin/deleteuser";
    }
    @PostMapping("/deleteuser/{id}")
    public String deleteUserId(@PathVariable String id, Model model)
    {
        userService.deleteUserById(id);
        model.addAttribute("deleteValid","You have successfully deleted the user.");
        log.info("Admin has deleted a user.");
        return "admin/deleteuser";
    }

}