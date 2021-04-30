package com.project.example.DTO;

import com.project.example.entity.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    private String cName;
    private Brand brand;
}
