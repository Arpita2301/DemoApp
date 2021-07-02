package com.project.example.controller;

import com.project.example.DTO.StudentDTO;
import com.project.example.entity.Student;
import com.project.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRegController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/getAllStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getAllStudent(){
        return studentService.getStudent();
    }

    @PostMapping(path = "/createStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String createStudent(@RequestParam String studId,
                             @RequestParam String studName,
                             @RequestParam String studRollNo,
                             @RequestParam String studBranch){
        //create student
        studentService.createStudent(studId, studName,  studRollNo, studBranch);

        return "success";
    }
    @GetMapping(path = "/getStudentById", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentById(@RequestParam String studId){

        return studentService.getStudentById(studId);
    }
    @PostMapping(path = "/updateStudentDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateStudentDetails(@RequestBody StudentDTO studentDTO){
        studentService.updateStudentDetails(studentDTO);
        return "Student Details Udated Successfully";
    }


}
