package com.example.adityaagarwal.room.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.adityaagarwal.room.DAO.CategoryDAO;
import com.example.adityaagarwal.room.DAO.ItemsDAO;
import com.example.adityaagarwal.room.Entity.Categories;
import com.example.adityaagarwal.room.Entity.Items;
import com.example.adityaagarwal.room.Factory.ClassFactory;
import com.example.adityaagarwal.room.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by adityaagarwal on 02/02/18.
 */

@Database(entities = {Categories.class , Items.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    private Context context;

    public abstract CategoryDAO categoryDao();
    public abstract ItemsDAO itemsDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Completable.fromAction(() -> instance.categoryDao().insertListCategories(initializeList(context)))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe();
                        }
                    })
                    .build();
        }
        return instance;
    }

    private static List<Categories> initializeList(Context context) {
        ClassFactory classFactory = new ClassFactory();
        Set<String> listCategories = classFactory.getKeys();
        List<Categories> list = new ArrayList<>();
        for (String s : listCategories) {
            Categories c = new Categories();
            c.setCategory(s);
            list.add(c);
        }
        return list;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
