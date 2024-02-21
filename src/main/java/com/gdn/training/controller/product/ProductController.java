package com.gdn.training.controller.product;

import com.gdn.training.dto.product.ProductRequest;
import com.gdn.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gdn.training.service.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping()
  public List<Product> getAllProduct() throws Exception {
    return this.productService.getAllProducts();
  }

  @PostMapping()
  public Product createProduct(ProductRequest product) throws Exception {
    return this.productService.createProduct(product);
  }

  @GetMapping("/price-less-than/{price}")
  public List<Product> getProductLessThanPrice(@PathVariable String price) throws Exception {
    return this.productService.getProductWithPriceLessThan(Long.valueOf(price));
  }

  @GetMapping("/{product-name}")
  public List<Product> getBasedOnName(@PathVariable String name) throws Exception {
    return this.productService.getBasedOnName(name);
  }

}
