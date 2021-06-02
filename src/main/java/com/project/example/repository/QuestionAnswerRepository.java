package com.project.example.repository;

import com.project.example.entity.FileUpload;
import com.project.example.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, String> {
}
