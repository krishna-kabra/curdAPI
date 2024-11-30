package com.curdapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curdapp.Dto.ProductDTO;
import com.curdapp.entity.Product;
import com.curdapp.service.ProductService;

@RestController
@RequestMapping("/apis/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
public ResponseEntity<Page<ProductDTO>> getAllProducts(
    @RequestParam(defaultValue = "0") int page, 
    @RequestParam(defaultValue = "2") int size
) {
    Pageable pageable = PageRequest.of(page, size);
    Page<ProductDTO> products = productService.getAllProducts(pageable);
    return ResponseEntity.ok(products);
}


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
            ResponseEntity.ok(productService.addProduct(product));
            return "Product added Sucessfully";
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id,@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "Product Deleted Sucessfully";
    }

}
