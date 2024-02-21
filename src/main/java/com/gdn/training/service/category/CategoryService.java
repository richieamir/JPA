package com.gdn.training.service.category;

import com.gdn.training.dto.category.CategoryRequest;
import com.gdn.training.entity.Category;

import java.util.List;

public interface CategoryService {
  Category insert(CategoryRequest categoryRequest);

  List<Category> getAll();

  Category findById(Long id);
}
