package com.gdn.training.controller.category;

import com.gdn.training.dto.category.CategoryRequest;
import com.gdn.training.dto.product.ProductRequest;
import com.gdn.training.entity.Category;
import com.gdn.training.entity.Product;
import com.gdn.training.service.category.CategoryService;
import com.gdn.training.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping()
  public List<Category> getAll() throws Exception {
    return this.categoryService.getAll();
  }

  @PostMapping()
  public Category insert(CategoryRequest categoryRequest) throws Exception {
    return this.categoryService.insert(categoryRequest);
  }
}
