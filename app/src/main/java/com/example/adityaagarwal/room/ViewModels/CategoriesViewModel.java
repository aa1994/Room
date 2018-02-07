package com.example.adityaagarwal.room.ViewModels;

import com.example.adityaagarwal.room.Entity.Categories;

/**
 * Created by adityaagarwal on 07/02/18.
 */

public class CategoriesViewModel {

    private Categories category;

    public CategoriesViewModel(Categories categories) {
        this.category = categories;
    }

    public String getCategoryName() {
        return category.getCategory();
    }
}
