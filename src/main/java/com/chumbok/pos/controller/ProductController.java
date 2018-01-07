package com.chumbok.pos.controller;

import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.entity.Stock;
import com.chumbok.pos.entity.User;
import com.chumbok.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public ModelAndView showAddProductForm(@RequestParam(required = false) Long id) {

        ModelAndView modelAndView = new ModelAndView();

        if (id!=null){

            modelAndView.addObject("product", productService.getProduct(id));
        }else{
            modelAndView.addObject("product", new Product());
        }

        modelAndView.setViewName("product");
        System.out.println("show products--------------------------nishi");
        return modelAndView;
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public ModelAndView createUpdateProduct(@Valid Product product) {

            ModelAndView modelAndView = new ModelAndView();

            productService.createProduct(product);
            modelAndView.addObject("successMessage", "Product has been registered successfully");

            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("product");
            return modelAndView;

    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public ModelAndView showProducts(@RequestParam(required = false) String displayName) {
        if (displayName==null){
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("products", productService.getAllProducts());
            modelAndView.setViewName("showProducts");

            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("products", productService.searchProduct(displayName));
            modelAndView.setViewName("showProducts");
            System.out.println("nishi-------------showProducts: "+displayName);
            return modelAndView;
        }    }


//-------------------------------------------

    @RequestMapping(value = "/products/doDelete", method = RequestMethod.POST)
    public String deleteProduct(Long id) {

        productService.deleteProduct(id);

        return "redirect:/products";
    }
}