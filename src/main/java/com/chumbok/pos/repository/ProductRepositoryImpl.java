package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Product> getFirstNamesLike() {

        Query query = entityManager.createNativeQuery("SELECT * FROM product p INNER JOIN (SELECT product_id, SUM(quantiy) quantityInStock FROM stock GROUP BY product_id) ps ON p.id =ps.product_id", Product.class);
        //query.setParameter(1, productId + "%");
        return query.getResultList();
    }
}
