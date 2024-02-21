package com.gdn.training.repository.product;

import com.gdn.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductCustomRepositoryImpl implements ProductCustomRepository{

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<Product> findByPriceLessThan(Long price) {
    TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.price < :price ", Product.class);
    query.setParameter("price", price);
    return query.getResultList();
  }

  @Override
  public List<Product> findBasedOnName(String name) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
    Root<Product> root = criteriaQuery.from(Product.class);

    Predicate condition = criteriaBuilder.equal(root.get("name"), "%" + name + "%");
    criteriaQuery.where(condition);

    TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery);
    return typedQuery.getResultList();
  }
}
