package ro.utcn.project.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public Room() {
    }

    @OneToMany(mappedBy="room")
    private List<Category> categories ;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category)
    {
        this.categories.add(category);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
