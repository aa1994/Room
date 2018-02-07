package com.example.adityaagarwal.room.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adityaagarwal.room.Adapters.CategoriesAdapter;
import com.example.adityaagarwal.room.Database.AppDatabase;
import com.example.adityaagarwal.room.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private AppDatabase appDatabase;
    private CategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appDatabase = AppDatabase.getAppDatabase(this);
        adapter = new CategoriesAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        setCategoriesList();
    }

    private void setCategoriesList() {

        disposablesBase(appDatabase.categoryDao().getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categories -> adapter.setCategoriesList(categories)));
    }
}
