package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.Category;
import ro.utcn.project.repo.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void insertCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public Category findByName(String name){return  categoryRepository.findByName(name);}
    public Category findById(int id){return categoryRepository.findById(id);}
}