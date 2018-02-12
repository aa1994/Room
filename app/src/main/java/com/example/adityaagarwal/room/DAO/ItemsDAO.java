package com.example.adityaagarwal.room.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.adityaagarwal.room.Entity.Items;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by adityaagarwal on 09/02/18.
 */

@Dao
public interface ItemsDAO {

    @Query("SELECT * FROM Items WHERE categoryType LIKE :category")
    Flowable<List<Items>> getItems(String category);
}
