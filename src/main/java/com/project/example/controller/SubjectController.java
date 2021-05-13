package com.project.example.controller;


import com.project.example.DTO.SubjectDTO;
import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import com.project.example.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping(path = "/createSubject")
    public String createStudent(@RequestParam String sub_id,
                                @RequestParam String sub_name
                                ){

        subjectService.createSubject(sub_id, sub_name);
        //create Subject
        return "success";
    }
    @GetMapping(path = "/getAllSubject")
    public List<Subject> getAllSubject(){
        return subjectService.getSubject();
    }

    @GetMapping(path = "/getSubjectById")
    public SubjectDTO getSubjectById(@RequestParam String sub_id){

        return subjectService.getSubjectById(sub_id);
    }

    @GetMapping(path = "/getSubjectNameById")
    public SubjectDTO getSubjectNameById(@RequestParam String subId){

        return subjectService.getSubjectNameById(subId);
    }
}
