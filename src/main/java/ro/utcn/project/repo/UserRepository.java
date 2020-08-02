package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.User;

/**
 * User repository interface.
 * Please read Spring JPA documentation or take a look at some examples to understand the mechanism it uses.
 *
 *  Generally, the query creation mechanism for JPA works as described in “Query methods”.
 *  The following example shows what a JPA query method translates into:
 *
 * List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
 * User findById(String id);
 *
 *  We create a query using the JPA criteria API from this, but,
 *  essentially, this translates into the following query:
 *  "SELECT u FROM User u WHERE u.emailAddress = ?1 AND u.lastname = ?2" (JPQL Querry)
 *
 * Please read the following links:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation.
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.named-queries.
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUsername(String username);

    public User findByEmail(String email);
    @Modifying
    @Query("delete from User u where u.id = ?1")
    void delete(String id);

    public User findById(int id);


}
