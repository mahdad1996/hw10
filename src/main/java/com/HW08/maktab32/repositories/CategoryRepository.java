package com.HW08.maktab32.repositories;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Category;

public class CategoryRepository extends CrudRepository<Category,Long> {
    private static CategoryRepository categoryRepository;

    private CategoryRepository() {

    }

    public static CategoryRepository getInstance() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepository();
        }
        return categoryRepository;
    }
    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
