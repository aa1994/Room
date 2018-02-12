package com.example.adityaagarwal.room.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.adityaagarwal.room.Database.AppDatabase;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by adityaagarwal on 07/02/18.
 */

public class BaseActivity extends AppCompatActivity {

    private CompositeDisposable disposables;
    public AppDatabase appDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        disposables = new CompositeDisposable();

        appDatabase = AppDatabase.getAppDatabase(this);

    }

    public Disposable disposablesBase(Disposable disposable) {
        disposables.add(disposable);
        return disposable;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}
