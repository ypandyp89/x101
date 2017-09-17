package com.ktx.service;

import com.ktx.persistence.model.Product;
import com.ktx.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductServiceImpl implements ProductServiceInterface {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Iterable<Product> getAllProductList() {
        return productRepo.findAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findProudctById(int id) {
        return productRepo.findOne(id);
    }

    @Override
    public Product editproduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(int id) {
         productRepo.delete(id);
         return "Product Deleted";
    }
}
