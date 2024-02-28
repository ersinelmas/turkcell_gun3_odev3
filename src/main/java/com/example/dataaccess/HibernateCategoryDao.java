package com.example.dataaccess;

import com.example.entities.Category;

import java.util.List;

public class HibernateCategoryDao implements CategoryDao{
    @Override
    public void addCategory(Category category) {
        System.out.println("Category added to the database by hibernate: " + category.getName());
    }

    @Override
    public void updateCategory(Category category) {
        System.out.println("Category updated in the database by hibernate: " + category.getName());
    }

    @Override
    public void deleteCategory(int id) {
        System.out.println("Category deleted from the database by hibernate: " + id);
    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
