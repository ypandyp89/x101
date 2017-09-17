package com.ktx.controller;

import com.ktx.persistence.model.Product;
import com.ktx.util.StatusHandler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductControllerInterface<T> {


    public ResponseEntity<T> read();

    public ResponseEntity<StatusHandler> createProduct(Product product);

    public ResponseEntity<StatusHandler> editProduct(int id, Product product);

    public ResponseEntity<StatusHandler> deleteProduct(int id);
}
