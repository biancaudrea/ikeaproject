package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.dto.ObjectDto;
import ro.utcn.project.dto.ObjectForOrderDto;
import ro.utcn.project.dto.OrderPlacedDto;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.entities.Object;
import ro.utcn.project.entities.OrderPlaced;
import ro.utcn.project.entities.User;
import ro.utcn.project.mapper.ObjectForOrderMapper;
import ro.utcn.project.mapper.ObjectMapper;
import ro.utcn.project.mapper.OrderPlacedMapper;
import ro.utcn.project.service.ObjectService;
import ro.utcn.project.service.OrderPlacedService;
import ro.utcn.project.service.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPlaceOrderController {
    @Autowired
    ObjectService objectService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    OrderPlacedService orderPlacedService;

    @Autowired
    UserService userService;

    @GetMapping("/allorders")
    public String getAllOrders(Model model)
    {
        log.info("User is viewing all orders");
        User user=userService.getSessionUser();
        List<OrderPlacedDto> list= new OrderPlacedMapper().getOrders(user.getOrdersPlaced());
        model.addAttribute("orders",list);
        return "/user/allorders";
    }

    @GetMapping("/createorder")
    public String createOrder(Model model)
    {

        model.addAttribute("order",new OrderPlacedDto());
        List<ObjectForOrderDto> objects = new ObjectForOrderMapper().getObjects( objectService.getAllObjects());
        model.addAttribute("objects", objects);
        return "/user/createorder";
    }
    @PostMapping("/createorder")
    public String createOrderPost(Model model, @Valid OrderPlacedDto order)
    {
        User userLoggedIn=userService.getSessionUser();
        LocalDate today = LocalDate.now();
        List<String> objectIds=order.getObjects();
        List<Object> objectsToInsertInOrder=new ArrayList<>();
        for(String objectId:objectIds)
        {
            objectsToInsertInOrder.add(objectService.findById(Integer.valueOf(objectId)));
        }
        boolean objectsNotAlreadyOrdered=true;
        for(Object obj:objectsToInsertInOrder)
        {
            if(obj.getOrderPlaced()!=null)
                objectsNotAlreadyOrdered=false;
        }
        if(objectsNotAlreadyOrdered==true) {

            OrderPlaced newOrder=new OrderPlaced(userLoggedIn,String.valueOf(today),objectsToInsertInOrder);
            orderPlacedService.insertOrder(newOrder);
            for (Object o : objectsToInsertInOrder) {
                objectService.updateOrder(o, newOrder);
            }
            log.info("A new order has been placed by "+newOrder.getUser().getUsername());
            model.addAttribute("success","You have successfully placed the order! Click below to view your orders.");

        }
        else
            model.addAttribute("error","Some of the items you have selected are not available right now.");

        return "/user/createorder";
    }
}
