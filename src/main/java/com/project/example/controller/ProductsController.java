package com.project.example.controller;

import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.ProductsDTO;
import com.project.example.entity.Items;
import com.project.example.entity.Products;
import com.project.example.services.CategoryService;
import com.project.example.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController<pubilc> {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/createProducts")
    public String createProducts(@RequestParam String p_id,
                                 @RequestParam String p_name
                                ){
        productsService.createProducts(p_id, p_name);
        return "Success!!!";
    }
    /*
    @PostMapping(path = "/productsIntoCategory")
    public String productsIntoCategory(@RequestParam String p_id,
                                       @RequestParam String c_name){
        productsService.productsIntoCategory(p_id, c_name);
    }*/

    @PostMapping(path = "/createProducts1")
    public String createProducts1(@RequestParam String productName,
                               @RequestParam String brandId,
                               @RequestParam CategoryEnum categoryEnum){


        productsService.createProducts1(productName, brandId, categoryEnum.name());
        return "Success";
    }

    public enum CategoryEnum{
        Office("1"),
        Home("2");
       // private final ProductsService productsService = null;
        private String str;
        CategoryEnum(String str) {
            this.str = str;
        }
      /*  Category() {
            List<com.project.example.entity.Category> categoryList  =  productsService.test();
        }*/

        public String getStr(){
            return str;
        }
    }

    @GetMapping(path = "/getProductsById")
    public List<Products> getAllProducts(@RequestParam String cID){
        return productsService.getAllProducts(cID);


    }

    @GetMapping(path = "/getProductsById1")
    public List<ProductsDTO> getAllProducts1(@RequestParam String cID){
        return productsService.getAllProducts1(cID);
    }

    @PostMapping(path = "CreateOrderList")
    public String CreateOrderList(@RequestParam List<String> productList,
                                  @RequestParam List<Double> NoOfItemsList,
                                  @RequestParam List<Double> priceList,
                                  @RequestParam List<Double> discountPriceList){
        productsService.CreateOrderList(productList,NoOfItemsList, priceList,discountPriceList);
                return("Order Placed Successfully");
    }

    @GetMapping(path = "/getOrderList")
    public List<Items> getOrderList(){
        return productsService.getOrderList();
    }

    @GetMapping(path = "/getOrderDetailsById")
    public Items getOrderDetailsById(@RequestParam String itemId){
        Items result;
        return result = productsService.getOrderDetailsById(itemId);
    }


    @PostMapping(path = "/updateProductName")
    public String updateProductName(@RequestBody ProductsDTO productsDTO){
        productsService.updateProductName(productsDTO);
        return "Product Details Updated Successfully";
    }

}
