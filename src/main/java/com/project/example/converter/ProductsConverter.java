package com.project.example.converter;

import com.project.example.DTO.ProductsDTO;
import com.project.example.entity.Products;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class ProductsConverter {

   public static void getProductsDTO(){

   }

   public static List<ProductsDTO> getProductsDTOListFromEntityList(List<Products> products) {
      return new ModelMapper().map(products, new TypeToken<List<ProductsDTO>>() {
      }.getType());
   }
}
