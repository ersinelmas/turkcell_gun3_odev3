package com.example.dataaccess;

import com.example.entities.Course;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int id);
    Course getCourseById(int id);
    List<Course> getAllCourses();
}
