package com.project.example.repository;

import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    @Query(value = "SELECT * FROM subject where sub_id = :#{#subId}" , nativeQuery = true)
    public Subject findBySubId(String subId);

}
