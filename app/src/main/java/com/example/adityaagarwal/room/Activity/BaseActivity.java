package com.example.adityaagarwal.room.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by adityaagarwal on 07/02/18.
 */

public class BaseActivity extends AppCompatActivity {

    private CompositeDisposable disposables;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        disposables = new CompositeDisposable();
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
