package com.project.example.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {
    private String pName;
    private String pId;
    private String brandId;
    private CategoryDTO categoryDTO;


}
