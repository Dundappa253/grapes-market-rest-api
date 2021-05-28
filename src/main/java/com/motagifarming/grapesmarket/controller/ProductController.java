package com.motagifarming.grapesmarket.controller;

import com.motagifarming.grapesmarket.model.Product;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/graphmarket/v1/")
public class ProductController {
    Map<Integer,Product> productDB = new ConcurrentHashMap<>();



    @GetMapping(path = "products")
    public Collection<Product> getProductList(){
        if(productDB.isEmpty()){
            Product product = new Product();
            product.setId(100);
            product.setAvaiable(true);
            product.setRate(BigDecimal.valueOf(45));
            product.setCategory("Grapes");
            product.setProductName("Sonaka");
            productDB.put(100,product);
        }

        return productDB.values();
    }

    @PutMapping(path = "products/{prouctId}")
    public Product updateProuct(@PathParam("prouctId") Integer productId,
                                @RequestBody Product product){
        productDB.put(productId,product);
        return productDB.get(productId);
    }

    @PostMapping(path = "products")
    public Product saveProduct(@RequestBody Product product){
        int productId = new Random().nextInt();
        product.setId(productId);
        productDB.put(productId,product);
        return productDB.get(productId);
    }
}
