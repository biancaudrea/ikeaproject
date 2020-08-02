package ro.utcn.project.dto;


import ro.utcn.project.entities.Category;

public class CategoryDto {
    private int id;
    private String name;
    private String roomName;
    public CategoryDto(int id, String name,String roomName) {
        this.roomName=roomName;
        this.id = id;
        this.name = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public CategoryDto() {
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

    public CategoryDto(Category category)
    {
        this.id=category.getId();
        this.name=category.getName();
    }
}
