package com.example.business;

import com.example.dataaccess.CategoryDao;
import com.example.entities.Category;
import com.example.logging.BaseLogger;

import java.util.List;

public class CategoryManager {
    private CategoryDao categoryDao;
    private BaseLogger[] loggers;

    public CategoryManager(CategoryDao categoryDao, BaseLogger[] loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }
    public void addCategory(Category category) throws Exception {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new Exception("Category name cannot be empty.");
        }
        else if (category.getName().length() < 2) {
            throw new Exception("Category name cannot be shorter than 2 characters.");
        }
        List<Category> existingCategories = categoryDao.getAllCategories();

        if (existingCategories != null) {
            for (Category existingCategory : existingCategories) {
                if (existingCategory.getName().equals(category.getName())) {
                    throw new Exception("Category name already exists.");
                }
            }
        }

        categoryDao.addCategory(category);

        for (BaseLogger logger : loggers) {
            logger.log("Category added: " + category.getName());
        }
    }

    public void deleteCategory(int id) {
        categoryDao.deleteCategory(id);
        for (BaseLogger logger : loggers) {
            logger.log("Category deleted: " + categoryDao.getCategoryById(id).getName());
        }
    }

    public void updateCategory(Category category) throws Exception {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new Exception("Category name cannot be empty.");
        }
        else if (category.getName().length() < 2) {
            throw new Exception("Category name cannot be shorter than 2 characters.");
        }
        List<Category> existingCategories = categoryDao.getAllCategories();
        if (existingCategories != null){
            for (Category existingCategory : existingCategories) {
                if (existingCategory.getName().equals(category.getName())) {
                    throw new Exception("Category name already exists.");
                }
            }
        }
        categoryDao.updateCategory(category);
        for (BaseLogger logger : loggers) {
            logger.log("Category updated: " + category.getName());
        }
    }

    public void listCategories() {
        List<Category> categories = categoryDao.getAllCategories();
        for (Category category : categories) {
            System.out.println(category.getName());
        }
        System.out.println("Categories listed.");
        for (BaseLogger logger : loggers) {
            logger.log("Categories listed.");
        }
    }
}
