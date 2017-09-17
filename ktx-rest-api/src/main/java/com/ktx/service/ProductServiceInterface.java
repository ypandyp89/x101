package com.ktx.service;

import com.ktx.persistence.model.Product;

public interface ProductServiceInterface {

    Iterable<Product> getAllProductList();

    void createProduct(Product product);

    Product findProudctById(int id);

    Product editproduct(Product product);

    String deleteProduct(int id);
}
