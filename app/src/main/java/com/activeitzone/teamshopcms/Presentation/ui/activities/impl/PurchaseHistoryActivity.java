package com.activeitzone.teamshopcms.Presentation.ui.activities.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.activeitzone.teamshopcms.Models.PurchaseHistory;
import com.activeitzone.teamshopcms.Network.response.AuthResponse;
import com.activeitzone.teamshopcms.Presentation.presenters.PurchaseHistoryPresenter;
import com.activeitzone.teamshopcms.Presentation.ui.activities.PurchaseHistoryView;
import com.activeitzone.teamshopcms.Presentation.ui.adapters.PurchaseHistoryAdapter;
import com.activeitzone.teamshopcms.Presentation.ui.listeners.PurchaseHistoryCliclListener;
import com.activeitzone.teamshopcms.R;
import com.activeitzone.teamshopcms.Threading.MainThreadImpl;
import com.activeitzone.teamshopcms.Utils.AppConfig;
import com.activeitzone.teamshopcms.Utils.RecyclerViewMargin;
import com.activeitzone.teamshopcms.Utils.UserPrefs;
import com.activeitzone.teamshopcms.domain.executor.impl.ThreadExecutor;

import java.util.List;

public class PurchaseHistoryActivity extends BaseActivity implements PurchaseHistoryView, PurchaseHistoryCliclListener {
    private AuthResponse authResponse;
    private PurchaseHistoryPresenter purchaseHistoryPresenter;
    private ProgressBar progressBar;
    private TextView purchase_history_empty_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        initializeActionBar();
        setTitle("Purchase History");

        progressBar = findViewById(R.id.item_progress_bar);
        purchase_history_empty_text = findViewById(R.id.purchase_history_empty_text);

        purchaseHistoryPresenter = new PurchaseHistoryPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);

        authResponse = new UserPrefs(getApplicationContext()).getAuthPreferenceObjectJson("auth_response");
        if(authResponse != null && authResponse.getUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            purchaseHistoryPresenter.getPurchaseHistoryItems(authResponse.getUser().getId(), authResponse.getAccessToken());
        }
    }

    @Override
    public void onPurchaseHistoryLoaded(List<PurchaseHistory> purchaseHistoryList) {
        progressBar.setVisibility(View.GONE);
        if (purchaseHistoryList.size() > 0){
            RecyclerView recyclerView = findViewById(R.id.purchase_history_list);
            GridLayoutManager horizontalLayoutManager
                    = new GridLayoutManager(getApplicationContext(), 1);
            recyclerView.setLayoutManager(horizontalLayoutManager);
            PurchaseHistoryAdapter adapter = new PurchaseHistoryAdapter(getApplicationContext(), purchaseHistoryList, this);
            RecyclerViewMargin decoration = new RecyclerViewMargin(AppConfig.convertDpToPx(this,10), 1);
            recyclerView.addItemDecoration(decoration);
            recyclerView.setAdapter(adapter);
        }
        else {
            purchase_history_empty_text.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPurchaseHistoryItemClick(PurchaseHistory purchaseHistory) {
        Intent intent = new Intent(this, PurchaseHistoryDetailsActivity.class);
        intent.putExtra("purchase_history", purchaseHistory);
        startActivity(intent);
    }
}
