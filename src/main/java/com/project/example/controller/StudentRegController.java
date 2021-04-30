package com.project.example.controller;

import com.project.example.entity.Student;
import com.project.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRegController {
    @Autowired
    public StudentService studentService;

    @GetMapping(path = "/getAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getStudent();
    }

    @PostMapping(path = "/createStudent")
    public String createStudent(@RequestParam String stud_id,
                             @RequestParam String stud_name,
                             @RequestParam String stud_rollNo,
                             @RequestParam String stud_branch){
        //create student
        studentService.createStudent(stud_id, stud_name,  stud_rollNo, stud_branch);

        return "success";
    }
    @GetMapping(path = "/getStudentById")
    public List<Student> getStudentById(@RequestParam String stud_id){

        return studentService.getStudentById(stud_id);
    }

}
