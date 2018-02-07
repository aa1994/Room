package com.example.adityaagarwal.room.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adityaagarwal.room.Entity.Categories;
import com.example.adityaagarwal.room.R;
import com.example.adityaagarwal.room.ViewModels.CategoriesViewModel;
import com.example.adityaagarwal.room.Views.CategoriesView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityaagarwal on 05/02/18.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Categories> categoriesList = new ArrayList<>();
    private CategoriesViewModel viewModel;

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CategoriesView view = (CategoriesView) LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewModel = new CategoriesViewModel(categoriesList.get(position));
        CategoriesView view = (CategoriesView) holder.itemView;
        view.bindTo(viewModel);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
        notifyDataSetChanged();
    }

}
