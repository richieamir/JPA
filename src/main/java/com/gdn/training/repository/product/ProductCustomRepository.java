package com.gdn.training.repository.product;

import com.gdn.training.entity.Product;

import java.util.List;

public interface ProductCustomRepository {

  List<Product> findByPriceLessThan(Long price);

  List<Product> findBasedOnName(String name);

}
