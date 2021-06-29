package com.project.example.services;

import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.OrderInfo;
import com.project.example.DTO.ProductsDTO;
import com.project.example.converter.ProductsConverter;
import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.entity.Items;
import com.project.example.entity.Products;
import com.project.example.repository.BrandRepository;
import com.project.example.repository.CategoryRepository;
import com.project.example.repository.ItemsRepository;
import com.project.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductsService {


    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    public void createProducts(String p_id, String p_name){
     /*   Products products = new Products();
        products.setP_id(p_id);
        products.setP_name(p_name);
        productsRepository.save(products);*/
    }

    public void createProducts1(String productName,String brandId, String catName){
        Category category = categoryRepository.findByCName(catName);
        Brand brand = brandRepository.findByBrandId(brandId);
        Products products = new Products();
        String pId = UUID.randomUUID().toString();
        products.setPId(pId);
        products.setPName(productName);
        products.setCategory(category);
        products.setBrand(brand);
        productsRepository.save(products);
    }

    /*public void productsIntoCategory(String p_id, String c_name) {

        Products products = new Products();
        products.setP_id(p_id);
        Category category1 = new Category();
        category1.getC_name(c_name);
    }*/


    public List<Category> test() {
        List<Category> categoryList =  categoryRepository.findAll();
        return categoryList;
    }

//    public List<Products> getAllProducts(String cId) {
//        List<Products> productList = productsRepository.findByCId(cId);
//        return productList;
//    }
    public List<Products> getAllProducts(String cId) {
        List<Products> productsList = productsRepository.findByCId(cId);
        return productsList;
    }


    public List<ProductsDTO> getAllProducts1(String cId) {
        List<Products> productsList =  productsRepository.findByCId(cId);
        return ProductsConverter.getProductsDTOListFromEntityList(productsList);

    }

    public void CreateOrderList(List<String> productList, List<Double> noOfItemsList,
                                List<Double> priceList, List<Double> discountPriceList) {

        List<Products> productList1 = new ArrayList<>();

        int i = 0,j= 0, k=0, l=0;
        HashMap<Integer, OrderInfo> hm = new HashMap<Integer, OrderInfo>();
        for (String pName : productList){
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setPname(pName);
            hm.put(i,orderInfo);
            i++;
        }

        for (double noOfItems : noOfItemsList){
            OrderInfo orderInfo = hm.get(j);
            orderInfo.setNoofitems(noOfItems);
            hm.put(j, orderInfo);
            j++;
        }

        for (double price : priceList){
            OrderInfo orderInfo = hm.get(k);
            orderInfo.setPrice(price);
            hm.put(k, orderInfo);
            k++;
        }

        for (double discountPrice : discountPriceList){
            OrderInfo orderInfo = hm.get(l);
            orderInfo.setDiscountPrice(discountPrice);
            hm.put(l, orderInfo);
            l++;

        }
        Double val1;
        Double val2;
        Double val3;
        for (Map.Entry<Integer, OrderInfo> entry : hm.entrySet()) {
            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
            Items items = new Items();
            String itemId = UUID.randomUUID().toString();
            items.setItemId(itemId);
            items.setPName(entry.getValue().getPname());
            items.setNoOfItems(entry.getValue().getNoofitems());
            val1 = entry.getValue().getNoofitems() * entry.getValue().getPrice();
            items.setPrice(val1);
            val2 = entry.getValue().getPrice() * entry.getValue().getDiscountPrice()/100;
            items.setDiscountPrice(val2);
            val3 = val1 * 10/100;
            items.setTotalDiscount(val3);

            itemsRepository.save(items);
        }
    }


    public List<Items> getOrderList() {
        return itemsRepository.findAll();
    }

    public Items getOrderDetailsById(String itemId) {
        return itemsRepository.findByItemId(itemId);
    }


    public void updateProductName(ProductsDTO productsDTO) {
        Products products = productsRepository.findBypId(productsDTO.getPId());

        if(products != null){
            products.setPName(productsDTO.getPName());
            productsRepository.save(products);
        }
    }
}
