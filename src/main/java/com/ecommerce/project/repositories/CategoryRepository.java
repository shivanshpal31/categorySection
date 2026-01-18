package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

//Jparepository is the Extended version of CrudRepository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(@NotBlank @Size(min = 5) String categoryName);
}
