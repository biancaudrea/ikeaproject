package ro.utcn.project.dto;

import ro.utcn.project.entities.Object;

public class ObjectDto {
    private int id;
    private String name;
    private String manufacturer;
    private double price;

    public ObjectDto() {
    }
    public ObjectDto(int id)
    {

    }
    public ObjectDto(Object object)
    {
        id=object.getId();
        name=object.getName();
        manufacturer=object.getManufacturer();
        price=object.getPrice();
        this.categoryName=object.getCategory().getName();
    }
    public ObjectDto(int id, String name, String manufacturer, double price, String categoryName) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.categoryName=categoryName;
    }

    public ObjectDto(int id, String name, String manufacturer, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryName;
}
