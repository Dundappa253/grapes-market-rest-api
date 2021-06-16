package com.motagifarming.grapesmarket.controller;

import com.motagifarming.grapesmarket.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/graphmarket/v1/")
public class ProductController {
    Map<Integer,Product> productDB = new ConcurrentHashMap<>();

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private  HttpServletRequest request;
    
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
    	
    	String query = request.getQueryString();
    	logger.debug("prouctId -- "+query);
    	if(query.endsWith("s")) {
    		logger.debug("successfull") ;
    	}
    	
    	String headerNames = request.getQueryString();
    	 logger.debug("headerName -- "+headerNames);
    	
    	
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
