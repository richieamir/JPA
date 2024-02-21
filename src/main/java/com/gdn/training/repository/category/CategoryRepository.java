package com.gdn.training.repository.category;

import com.gdn.training.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
  Category findFirstById(Long id); //select * from categories where id = id limit 1
}
