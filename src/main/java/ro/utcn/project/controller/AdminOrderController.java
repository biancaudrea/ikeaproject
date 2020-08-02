package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.utcn.project.dto.OrderPlacedDto;
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.email.EmailService;
import ro.utcn.project.entities.Object;
import ro.utcn.project.entities.OrderPlaced;
import ro.utcn.project.mapper.OrderPlacedMapper;
import ro.utcn.project.service.ObjectService;
import ro.utcn.project.service.OrderPlacedService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    @Autowired
    private OrderPlacedService orderPlacedService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @Autowired
    private ObjectService objectService;

    @GetMapping("/allorders")
    public String getAllOrders(Model model)
    {
        log.info("Admin is viewing all orders");
        List<OrderPlacedDto> orders=new OrderPlacedMapper().getOrders(orderPlacedService.getAllOrdersPlaced());
        model.addAttribute("orders",orders);
        return "/admin/allorders";
    }

    @GetMapping("/updatestatus/{id}")
    public String updateStatusGet(Model model)
    {
        return "/admin/updatestatus";
    }

    @PostMapping("/updatestatus/{id}")
    public String updateStatus( @PathVariable int id,Model model)
    {


        if(orderPlacedService.updateStatus(id,"Approved")==true) {

            OrderPlaced orderPlaced = orderPlacedService.findById(id);
            List<Object> objectsOrdered = orderPlaced.getObjects();
            for (Object o : objectsOrdered) {
                objectService.deleteById(o.getId());
            }
            String text="We are glad to let you know that your order has been succesfully placed. Your total will be: "+orderPlaced.getPrice()+". Expect the delivery anytime up to maximum 5 days.";
            new EmailService("IKEA Order Confirmation",text,orderPlaced.getUser().getEmail());
            model.addAttribute("success","You have succesfully confirmed the order. The email has been sent.");
            log.info("Admin has confirmed an order.");
           }
        else
            model.addAttribute("error","The order status did not change.");
        return "/admin/updatestatus";

    }


}
