package ro.utcn.project.dto;

import ro.utcn.project.entities.Object;

public class ObjectForOrderDto {
    private int id;
    private String name;

    public ObjectForOrderDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectForOrderDto() {
    }
    public ObjectForOrderDto(Object object)
    {
        this.id=object.getId();
        this.name=object.getName();
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
}
