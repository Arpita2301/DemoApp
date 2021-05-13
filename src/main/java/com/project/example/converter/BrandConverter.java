package com.project.example.converter;

import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.SubjectDTO;
import com.project.example.entity.Brand;
import com.project.example.entity.Subject;
import org.modelmapper.ModelMapper;

import java.util.Optional;


public class BrandConverter {
    private BrandConverter(){}
    public static BrandDTO getBrandName(Brand brand){
        ModelMapper modelMapper = new ModelMapper();
       // SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
        return new ModelMapper().map(brand, new com.google.common.reflect.TypeToken<BrandDTO>() {
        }.getType());

    }
}
