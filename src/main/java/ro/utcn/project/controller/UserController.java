package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.constants.EndpointsRoutes;
import ro.utcn.project.service.UserService;

/**
 * User endpoints controller
 * You can add this path to route constants too.
 * Just be careful to separate ROOT paths from specific endpoints routes.
 *
 * Controllers can also provide security  at each endpoint (method/request mapping).
 * (Please check the annotations @PreAuthorize).
 */

@Controller("")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("tufisi")
    private ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tufisi");
        return modelAndView;
    }

}
