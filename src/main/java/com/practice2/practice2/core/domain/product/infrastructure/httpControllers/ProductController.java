package com.practice2.practice2.core.domain.product.infrastructure.httpControllers;

import com.practice2.practice2.core.domain.product.application.ProductService;
import com.practice2.practice2.core.domain.product.domain.Product;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController implements WebMvcConfigurer {

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
    public String create(@Valid Product product, @RequestParam("file") MultipartFile file, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Product_form";
        }
        try {
            this.repository.createProduct(product, file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/products";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable String id, @ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            this.repository.updateProduct(product, file);
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


    @GetMapping("/product/update/{id}")
    public String updateProduct(Model model, @PathVariable String id) {
        Optional<Product> productOptional = this.repository.showProduct(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            String imagePath = product.getImage();
            model.addAttribute("title", "Editar Producto");
            model.addAttribute("product", product);
            model.addAttribute("imagePath", imagePath);
            return "Product_edit_form";
        } else {
            // Manejar el caso donde el producto no se encuentra
            return "redirect:/products";
        }
    }

    @GetMapping(value = "productXml/{id}", produces = "application/xml")
    @ResponseBody
    public Product getProduct(@PathVariable String id) {
        return repository.showProduct(id).orElse(null);
    }
}
