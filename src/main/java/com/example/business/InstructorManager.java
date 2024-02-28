package com.example.business;

import com.example.dataaccess.InstructorDao;
import com.example.entities.Instructor;
import com.example.logging.BaseLogger;

import java.util.List;

public class InstructorManager {
    private InstructorDao instructorDao;
    private BaseLogger[] loggers;

    public InstructorManager(InstructorDao instructorDao, BaseLogger[] loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    public void addInstructor(Instructor instructor) throws Exception{
        if(instructor.getName() == null || instructor.getName().isEmpty()){
            throw new Exception("Instructor name cannot be empty.");
        }
        else if(instructor.getName().length() < 2){
            throw new Exception("Instructor name cannot be shorter than 2 characters.");
        }
        List<Instructor> existingInstructors = instructorDao.getAllInstructors();
        if (existingInstructors != null){
            for (Instructor existingInstructor : existingInstructors) {
                if (existingInstructor.getName().equals(instructor.getName())) {
                    throw new Exception("Instructor name already exists.");
                }
            }
        }
        instructorDao.addInstructor(instructor);
        for (BaseLogger logger : loggers) {
            logger.log("Instructor added: " + instructor.getName());
        }
    }

    public void deleteInstructor(int id) {
        instructorDao.deleteInstructor(id);
        for (BaseLogger logger : loggers) {
            logger.log("Instructor deleted: " + instructorDao.getInstructorById(id).getName());
        }
    }

    public void updateInstructor(Instructor instructor) throws Exception {
        if(instructor.getName() == null || instructor.getName().isEmpty()){
            throw new Exception("Instructor name cannot be empty.");
        }
        else if(instructor.getName().length() < 2){
            throw new Exception("Instructor name cannot be shorter than 2 characters.");
        }
        List<Instructor> existingInstructors = instructorDao.getAllInstructors();
        if (existingInstructors != null) {
            for (Instructor existingInstructor : existingInstructors) {
                if (existingInstructor.getName().equals(instructor.getName())) {
                    throw new Exception("Instructor name already exists.");
                }
            }
        }
        instructorDao.updateInstructor(instructor);
        for (BaseLogger logger : loggers) {
            logger.log("Instructor updated: " + instructor.getName());
        }

    }

    public void listInstructors() {
        List<Instructor> instructors = instructorDao.getAllInstructors();
        for (Instructor instructor : instructors) {
            System.out.println(instructor.getName());
        }
        for (BaseLogger logger : loggers) {
            logger.log("Instructors listed.");
        }
    }
}