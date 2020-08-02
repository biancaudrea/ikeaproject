package ro.utcn.project.dto;


import ro.utcn.project.entities.Room;

public class RoomDto {
    private int id;

    public RoomDto(String name) {
        this.name = name;
    }

    public RoomDto() {
    }

    public RoomDto(Room room)
    {
        this.id=room.getId();
        this.name=room.getName();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}