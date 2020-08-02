package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.User;
import ro.utcn.project.repo.UserRepository;

import java.util.List;

/**
 * Please check the following links:
 * https://www.baeldung.com/spring-security-authentication-with-a-database.
 * https://docs.spring.io/spring-security/site/docs/3.0.x/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * The UserDetailsService is used to load the user from a back-end structure like database.
     * The loadUserByUsername method is called when a user tries to login with a username and password,
     * then it is the responsibility of the service to load the user definition and return it to the security framework.
     * The required details includes data like username, password, accountNonExpired, credentialsNonExpired, accountNonLocked and authorities.
     *
     * Once the spring security receives the user object, it will validate the user against the password entered by the user and other data like
     * user account status (accountNonExpired, credentialsNonExpired etc)
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    /**
     * Please check the User entity @toString method
     */
    public String getSessionUserUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
    public User getSessionUser()
    {
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void insertUser(User user)
    {
        userRepository.save(user);
    }
    public void updateAddress(String username,String address){
        User user=findUserByUsername(username);
        user.setAddress(address);
        insertUser(user);
    }
    public User findUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
    public User findUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public User findUserById(String id) {
        return userRepository.findById(id).get();
    }
    public void deleteUserById(String id)
    {
        userRepository.delete(findUserById(id));
    }
}
