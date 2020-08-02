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
import ro.utcn.project.dto.ResponseDto;
import ro.utcn.project.dto.RoomDto;
import ro.utcn.project.entities.Room;
import ro.utcn.project.mapper.RoomMapper;
import ro.utcn.project.service.RoomService;
import ro.utcn.project.validator.NameValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminRoomController {
    @Autowired
    private RoomService roomService;
    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        log.info("Admin is viewing the rooms.");
        List<Room> rooms=roomService.getAllRooms();
        RoomMapper roomMapper=new RoomMapper();
        List<RoomDto> roomsDto=roomMapper.getRooms(rooms);
        model.addAttribute("rooms",roomsDto);
        model.addAttribute("roomDto",new RoomDto());
        return "admin/rooms";
    }
    @PostMapping("/rooms")
    public String postAllRooms(Model model, @Valid RoomDto roomDto)
    {
        NameValidator roomValidator=new NameValidator();
        if(!roomValidator.validateName(roomDto.getName()))
           model.addAttribute("notValid","This name is not right, please try again.");
        else {
            roomService.insertRoom(new Room(roomDto.getName()));
            log.info("Admin has added the following new room:"+roomDto.getName());
        }
        List<Room> rooms=roomService.getAllRooms();
        RoomMapper roomMapper=new RoomMapper();
        List<RoomDto> roomsDto=roomMapper.getRooms(rooms);
        model.addAttribute("rooms",roomsDto);
        return "admin/rooms";
    }



}
