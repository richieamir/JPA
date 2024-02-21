package com.gdn.training.service.category;

import com.gdn.training.dto.category.CategoryRequest;
import com.gdn.training.entity.Category;
import com.gdn.training.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceBean implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category insert(CategoryRequest categoryRequest) {
    return this.categoryRepository.save(Category.builder()
            .name(categoryRequest.getName())
        .build());
  }

  @Override
  public List<Category> getAll() {
    return this.categoryRepository.findAll();
  }

  @Override
  public Category findById(Long id) {
    return this.categoryRepository.findFirstById(id);
  }
}
