package com.project.example.converter;

import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.ProductsDTO;
import com.project.example.DTO.SubjectDTO;
import com.project.example.entity.Category;
import com.project.example.entity.Products;
import com.project.example.entity.Subject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Optional;

public class CategoryConverter {

   public static void getCategoryDTO(){

   }

   public static List<CategoryDTO> getCategoryDTOListFromEntityList(List<Category> category) {
      return new ModelMapper().map(category, new TypeToken<List<CategoryDTO>>() {
      }.getType());
   }

   public static CategoryDTO getCName(Category category) {
      ModelMapper modelMapper = new ModelMapper();
      // SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
      return new ModelMapper().map(category, new com.google.common.reflect.TypeToken<CategoryDTO>() {
      }.getType());
   }
}
