package ro.utcn.project.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class OrderPlaced {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String status;
    @Column
    private String dateOfCreation;
    @Column
    private double price;

    public OrderPlaced( User user,String dateOfCreation,List<Object> objects) {
        this.objects=objects;
        this.status = "Pending";
        this.dateOfCreation = dateOfCreation;
        this.user=user;
        double totalPrice=0;
        for(Object o:objects)
            totalPrice+=o.getPrice();
        this.price =totalPrice;
    }

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="orderPlaced")
    private List<Object> objects;


    public String getStatus() {
        return status;
    }

    public boolean setStatus(String status) {
        if(this.status.equals(status)) {
            return false;

        }
        this.status = status;
        return true;
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
    public void addObject(Object object)
    {
        this.objects.add(object);
        this.price+=object.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public OrderPlaced()
    {

    }
}