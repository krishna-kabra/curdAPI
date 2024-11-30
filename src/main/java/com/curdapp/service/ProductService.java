package com.curdapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curdapp.Dto.ProductDTO;
import com.curdapp.entity.Product;
import com.curdapp.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductDTO::new);  // Map Product entities to ProductDTO while keeping pagination
    }
    

    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(product);
    }

    public String addProduct(Product product){
        productRepository.save(product);
        return "Product Added Sucessfully";
    }

    public ProductDTO updateProduct(int id,Product product){
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not Found in Id"+id));
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        productRepository.save(existingProduct);
        return new ProductDTO(existingProduct);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
 