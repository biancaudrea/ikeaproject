package ro.utcn.project.mapper;

import ro.utcn.project.dto.UserDto;
import ro.utcn.project.entities.User;

/**
 * In this class you do the conversion from/to Entity-DTOs.
 * You can edit this classes/package name with mappers instead of populators.
 */

public class UserPopulator {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        return dto;
    }

}
