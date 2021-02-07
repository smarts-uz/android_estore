package com.activeitzone.teamshopcms.Presentation.ui.activities.impl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.activeitzone.teamshopcms.Models.Category;
import com.activeitzone.teamshopcms.Models.SubCategory;
import com.activeitzone.teamshopcms.Models.SubSubCategory;
import com.activeitzone.teamshopcms.Presentation.presenters.SubSubCategoryPresenter;
import com.activeitzone.teamshopcms.Presentation.ui.activities.SubSubCategoryView;
import com.activeitzone.teamshopcms.Presentation.ui.adapters.SubCategoryAdapter;
import com.activeitzone.teamshopcms.Presentation.ui.listeners.SubSubCategoryClickListener;
import com.activeitzone.teamshopcms.R;
import com.activeitzone.teamshopcms.Threading.MainThreadImpl;
import com.activeitzone.teamshopcms.domain.executor.impl.ThreadExecutor;

import java.util.List;

public class SubSubCategoryActivity extends BaseActivity implements SubSubCategoryView, SubSubCategoryClickListener {

    public TextView txtxerror;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sub_category);
        txtxerror = findViewById(R.id.txtxerror);

        Category category = (Category) getIntent().getSerializableExtra("category");

        initializeActionBar();
        setTitle(category.getName());

        SubSubCategoryPresenter subSubCategoryPresenter = new SubSubCategoryPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
        subSubCategoryPresenter.getSubSubCategories(category.getLinks().getSubCategories());
    }

    @Override
    public void setSubSubCategories(List<SubCategory> subCategories) {
        RecyclerView recyclerView = findViewById(R.id.subcategory_list);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        SubCategoryAdapter adapter = new SubCategoryAdapter(this, subCategories);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSubSubCategoryClick(SubSubCategory subSubCategory) {
        Intent intent = new Intent(this, ProductListingActivity.class);
        intent.putExtra("title", subSubCategory.getName());
        intent.putExtra("url", subSubCategory.getLinks().getProducts());
        startActivity(intent);
    }
}
