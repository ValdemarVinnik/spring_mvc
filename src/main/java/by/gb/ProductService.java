package by.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProduct() {
        return  repository.getAllProduct();
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }
}
