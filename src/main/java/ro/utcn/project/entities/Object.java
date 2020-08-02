package ro.utcn.project.entities;

import javax.persistence.*;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private String manufacturer;

    @Column
    private double price;

    @ManyToOne
    private OrderPlaced orderPlaced;

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

    public OrderPlaced getOrderPlaced() {
        return orderPlaced;
    }

    public boolean setOrderPlaced(OrderPlaced orderPlaced) {
        if(this.orderPlaced==null) {
            this.orderPlaced = orderPlaced;
            return true;
        }
        return false;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    private Category category;

    public Object(String name, String manufacturer, double price, Category category) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
    }
    public Object()
    {

    }
    public Room getRoom()
    {
        return category.getRoom();
    }
}
