package by.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductRepository repository;
    private ProductService service;



    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Product> getProductList(Model model) {
        List<Product> productList = service.getAllProduct();
        return productList;
    }


    @GetMapping("/add")

    public void getForm(@RequestParam String title, @RequestParam Integer price) {
        Product product = new Product(title,price);
        service.addProduct(product);
    }

    @PostMapping("/addNew")
    @ResponseBody
    public String create(Product product) {
        service.addProduct(product);
        return product.toString() + "added";
    }

}
