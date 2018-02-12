package com.example.adityaagarwal.room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.adityaagarwal.room.Entity.Categories;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by adityaagarwal on 02/02/18.
 */

@Dao
public interface CategoryDAO {

    @Insert
    void insertCategory(Categories categories);

    @Insert
    void insertListCategories(List<Categories> categories);

    @Query("SELECT * FROM CATEGORIES")
    Flowable<List<Categories>> getCategories();
}
