package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{


//    private List<Category> categories=new ArrayList<>();
//    private long nextId=1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
//        return categoryRepository;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++);
//        categoryRepository.add(category);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId){

        Category savedCategory=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        categoryRepository.delete(savedCategory);

        return "Deletion Successfully";
//        List<Category> categories=categoryRepository.findAll();
//        Category category=categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
//
//        if(category==null){
//            return "Category Not found";
//        }
//
//        categoryRepository.delete(category);
//
//        return "Category with category ID: "+categoryId+" deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, long categoryId) {

        Optional<Category> savedCategoryOptional=categoryRepository.findById(categoryId);

        Category savedCategory=savedCategoryOptional
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resoruce not found"));

        category.setCategoryId(categoryId);

        return savedCategory;
//        Optional<Category> optionalCategory=categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if (optionalCategory.isPresent()) {
//            Category exisitingCategory=optionalCategory.get();
//            exisitingCategory.setCategoryName(category.getCategoryName());
//            return categoryRepository.save(exisitingCategory);
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found");
//        }
    }
}
