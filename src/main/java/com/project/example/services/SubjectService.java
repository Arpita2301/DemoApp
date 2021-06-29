package com.project.example.services;

import com.project.example.DTO.StudentDTO;
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
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRegRepository studentRegRepository;


    public void createSubject(String subId, String subName) {
        String studentId = "101";
        Student student = studentRegRepository.getOne(studentId);
        Subject subject = new Subject();
        subject.setSubId(subId);
        subject.setSubName(subName);
        // subject.setStudent(student);
        subjectRepository.save(subject);
    }


    public List<Subject> getSubject() {
        return subjectRepository.findAll();
    }

    public SubjectDTO getSubjectById(String subId) {
        Optional<Subject> subject = subjectRepository.findById(subId);
        SubjectDTO subjectDTO = SubjectConverter.getSubjectName(subject);
        return subjectDTO;

    }

    public SubjectDTO getSubjectNameById(String subId) {
        Subject subject =  subjectRepository.findBySubId(subId);
        SubjectDTO subjectDTO = SubjectConverter.getSubName(subject);
        return subjectDTO;
    }

    public void updateSubjectDetails(SubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findBySubId(subjectDTO.getSubId());

        if(subject != null){
            subject.setSubId(subjectDTO.getSubId());
            subject.setSubName(subjectDTO.getSubName());
            subjectRepository.save(subject);
        }
    }
}
