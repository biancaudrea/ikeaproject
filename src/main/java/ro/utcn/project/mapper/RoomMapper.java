package ro.utcn.project.mapper;

import ro.utcn.project.dto.RoomDto;
import ro.utcn.project.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {
    public List<RoomDto> getRooms(List<Room> rooms)
    {
        List<RoomDto> roomsDto=new ArrayList<>();
        for(Room r:rooms)
        {
            roomsDto.add(new RoomDto(r));
        }
        return roomsDto;
    }
}
