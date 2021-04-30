package com.project.example.services;

import com.project.example.entity.Student;
import com.project.example.repository.StudentRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

@Autowired
StudentRegRepository studentRegRepository;

 public List<Student> getStudent(){
    // List<Student> studentList =  studentRegRepository.findAll();
     //return studentList;
     return studentRegRepository.findAll();
 }

 public void createStudent(String stud_id, String stud_name, String stud_rollno ,String stud_branch){
     Student  student = new Student();
     student.setStud_id(stud_id);
     student.setStud_name(stud_name);
     student.setStud_rollno(stud_rollno);
     student.setStud_branch(stud_branch);
     studentRegRepository.save(student);
 }

 public List<Student> getStudentById(String stud_id){
     return  studentRegRepository.findByStudId(stud_id);
 }
}
