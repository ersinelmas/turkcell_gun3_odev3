package com.example.dataaccess;

import com.example.entities.Course;

import java.util.List;

public class HibernateCourseDao implements CourseDao{
    @Override
    public void addCourse(Course course) {
        System.out.println("Course added to the database by hibernate: " + course.getName());
    }

    @Override
    public void updateCourse(Course course) {
        System.out.println("Course updated in the database by hibernate: " + course.getName());
    }

    @Override
    public void deleteCourse(int id) {
        System.out.println("Course deleted from the database by hibernate: " + id);
    }

    @Override
    public Course getCourseById(int id) {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }
}
