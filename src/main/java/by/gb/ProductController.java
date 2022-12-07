package by.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")

public class ProductController {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String getProductList(Model uiModel) {
        List<Product> productList = repository.getAllProduct();
        uiModel.addAttribute("products", productList);
        return "products";
    }


    @GetMapping("/add")
   // @RequestMapping(params = "/add", method = RequestMethod.GET)
    public String getForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addPage";
    }

    @PostMapping("/addNew")
    @ResponseBody
    public String create(Product product) {
        repository.addProduct(product);
        return product.toString() + "added";
    }

}
