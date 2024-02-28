package com.example.dataaccess;

import com.example.entities.Instructor;

import java.util.List;

public class HibernateInstructorDao implements InstructorDao {
    @Override
    public void addInstructor(Instructor instructor) {
        System.out.println("Instructor added to the database by hibernate: " + instructor.getName());
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        System.out.println("Instructor updated in the database by hibernate: " + instructor.getName());
    }

    @Override
    public void deleteInstructor(int id) {
        System.out.println("Instructor deleted from the database by hibernate: " + id);
    }

    @Override
    public Instructor getInstructorById(int id) {
        return null;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return null;
    }
}
