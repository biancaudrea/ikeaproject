package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public Category findById(int id);
    public Category findByName(String name);
}