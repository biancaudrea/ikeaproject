package ro.utcn.project.mapper;

import ro.utcn.project.dto.CategoryDto;
import ro.utcn.project.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public List<CategoryDto> getCategories(List<Category> categories)
    {
        List<CategoryDto> categoriesDto=new ArrayList<>();
        for(Category c:categories)
        {
            categoriesDto.add(new CategoryDto(c));
        }
        return categoriesDto;
    }
}