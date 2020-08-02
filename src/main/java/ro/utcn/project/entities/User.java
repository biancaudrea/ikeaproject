package ro.utcn.project.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import ro.utcn.project.entities.enums.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * The user entity extends the UserDetails interface.
 * Please check this link:
 * https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetails.html.
 */
@Entity
public class User implements UserDetails {

    @Id
    private String id= UUID.randomUUID().toString();

    @Column
    private String username;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String dateOfBirth;

    @Column
    private String address;

    @Column
    private int age;

    @Column
    private String email;

    @Column
    private String dateOfRegistration;


    @Column
    private String password;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy="user")
    private List<OrderPlaced> ordersPlaced;

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<OrderPlaced> getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(List<OrderPlaced> ordersPlaced) {
        this.ordersPlaced=ordersPlaced;
    }

    public User(String username, String lastName, String firstName, String dateOfBirth, String address, String email, String password, LocalDate today, String phoneNumber) {
        this.role=Role.USER;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.password=password;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirthDateFormat = LocalDate.parse(dateOfBirth, formatter);
        Period p=Period.between(dateOfBirthDateFormat,today);
        this.age=p.getYears();
        this.dateOfRegistration=String.valueOf(today);

        this.phoneNumber=phoneNumber;

    }


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + username + '\'' +
                '}';
    }





    /**
     * Use TemporalType.DATE if you just need the specific day (ex: 2020-02-04).
     * Use TemporalType.TIMESTAMP if you just need both the day and hour time (ex: 2020-02-04 T20:03:04)

    @Column
    @Temporal(TemporalType.DATE)
    //   @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;*/

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    /**
     * Return the roles here.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        /**
         * Add each role as a SimpleGrantedAuthority.
         * If you got only OneToOne relation, then return the list with only one element.
         */
       // authorities.add(new SimpleGrantedAuthority("USER"));
       // authorities.add(new SimpleGrantedAuthority("ADMIN"));

        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        return authorities;
    }

    /**
     * All this fields are from UserDetails.
     */
    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * This is used to retrieve the session user username.
     * Please do not remove or change it.
     * @return - the authenticated user username.
     */

}
