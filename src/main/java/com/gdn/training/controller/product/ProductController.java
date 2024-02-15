package com.gdn.training.controller.product;

import com.gdn.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gdn.training.product.ProductService;

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

}
