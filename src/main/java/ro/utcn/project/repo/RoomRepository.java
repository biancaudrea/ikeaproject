package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    public Room findByName(String name);
}
