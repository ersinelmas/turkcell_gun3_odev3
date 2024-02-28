package com.example.dataaccess;

import com.example.entities.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
}
