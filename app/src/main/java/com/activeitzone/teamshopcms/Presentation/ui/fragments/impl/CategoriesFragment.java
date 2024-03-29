package com.activeitzone.teamshopcms.Presentation.ui.fragments.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeitzone.teamshopcms.Models.Category;
import com.activeitzone.teamshopcms.Presentation.presenters.CategoryPresenter;
import com.activeitzone.teamshopcms.Presentation.ui.activities.impl.SubSubCategoryActivity;
import com.activeitzone.teamshopcms.Presentation.ui.adapters.AllCategoryAdapter;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.CategoryView;
import com.activeitzone.teamshopcms.Presentation.ui.listeners.AllCategoryClickListener;
import com.activeitzone.teamshopcms.R;
import com.activeitzone.teamshopcms.Threading.MainThreadImpl;
import com.activeitzone.teamshopcms.Utils.AppConfig;
import com.activeitzone.teamshopcms.domain.executor.impl.ThreadExecutor;
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class CategoriesFragment extends Fragment implements CategoryView, AllCategoryClickListener, SwipeRefreshLayout.OnRefreshListener {
    private View v;
    private CategoryPresenter categoryPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Category> mCategories = new ArrayList<>();
    private RecyclerView recyclerView;
    private AllCategoryAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_categories, null);

        mSwipeRefreshLayout = v.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        recyclerView = v.findViewById(R.id.category_list);
        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AllCategoryAdapter(getActivity(), mCategories, CategoriesFragment.this);
        recyclerView.addItemDecoration( new LayoutMarginDecoration( 1,  AppConfig.convertDpToPx(getContext(), 5)) );
        recyclerView.setAdapter(adapter);

        categoryPresenter = new CategoryPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
        categoryPresenter.getAllCategories();

        return v;
    }

    @Override
    public void setAllCategories(List<Category> categories) {
        mCategories.clear();
        mCategories.addAll(categories);
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(getContext(), SubSubCategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        categoryPresenter.getAllCategories();
    }
}
