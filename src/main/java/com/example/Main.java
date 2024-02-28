package com.example;

import com.example.business.*;
import com.example.dataaccess.HibernateCategoryDao;
import com.example.dataaccess.JdbcCourseDao;
import com.example.dataaccess.JdbcInstructorDao;
import com.example.entities.*;
import com.example.logging.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Instructor instructor = new Instructor(1, "Engin Demiroğ", "engindemirog@gmail.com", "05345678900");
        Category category = new Category(1, "Programlama");
        Course course = new Course(1, "Java & React", 150, category, instructor);

        BaseLogger[] loggers = {new ConsoleLogger(), new FileLogger(), new MailLogger()};
        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), loggers);
        instructorManager.addInstructor(instructor);

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers);
        categoryManager.addCategory(category);

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(),loggers);
        courseManager.addCourse(course);
    }
}