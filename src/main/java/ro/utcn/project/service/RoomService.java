package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.Room;
import ro.utcn.project.repo.RoomRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public void insertRoom(Room room)
    {
        roomRepository.save(room);
    }
    public Room findByName(String name){return roomRepository.findByName(name);}
}
