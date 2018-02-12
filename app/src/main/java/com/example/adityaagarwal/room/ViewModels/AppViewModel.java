package com.example.adityaagarwal.room.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.adityaagarwal.room.Database.AppDatabase;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by adityaagarwal on 12/02/18.
 */

public class AppViewModel extends AndroidViewModel {

    private CompositeDisposable disposables;
    protected AppDatabase appDatabase;

    public AppViewModel(@NonNull Application application) {
        super(application);
        disposables = new CompositeDisposable();
        appDatabase = AppDatabase.getAppDatabase(application.getApplicationContext());
    }

    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }
}
