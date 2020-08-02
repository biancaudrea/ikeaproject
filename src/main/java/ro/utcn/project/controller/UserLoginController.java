package ro.utcn.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.dto.UserLoginDto;
import ro.utcn.project.entities.User;
import ro.utcn.project.service.UserService;
import ro.utcn.project.validator.UserValidator;

import javax.validation.Valid;
@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;
    private UserValidator userValidator=new UserValidator();

}
