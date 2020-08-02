package ro.utcn.project.dto;


import ro.utcn.project.entities.Object;
import ro.utcn.project.entities.OrderPlaced;

import java.util.ArrayList;
import java.util.List;

public class OrderPlacedDto {
    private int id;
    private String status;
    private String dateOfCreation;
    private double price;
    private List<String> objects;

    public List<String> getObjects() {
        return objects;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }

    public OrderPlacedDto(int id, String status, String dateOfCreation, double price) {
        this.id = id;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.price = price;
    }
    public OrderPlacedDto(OrderPlaced orderPlaced)
    {
        this.id=orderPlaced.getId();
        this.status=orderPlaced.getStatus();
        this.dateOfCreation=orderPlaced.getDateOfCreation();
        this.price=orderPlaced.getPrice();
        List<String> list=new ArrayList<>();
        for(Object object:orderPlaced.getObjects())
        {
            list.add(object.getName());
        }
    }
    public OrderPlacedDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}