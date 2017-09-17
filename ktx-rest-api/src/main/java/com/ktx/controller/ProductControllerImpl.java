package com.ktx.controller;

import com.google.common.collect.Lists;
import com.ktx.persistence.model.Product;
import com.ktx.service.ProductServiceImpl;
import com.ktx.util.StatusHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Product Controller",description = "CRUD Operation Controller")
public class ProductControllerImpl<T> extends AbstractController implements ProductControllerInterface {

    @Autowired
    private ProductServiceImpl productService;

    private  final int ZERO=0;

    @GetMapping(value = "/productlist",produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> read() {
        if (!Lists.newArrayList(productService.getAllProductList()).isEmpty()) {
            return new ResponseEntity<List<Product>>(Lists.newArrayList(productService.getAllProductList()), HttpStatus.OK);
        }
        return new ResponseEntity<StatusHandler>(new StatusHandler(HttpStatus.NOT_FOUND.value(),"No Product Entries"),HttpStatus.NOT_FOUND);
    }

    @PostMapping(value ="/newproduct",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<StatusHandler> createProduct(@RequestBody Product newProduct) {
        productService.createProduct(newProduct);
        return new ResponseEntity<StatusHandler>(new StatusHandler(HttpStatus.CREATED.value(),"Product Created"),HttpStatus.CREATED);
    }

    @PutMapping(value = "/editproduct/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<StatusHandler> editProduct(@PathVariable int id, @RequestBody @Valid Product editedProduct) {
        updateInternal(id,editedProduct);
        productService.editproduct(editedProduct);
        return new ResponseEntity<StatusHandler>(new StatusHandler(HttpStatus.OK.value(),"Edit Completed"),HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteproduct/{id}")
    @Override
    public ResponseEntity<StatusHandler> deleteProduct(@PathVariable int id) {
        deleteInternal(id);
        return new ResponseEntity<StatusHandler>(new StatusHandler(HttpStatus.OK.value(),"Delete Completed"),HttpStatus.OK);
    }
}
