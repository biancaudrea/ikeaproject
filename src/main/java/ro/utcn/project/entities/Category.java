package ro.utcn.project.entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy="category")
    private List<Object> objects ;

    public String getName() {
        return name;
    }

    public Category() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    public Category(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    public void addObject(Object object)
    {
        this.objects.add(object);
    }
}