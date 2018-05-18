package com.chumbok.pos.controller;

import com.chumbok.pos.dto.ProductWithStockQuantity;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.service.ProductService;
import com.chumbok.pos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public ModelAndView showAddProductForm(@RequestParam(required = false) Long id) {
        System.out.println("get product");
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
    public ModelAndView createUpdateProduct(@RequestParam(value = "id", required = false) Long id, @Valid Product product) {
        System.out.println("post product");
        ModelAndView modelAndView = new ModelAndView();

        if(id==null){
            productService.createProduct(product);
            modelAndView.addObject("successMessage", "Product has been added successfully");

            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("product");
        }else if (id!=null){
            productService.updateProduct(product);
            modelAndView.addObject("successMessage", "Product has been updated successfully");

            modelAndView.addObject("product", product);
            modelAndView.setViewName("product");
        }
        return modelAndView;
    }

   /* @RequestMapping(path = "/products", method = RequestMethod.GET)
    public ModelAndView showProducts(@RequestParam(required = false) String displayName) {
        if (displayName == null) {
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("products", productService.getAllProducts());
            modelAndView.setViewName("showProducts");

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("products", productService.searchProduct(displayName));
            modelAndView.setViewName("showProducts");
            System.out.println("nishi-------------showProducts: " + displayName);
            return modelAndView;
        }
    }*/

    //-------------------------------------------
    @RequestMapping(value = "/pageable", method = RequestMethod.GET)
    public ModelAndView productPageable(Pageable pageable) { //Page<Product>
        ModelAndView modelAndView = new ModelAndView();

      //Page<Product> productList = productService.findAllByPage(pageable);

        Page<ProductWithStockQuantity> pageProductListWithStockQuantity = productService.findProductWithStockQuantityByPage(pageable);

        modelAndView.addObject("page", pageProductListWithStockQuantity);
        modelAndView.addObject("pageable", pageable);
        modelAndView.setViewName("productPagination");
        return modelAndView;
    }
//-------------------------------------------

    @RequestMapping(value = "/products/doDelete", method = RequestMethod.POST)
    public String deleteProduct(@RequestParam(required = false) List<Long> ids, Long id) {

        if (ids == null) {
            productService.deleteProduct(id);
        } else {
            productService.deleteBulkProduct(ids);
        }

        return "redirect:/home";
    }
}