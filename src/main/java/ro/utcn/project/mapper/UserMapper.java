package ro.utcn.project.mapper;

import ro.utcn.project.dto.DisplayUserDto;
import ro.utcn.project.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public List<DisplayUserDto> getUsers(List<User> users)
    {
        List<DisplayUserDto> usersDTO=new ArrayList<>();
        for(User u:users)
        {
            usersDTO.add(new DisplayUserDto(u));
        }
        return usersDTO;
    }
}
