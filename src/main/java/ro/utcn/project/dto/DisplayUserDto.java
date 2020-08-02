package ro.utcn.project.dto;


import ro.utcn.project.entities.User;

public class DisplayUserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    public String getId() {
        return id;
    }

    public DisplayUserDto() {
    }
    public DisplayUserDto(User user)
    {
        this.username=user.getUsername();
        this.id=user.getId();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.address=user.getAddress();
        this.age=user.getAge();
        this.email=user.getEmail();
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String address;
    private int age;
    private String email;
}
