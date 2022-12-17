package by.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductDao repository;
    private ProductService service;



    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Product> getProductList(Model model) {
        List<Product> productList = service.getAllProducts();
        return productList;
    }


    @GetMapping("/add")

    public void getForm(@RequestParam String title, @RequestParam Integer price) {
        Product product = new Product(title,price);
        service.saveProduct(product);
    }

}
