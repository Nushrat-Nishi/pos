package com.chumbok.pos.controller;

import com.chumbok.pos.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;






    /*@RequestMapping(path = "/product", method = RequestMethod.GET)
    public ModelAndView showAddProductForm(@RequestParam(required = false) Long id) {

        ModelAndView modelAndView = new ModelAndView();

        if (id != null) {

            modelAndView.addObject("product", productService.getProduct(id));
        } else {
            modelAndView.addObject("product", new Product());
        }

        modelAndView.setViewName("product");

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

    }*/


}