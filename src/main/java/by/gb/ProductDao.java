package by.gb;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    public void updatePrice(Product product, long newPrice) {
        try(Session session = service.getSession()){
            session.beginTransaction();
            session.createQuery("update Product set price = :price where id = :id")
                    .setParameter("id",product.getId() )
                    .setParameter("price",newPrice)
                    .executeUpdate();
            session.getTransaction().commit();}

    }

    public Product findById(Long id) {
        Session session = service.getSession();//openSession
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findAll() {
        Session session = service.getSession();//openSession
        session.beginTransaction();
        List <Product> products = session.createQuery("select product from Product product").getResultList();
        session.getTransaction().commit();
        return products;
    }

    public void deleteById(Long id) {
        Session session = service.getSession();//openSession
        session.beginTransaction();
        Query query = session.createQuery("delete Product where id = :param");
        query.setParameter("param", id);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        Session session = service.getSession();//openSession
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return null;
    }
}
