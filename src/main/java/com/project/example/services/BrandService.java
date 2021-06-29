package com.project.example.services;

import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.SubjectDTO;
import com.project.example.converter.BrandConverter;
import com.project.example.converter.SubjectConverter;
import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import com.project.example.repository.BrandRepository;
import com.project.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;


    public void createBrand(String brandId, String brandName){
        Brand brand = new Brand();
        brand.setBrandId(brandId);
        brand.setBrandName(brandName);
        brandRepository.save(brand);

    }

    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }

    public BrandDTO getBrandById(String brandId) {
        Brand brand = brandRepository.findByBrandId(brandId);
        BrandDTO brandDTO = BrandConverter.getBrandName(brand);
        return brandDTO;
    }

    public void updateBrandName(BrandDTO brandDTO) {

        Brand brand = brandRepository.findByBrandId(brandDTO.getBrandId());

        if(brand != null){
            brand.setBrandName(brandDTO.getBrandName());
            brandRepository.save(brand);
        }
    }
}
