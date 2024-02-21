package com.gdn.training.service.product;

import com.gdn.training.dto.product.ProductRequest;
import com.gdn.training.entity.Category;
import com.gdn.training.entity.Product;
import com.gdn.training.repository.product.ProductRepository;
import com.gdn.training.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceBean implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product createProduct(ProductRequest request) {
    Category category = this.categoryService.findById(request.getCategoryId());
    if (category == null) {
      throw new RuntimeException("Cannot find matched category");
    }
    Product product = Product.builder()
        .price(request.getPrice())
        .name(request.getName())
        .category(category)
        .build();
    return this.productRepository.save(product);
  }

  @Override
  public List<Product> getProductWithPriceLessThan(Long price) {
    return this.productRepository.findByPriceLessThan(price);
  }

  @Override
  public List<Product> getBasedOnName(String name) {
    return this.productRepository.findBasedOnName(name);
  }
}
