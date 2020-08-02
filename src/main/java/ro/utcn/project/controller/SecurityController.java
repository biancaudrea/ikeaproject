package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.constants.EndpointsRoutes;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.dto.UserLoginDto;
import ro.utcn.project.entities.User;
import ro.utcn.project.service.UserService;
import ro.utcn.project.validator.UserValidator;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Here add the basic security endpoints:login, register, default redirect if login success
 */
@Controller
public class SecurityController {
    private UserValidator userValidator= new UserValidator();
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private UserService userService;

    @GetMapping(EndpointsRoutes.HOME)
    private ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        log.info("Loged user doing this request is:" + userService.getSessionUserUsername());
        return modelAndView;
    }


    @GetMapping(EndpointsRoutes.REGISTER)
    private ModelAndView register(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("userDto",new UserDto());
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/register")
    public String processForm(@Valid UserDto userDto, Model model) {

        if (userValidator.validateFirstName(userDto.getFirstName()) == false) {
            model.addAttribute("firstNameNotValid", "Sorry but this first name is not valid!");
            return "register";

        } else if (userValidator.validateLastName(userDto.getLastName()) == false) {

            model.addAttribute("lastNameNotValid", "Sorry but this last name is not valid!");
            return "register";

    }

        else if(userValidator.validateAddress(userDto.getAddress())==false)
        {
            model.addAttribute("addressNotValid","Sorry but this address is not valid!");
            return "register";
        }
        else if(userValidator.validateDate(userDto.getDateOfBirth())==false)
        {
            model.addAttribute("dateNotValid","Sorry but this date is not valid!");
            return "register";
        }
        else if(userValidator.validatePhoneNumber(userDto.getPhoneNumber())==false)
        {
            model.addAttribute("phoneNumberNotValid","Sorry but this phone number is not valid!");
            return "register";
        }
        else if(userValidator.validateUserEmail(userDto.getEmail())==false)
        {
            model.addAttribute("emailNotValid","Sorry but this email is not valid!");
            return "register";
        }
        else if(userValidator.validateUsername(userDto.getUsername())==false)
        {            model.addAttribute("usernameNotValid","Sorry but this username is not valid, length should be larger than 4.");
            return "register";
        }
        else if(userValidator.validatePassword(userDto.getPassword())==false)
        {        model.addAttribute("passwordNotValid","Sorry but this password is not valid, length should be larger than 4.");
            return "register";
        }

        else {
            LocalDate today = LocalDate.now();
            String password = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
            User user = new User(userDto.getUsername(), userDto.getLastName(), userDto.getFirstName(), userDto.getDateOfBirth(), userDto.getAddress(),userDto.getEmail(), password, today,userDto.getPhoneNumber());

            userService.insertUser(user);
           return EndpointsRoutes.LOGIN;

        }

    }
    @GetMapping("login")
    public ModelAndView sendForm(Model model)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        model.addAttribute("userLoginDTO", new UserLoginDto());
        return modelAndView;
    }
   /* public String login(User user, String password)
    {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean rightPassword = encoder.matches(password, user.getPassword());
        if (rightPassword == true) {
            if(user.getRole().equals("ROLE_USER"))
                return "/user";

            else
                return "/admin";

        }
        else
        {
            return "/login";
        }
    }


    @PostMapping("/login")
    public String doLogin(@Valid UserLoginDto userLoginDto, Model model, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors() == false) {
            if(userValidator.validateUsername(userLoginDto.getUsernameOrEmail())==false)
            {
                model.addAttribute("usernameNotValid","This field cannot be empty, size larger than 4, please.");
                return "/login";  }
            else if(userValidator.validatePassword(userLoginDto.getPassword())==false)
            {
                model.addAttribute("passwordNotValid","This field cannot be empty, size larger than 4, please.");
                return "/login";}
            else {
                User user = userService.findUserByUsername(userLoginDto.getUsernameOrEmail());
                if (user == null) {
                    user = userService.findUserByEmail(userLoginDto.getUsernameOrEmail());
                }
                if (user != null) {
                    String a=login(user,userLoginDto.getPassword());
                    if(a.equals("/login"))
                    {
                        model.addAttribute("passwordNotValid","The password you have entered is not valid.");
                    }
                    return a;

                }
                // model.addAttribute("usernameNotValid", "There is no account for this username or email.");
                return "/login";
            }
        }

        model.addAttribute("usernameNotValid", "There is no account for this username or email.");
        return "/login";

    }
*/
}
