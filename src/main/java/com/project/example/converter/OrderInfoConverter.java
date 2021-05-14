package com.project.example.converter;

import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.OrderInfo;
import com.project.example.entity.Category;
import com.project.example.entity.Items;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class OrderInfoConverter {


   public static List<OrderInfo> getOrderList(List<Items> items) {
      ModelMapper modelMapper = new ModelMapper();
      // SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
      return new ModelMapper().map(items, new com.google.common.reflect.TypeToken<OrderInfo>() {
      }.getType());
   }
}
