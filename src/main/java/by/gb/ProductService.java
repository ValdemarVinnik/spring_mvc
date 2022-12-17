package by.gb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductService {

    private static final String SRC_PATH = "hibernate.cfg.xml";

    private ProductDao productDao;
    private SessionFactory factory;

    public ProductService() {

    }

    @PostConstruct
    private void init(){
        this.factory = factory = new Configuration()
                .configure(SRC_PATH)
                .buildSessionFactory();

    }

    @Autowired
    public void setProductDao(@Lazy ProductDao productDao) {
        this.productDao = productDao;
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shutdown(){
        if (factory != null) {
            factory.close();
        }
    }

    public List<Product> getAllProducts(){
        return productDao.findAll();
    }

    public Product getProductByID(long id) {
        return productDao.findById(id);
    }

    public void deleteById(long id) {
        productDao.deleteById(id);
    }

    public void saveProduct(Product product){
        productDao.saveOrUpdate(product);
    }



    public void updatePrice(Product product, long newPrice) {
        productDao.updatePrice(product, newPrice);
    }
}
