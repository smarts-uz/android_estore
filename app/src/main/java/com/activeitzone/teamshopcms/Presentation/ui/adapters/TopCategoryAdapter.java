package com.activeitzone.teamshopcms.Presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.activeitzone.teamshopcms.Models.Category;
import com.activeitzone.teamshopcms.Presentation.ui.listeners.CategoryClickListener;
import com.activeitzone.teamshopcms.R;
import com.activeitzone.teamshopcms.Utils.AppConfig;
import com.bumptech.glide.Glide;

import java.util.List;

public class TopCategoryAdapter extends RecyclerView.Adapter<TopCategoryAdapter.ViewHolder> {

    private Context context;
    private List<Category> mCategories;
    private LayoutInflater mInflater;
    private CategoryClickListener mClickListener;

    // data is passed into the constructor
    public TopCategoryAdapter(Context context, List<Category> categories, CategoryClickListener listener) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mCategories = categories;
        this.mClickListener = listener;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.top_category_list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mCategories.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.category_icon);
            textView = itemView.findViewById(R.id.category_name);
        }

        public void bind(final Category category) {
            Glide.with(context).load(AppConfig.ASSET_URL + category.getBanner()).into(imageView);

            textView.setText(category.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null) mClickListener.onCategoryItemClick(category);
                }
            });
        }
    }
}
