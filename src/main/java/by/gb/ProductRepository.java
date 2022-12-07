package by.gb;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> list;

    @PostConstruct
    private List<Product> init() {
        return list = new ArrayList<Product>(Arrays.asList(new Product("bread", 10L),
                new Product("milk", 15L),
                new Product("salt", 2L),
                new Product("sugar", 25L),
                new Product("butter", 50L)));
    }

    public void printProductList() {
        list.stream().forEach(e -> System.out.println(e));
    }

    public void printProductById(int id) {
        System.out.println(list.stream().filter(e -> e.getId() == id).findFirst().get().toString());
    }
    public List<Product> getAllProduct(){
        return list;
    }

    public String getList(){
        StringBuilder productList = new StringBuilder();
        for (Product each : list){
            productList.append(each.toString()+"\n");
        }
        return productList.toString();
    }

    public Product getProductById(int id) {
        Product product = list.stream().filter((e) -> e.getId() == id).findFirst().get();
        return product;
    }

    public void addProduct(Product product) {
        list.add(product);
    }
}
