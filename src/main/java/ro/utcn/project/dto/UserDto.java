package ro.utcn.project.dto;

import java.util.List;

/**
 * User DTO object.
 */
public class UserDto {

    private String name;
    private String id;
    private List<String> phones;

    private String errorMessage;

    private String firstName;
    private String lastName;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String address;
    private String email;
    private String password;
    private String username;
    private String dateOfBirth;
    private String phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserDto(String name, String id, List<String> phones) {
        this.name = name;
        this.id = id;
        this.phones = phones;
    }

    public UserDto(String firstName, String lastName, String address, String email, String password, String username, String dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }
    public UserDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phones=" + phones +
                '}';
    }

    /**
     * Notice how 'createdAt' is a String in a DTO. Why?
     * I don't want to show to a user an ugly SQL date (2020-04-05T20:40).
     * I will show a pretty date that he can understand better and its familiar with (05.04.2020).
     * Check Utils package classes.
     */
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
