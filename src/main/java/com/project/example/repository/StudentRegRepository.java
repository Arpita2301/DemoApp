package com.project.example.repository;

import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegRepository  extends JpaRepository<Student, String> {
    @Query(value = "SELECT * FROM student where stud_id = :#{#studId}" , nativeQuery = true)
    public List<Student> findByStudId(String studId);
}
