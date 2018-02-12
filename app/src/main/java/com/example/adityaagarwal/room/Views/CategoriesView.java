package com.example.adityaagarwal.room.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adityaagarwal.room.R;
import com.example.adityaagarwal.room.ViewModels.CategoriesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adityaagarwal on 07/02/18.
 */

public class CategoriesView extends LinearLayout {

    @BindView(R.id.category_layout)
    LinearLayout categoryLayout;

    @BindView(R.id.category_text)
    TextView categoryText;

    CategoriesViewModel viewModel;
    Listener clickListener = Listener.NoOp;

    public interface Listener {

        void onClick(CategoriesViewModel viewModel);

        Listener NoOp = (vm) -> {
        };
    }

    public CategoriesView(Context context) {
        super(context);
    }

    public CategoriesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void bindTo(CategoriesViewModel viewModel) {
        this.viewModel = viewModel;
        requestLayout();
        validateView();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setClickListener(Listener clickListener) {
        this.clickListener = clickListener;
        categoryLayout.setOnClickListener(view -> {
            clickListener.onClick(viewModel);
        });
    }

    private void validateView() {
        categoryText.setText(viewModel.getCategoryName());
    }

}

