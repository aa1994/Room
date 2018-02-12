package com.example.adityaagarwal.room.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.adityaagarwal.room.R;
import com.example.adityaagarwal.room.ViewModels.ItemDetailsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by adityaagarwal on 08/02/18.
 */

public class ItemDetailsActivity extends BaseActivity {

    @BindView(R.id.floating_button)
    FloatingActionButton floatingButton;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ItemDetailsViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_layout);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ItemDetailsViewModel.class);

        floatingButton.setOnClickListener(view -> {
            Snackbar.make(view, "CLICKED", Snackbar.LENGTH_LONG).show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
