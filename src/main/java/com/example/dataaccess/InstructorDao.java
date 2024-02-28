package com.example.dataaccess;

import com.example.entities.Instructor;

import java.util.List;

public interface InstructorDao {
    void addInstructor(Instructor instructor);
    void updateInstructor(Instructor instructor);
    void deleteInstructor(int id);
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();
}
