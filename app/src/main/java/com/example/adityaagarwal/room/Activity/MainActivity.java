package com.example.adityaagarwal.room.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adityaagarwal.room.Adapters.CategoriesAdapter;
import com.example.adityaagarwal.room.Factory.ClassFactory;
import com.example.adityaagarwal.room.R;
import com.example.adityaagarwal.room.ViewModels.MainActivityViewModel;
import com.example.adityaagarwal.room.Views.CategoriesView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private CategoriesAdapter adapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        adapter = new CategoriesAdapter();
        adapter.setClickListener(clickListener);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        viewModel.getCategories().observe(this, categories -> adapter.setCategoriesList(categories));
    }

    CategoriesView.Listener clickListener = viewModel -> {
        ClassFactory classFactory = new ClassFactory();
        Intent intent = new Intent(this, classFactory.getActivity(viewModel.getCategoryName()));
        startActivity(intent);
    };

}
