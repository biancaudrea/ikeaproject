package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.OrderPlaced;

@Repository
public interface OrderPlacedRepository extends JpaRepository<OrderPlaced, String> {
    public OrderPlaced findById(int id);
}
