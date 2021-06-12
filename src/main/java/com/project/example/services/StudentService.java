package com.project.example.services;

import com.project.example.DTO.StudentDTO;
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

 public void createStudent(String studId, String studName, String studRollno ,String studBranch){
     Student  student = new Student();
     student.setStudId(studId);
     student.setStudName(studName);
     student.setStudRollno(studRollno);
     student.setStudBranch(studBranch);
     studentRegRepository.save(student);
 }

 public List<Student> getStudentById(String studId){

     return  studentRegRepository.findByStudId(studId);
 }

    public void updateStudentDetails(StudentDTO studentDTO) {
     Student student = studentRegRepository.findByStudRollno(studentDTO.getStudRollno());

     if(student != null){
         student.setStudName(studentDTO.getStudName());
         student.setStudRollno(studentDTO.getStudRollno());
         student.setStudBranch(studentDTO.getStudBranch());
         studentRegRepository.save(student);
     }
    }

}
