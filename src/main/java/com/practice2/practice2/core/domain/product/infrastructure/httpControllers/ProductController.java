package com.practice2.practice2.core.domain.product.infrastructure.httpControllers;

import com.practice2.practice2.core.domain.product.application.ProductService;
import com.practice2.practice2.core.domain.product.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService repository;

    public ProductController(ProductService repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public String index(Model model) {
//        Product product = new Product();
//        product.setId("P1234");
//        product.setName("Iphone 6s");
//        product.setUnitPrice(500.00);
//        product.setDescription("Telefono iphone 6s with muchas cositas");
//        product.setManufacturer(7.5);
//        product.setCategory("Smartphones");
//        product.setUnitsInStock(20L);
//        product.setUnitsInOrder(10L);
//        product.setDiscontinued(false);
//        product.setCondition("Nuevo");
        List<Product> products = repository.indexProducts();
        System.out.println(products);
        model.addAttribute("title", "Productos");
        model.addAttribute("products", products);
        return "Product";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("title", "Nuevo Producto");
        model.addAttribute("product", product);
        return "Product_form";
    }

    @PostMapping("/product/add")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        try{
            this.repository.createProduct(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/products";
    }
    
}
