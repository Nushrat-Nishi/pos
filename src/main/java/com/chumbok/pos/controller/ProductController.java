package com.chumbok.pos.controller;

import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> getProducts() {
        List<Product> list = productService.getAllProducts();
        return list;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public PersistedObjId createProduct(@RequestBody @Valid Product product) {
        productService.createProduct(product);
        return new PersistedObjId(product.getId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("id") Long id, @RequestBody @Valid Product product) {
        product.setId(id);
        productService.updateProduct(product);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}