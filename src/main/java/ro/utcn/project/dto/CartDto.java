package ro.utcn.project.dto;

import java.util.List;

public class CartDto {
    private List<ObjectDto> objects;

    public CartDto(List<ObjectDto> objects) {
        this.objects = objects;
    }

    public CartDto() {
    }

    public List<ObjectDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectDto> objects) {
        this.objects = objects;
    }
}
