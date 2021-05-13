package com.project.example.services;

import com.project.example.DTO.SubjectDTO;
import com.project.example.converter.SubjectConverter;
import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import com.project.example.repository.StudentRegRepository;
import com.project.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRegRepository studentRegRepository;


    public void createSubject(String sub_id, String sub_name) {
        String studentId = "101";
        Student student = studentRegRepository.getOne(studentId);
        Subject subject = new Subject();
        subject.setSub_id(sub_id);
        subject.setSub_name(sub_name);
        // subject.setStudent(student);
        subjectRepository.save(subject);
    }


    public List<Subject> getSubject() {
        return subjectRepository.findAll();
    }

    public SubjectDTO getSubjectById(String sub_id) {
        Optional<Subject> subject = subjectRepository.findById(sub_id);
        SubjectDTO subjectDTO = SubjectConverter.getSubjectName(subject);
        return subjectDTO;

    }

    public SubjectDTO getSubjectNameById(String subId) {
        Subject subject =  subjectRepository.findBySubId(subId);
        SubjectDTO subjectDTO = SubjectConverter.getSubName(subject);
        return subjectDTO;
    }
}
