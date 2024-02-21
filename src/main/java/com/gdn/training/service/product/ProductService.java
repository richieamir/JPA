package com.gdn.training.service.product;

import com.gdn.training.dto.product.ProductRequest;
import com.gdn.training.entity.Product;

import java.util.List;

public interface ProductService {
  List<Product> getAllProducts();

  Product createProduct(ProductRequest product);

  List<Product> getProductWithPriceLessThan(Long Price);

  List<Product> getBasedOnName(String name);
}
