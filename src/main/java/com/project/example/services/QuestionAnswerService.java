package com.project.example.services;

import com.project.example.entity.QuestionAnswer;
import com.project.example.helper.ExcelHelper;
import com.project.example.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class QuestionAnswerService {

    @Autowired
    QuestionAnswerRepository questionAnswerRepository;

    public void save(MultipartFile file) {
        try {
            List<QuestionAnswer> questionAnswers = ExcelHelper.excelToQuestionAnswers(file.getInputStream());
            questionAnswerRepository.saveAll(questionAnswers);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<QuestionAnswer> getAllQuestionAnswers() {
        return questionAnswerRepository.findAll();
    }
}
