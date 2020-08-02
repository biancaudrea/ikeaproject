package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.Object;

import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<Object, String> {
    public Object findById(int id);

    @Query("Select o from Object as o order by o.price")
    List<Object> sortByPrice();
}