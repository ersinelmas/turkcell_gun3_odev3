package com.example.business;

import com.example.dataaccess.CourseDao;
import com.example.entities.Course;
import com.example.logging.BaseLogger;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private BaseLogger[] loggers;

    public CourseManager(CourseDao courseDao, BaseLogger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void addCourse(Course course) throws Exception {
        if(course.getName() == null || course.getName().isEmpty()){
            throw new Exception("Course name cannot be empty.");
        }
        else if(course.getName().length() < 2){
            throw new Exception("Course name cannot be shorter than 2 characters.");
        }
        List<Course> existingCourses = courseDao.getAllCourses();
        if (existingCourses != null){
            for (Course existingCourse : existingCourses) {
                if (existingCourse.getName().equals(course.getName())) {
                    throw new Exception("Course name already exists.");
                }
            }
        }
        if (course.getPrice()<0){
            throw new Exception("Course price cannot be negative.");
        }
        courseDao.addCourse(course);
        for (BaseLogger logger : loggers) {
            logger.log("Course added: " + course.getName());
        }
    }

    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
        for (BaseLogger logger : loggers) {
            logger.log("Course deleted: " + courseDao.getCourseById(id).getName());
        }
    }

    public void updateCourse(Course course) throws Exception {
        if(course.getName() == null || course.getName().isEmpty()){
            throw new Exception("Course name cannot be empty.");
        }
        else if(course.getName().length() < 2){
            throw new Exception("Course name cannot be shorter than 2 characters.");
        }
        List<Course> existingCourses = courseDao.getAllCourses();

        if (existingCourses != null){
            for (Course existingCourse : existingCourses) {
                if (existingCourse.getName().equals(course.getName())) {
                    throw new Exception("Course name already exists.");
                }
            }
        }

        if (course.getPrice() < 0){
            throw new Exception("Course price cannot be negative.");
        }
        courseDao.updateCourse(course);
        for (BaseLogger logger : loggers) {
            logger.log("Course updated: " + course.getName());
        }
    }

    public void listCourses() {
        List<Course> courses = courseDao.getAllCourses();
        for (Course course : courses) {
            System.out.println(course.getName());
        }
        System.out.println("Courses listed.");
        for (BaseLogger logger : loggers) {
            logger.log("Courses listed.");
        }
    }
}
