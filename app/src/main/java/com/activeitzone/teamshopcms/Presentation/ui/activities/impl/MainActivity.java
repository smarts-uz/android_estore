package com.activeitzone.teamshopcms.Presentation.ui.activities.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.activeitzone.teamshopcms.Network.response.AppSettingsResponse;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.impl.AccountFragment;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.impl.CartFragment;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.impl.CategoriesFragment;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.impl.HomeFragment;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.impl.ProductSearchFragment;
import com.activeitzone.teamshopcms.R;
import com.activeitzone.teamshopcms.Threading.MainThreadImpl;
import com.activeitzone.teamshopcms.Utils.CustomToast;
import com.activeitzone.teamshopcms.Utils.UserPrefs;
import com.activeitzone.teamshopcms.domain.executor.impl.ThreadExecutor;
import com.activeitzone.teamshopcms.domain.interactors.AppSettingsInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.AppSettingsInteractorImpl;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity implements AppSettingsInteractor.CallBack {

    final Fragment homeFragment = new HomeFragment();
    final Fragment categoriesFragment = new CategoriesFragment();
    private Fragment cartFragment = new CartFragment();
    private Fragment accountFragment = new AccountFragment();
    private Fragment searchFragment = new ProductSearchFragment();
    final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = homeFragment;
    public static BottomNavigationView navView;
    private ImageButton cart, search;
    private TextView title;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    title.setText(R.string.app_name);
                    loadFragment(homeFragment);
                    break;
                case R.id.navigation_categories:
                    title.setText("Categories");
                    loadFragment(categoriesFragment);
                    break;
                case R.id.navigation_search:
                    title.setText("Search");
                    loadFragment(searchFragment);
                    break;
                case R.id.navigation_cart:
                    title.setText("Shopping Cart");
                    loadFragment(cartFragment);
                    break;
                case R.id.navigation_account:
                    title.setText("My Account");
                    loadFragment(accountFragment);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        getSupportActionBar().setElevation(0);

        View view =getSupportActionBar().getCustomView();

        cart = view.findViewById(R.id.action_bar_cart);
        search = view.findViewById(R.id.action_bar_search);
        title = view.findViewById(R.id.nav_title);

        title.setText(R.string.app_name);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navView.setSelectedItemId(R.id.navigation_cart);
                loadFragment(cartFragment);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navView.setSelectedItemId(R.id.navigation_search);
                loadFragment(searchFragment);
            }
        });

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) navView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(3); // number of menu from left
        new QBadgeView(this).bindTarget(v).setBadgeText(String.valueOf(0)).setShowShadow(false);

        fm.beginTransaction().add(R.id.fragment_container, categoriesFragment, "categories").hide(categoriesFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, searchFragment, "search").hide(searchFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, cartFragment, "cart").hide(cartFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, accountFragment, "account").hide(accountFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, homeFragment, "home").commit();

        loadFragment(homeFragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment != homeFragment){
                cart.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
            }
            else {
                cart.setVisibility(View.VISIBLE);
                search.setVisibility(View.VISIBLE);
            }
            if(fragment == cartFragment){
                cartFragment = new CartFragment();
                fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
                fm.beginTransaction().add(R.id.fragment_container, cartFragment, "cart").hide(cartFragment).commitAllowingStateLoss();
                fm.beginTransaction().hide(active).show(cartFragment).commitAllowingStateLoss();
                active = cartFragment;
            }
            else if (fragment == accountFragment){
                accountFragment = new AccountFragment();
                fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
                fm.beginTransaction().add(R.id.fragment_container, accountFragment, "account").hide(accountFragment).commitAllowingStateLoss();
                fm.beginTransaction().hide(active).show(accountFragment).commitAllowingStateLoss();
                active = accountFragment;
            }
            else{
                fm.beginTransaction().hide(active).show(fragment).commit();
                active = fragment;
            }
        }

        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().getExtras() != null){
            String message = getIntent().getStringExtra("message");
            String position = getIntent().getStringExtra("position");

            CustomToast.showToast(this, message, R.color.colorSuccess);
            getIntent().removeExtra("message");
            getIntent().removeExtra("position");

            if(position.equals("cart")){
                loadFragment(cartFragment);
                navView.setSelectedItemId(R.id.navigation_cart);
            }
            else if (position.equals("account")){
                loadFragment(accountFragment);
                navView.setSelectedItemId(R.id.navigation_account);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (active == homeFragment){
            super.onBackPressed();
        }
        else {
            loadFragment(homeFragment);
            navView.setSelectedItemId(R.id.navigation_home);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            new AppSettingsInteractorImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this).execute();
        }
        if (resultCode == Activity.RESULT_CANCELED) {

        }

    }

    @Override
    public void onAppSettingsLoaded(AppSettingsResponse appSettingsResponse) {
        UserPrefs userPrefs = new UserPrefs(this);
        userPrefs.setAppSettingsPreferenceObject(appSettingsResponse, "app_settings_response");

        accountFragment = new AccountFragment();
        fm.beginTransaction().remove(accountFragment).commitAllowingStateLoss();
        fm.beginTransaction().add(R.id.fragment_container, accountFragment, "account").hide(accountFragment).commitAllowingStateLoss();
        fm.beginTransaction().hide(active).show(accountFragment).commitAllowingStateLoss();
        active = accountFragment;
    }

    @Override
    public void onAppSettingsLoadedError() {

    }
}