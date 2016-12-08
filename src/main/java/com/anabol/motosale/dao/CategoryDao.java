package com.anabol.motosale.dao;

import com.anabol.motosale.model.Category;
import java.util.*;

public interface CategoryDao {
    public List<Category> getAll();
    public Category findById(Long id);
    public void insert(Category category);
    public void update(Category category);
    public void deleteById(Long id);
}
