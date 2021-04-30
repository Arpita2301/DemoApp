package com.project.example.controller;

import com.project.example.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")

public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping(path = "/createBrand")
    public String createBrand(@RequestParam String brandId,
                              @RequestParam String brandName) {
        //test comment
        brandService.createBrand(brandId, brandName);
        return "Success!!!";
    }
}


