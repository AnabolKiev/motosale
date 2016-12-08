package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.CategoryRepository;
import com.anabol.motosale.model.Category;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        Iterator<Category> i = categoryRepository.findAll().iterator();
        while (i.hasNext()) {
            categories.add(i.next());
        }
        return categories;
    }

    public Category findById(Long id) {
        Category category = categoryRepository.findOne(id);
        return category;
    }

    public void insert(Category category) {
        categoryRepository.save(category);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.delete(id);
    }

}