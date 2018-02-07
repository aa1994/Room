package com.example.adityaagarwal.room.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by adityaagarwal on 02/02/18.
 */

@Entity
public class Categories {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    public String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
