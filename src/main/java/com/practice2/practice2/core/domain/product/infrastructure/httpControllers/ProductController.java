package com.practice2.practice2.core.domain.product.infrastructure.httpControllers;

import com.practice2.practice2.core.domain.product.application.ProductService;
import com.practice2.practice2.core.domain.product.domain.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService repository;

    public ProductController(ProductService repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public String index(Model model, @Param("keyword") String keyword) {

        List<Product> products = repository.indexProducts();

//        if (keyword == null) {
//            repository.indexProducts().forEach(products::add);
//        } else {
//            repository.findProductsByCategory(keyword).forEach(products::add);
//            model.addAttribute("keyword", keyword);
//        }
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
        try {
            this.repository.createProduct(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/products";
    }

    @GetMapping("/product/update/stock")
    public String updateStock(Model model, RedirectAttributes redirectAttributes) {
        try {
            List<Product> products = repository.indexProducts();
            List<Product> newProducts = this.repository.updateAllProductStock();
            model.addAttribute("title", "Productos Actualizados");
            model.addAttribute("products", products);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Product";
    }

    @GetMapping("filterProducts/{category}/{manufacturer}")
    public String filterProducts(@PathVariable String category, @PathVariable String manufacturer, Model model) {
        try {
            List<Product> products = repository.getProductsByFilter(category, manufacturer);
            model.addAttribute("title", "Productos Filtrados");
            model.addAttribute("products", products);
            System.out.println(products);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Product";

    }

    @GetMapping("filterById/{id}")
    public String findProductById(@PathVariable String id, Model model) {
        try {
            Optional<Product> optionalProduct = repository.showProduct(id);
            model.addAttribute("title", "Productos Filtrados");

            if (optionalProduct.isPresent()) {
                model.addAttribute("product", optionalProduct.get());
            } else {
                model.addAttribute("product", null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "ShowProduct";
    }

    @PostMapping("updateProduct")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes) {
        try {
            this.repository.updateProduct(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/products";
    }

    @GetMapping("/product/update/{id}")
    public String updateProduct(Model model, @PathVariable String id) {
        Optional<Product> product = this.repository.showProduct(id);
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("product", product);
        return "Product_form";
    }

}
