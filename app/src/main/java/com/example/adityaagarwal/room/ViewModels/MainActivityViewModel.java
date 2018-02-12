package com.example.adityaagarwal.room.ViewModels;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.adityaagarwal.room.Entity.Categories;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.adityaagarwal.room.Utils.ListUtils.nullCheck;

/**
 * Created by adityaagarwal on 12/02/18.
 */

public class MainActivityViewModel extends AppViewModel {

    private MutableLiveData<List<Categories>> categories;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        setCategories();
    }

    private void setCategories() {
        addDisposable(appDatabase.categoryDao().getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categories1 -> getCategories().setValue(categories1)));
    }

    public MutableLiveData<List<Categories>> getCategories() {
        return nullCheck(categories, categories = new MutableLiveData<>());
    }


}
