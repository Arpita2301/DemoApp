package com.project.example.services;

import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.entity.Subject;
import com.project.example.repository.BrandRepository;
import com.project.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;


    public void createBrand(String brandId, String brandName){
        Brand brand = new Brand();
        brand.setBrandId(brandId);
        brand.setBrandName(brandName);
        brandRepository.save(brand);

    }

    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }
}
