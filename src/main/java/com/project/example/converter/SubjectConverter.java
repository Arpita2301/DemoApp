package com.project.example.converter;

import com.project.example.DTO.SubjectDTO;
import com.project.example.entity.Subject;
import org.modelmapper.ModelMapper;

import java.util.Optional;


public class SubjectConverter {
    private SubjectConverter(){}
    public static SubjectDTO getSubjectName(Optional<Subject> subject){
        ModelMapper modelMapper = new ModelMapper();
       // SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
        return new ModelMapper().map(subject, new com.google.common.reflect.TypeToken<SubjectDTO>() {
        }.getType());

    }
}
