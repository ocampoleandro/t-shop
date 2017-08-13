package com.example.leandroocampo.t_shop.shop.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.common.manager.ImageDownloadManager;
import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.List;

public class ShirtListAdapter extends RecyclerView.Adapter<ShirtListAdapter.ShirtViewHolder> {

    private Context context;

    private List<Shirt> shirts;
    private int imageSize;
    private InteractionListener listener;

    public ShirtListAdapter(List<Shirt> shirts, Context context, InteractionListener listener) {
        this.shirts = shirts;
        this.context = context;
        imageSize = context.getResources().getDimensionPixelSize(R.dimen.list_shirt_product_image_height);
        this.listener = listener;
    }

    @Override
    public ShirtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_shirt_item, parent, false);
        return new ShirtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShirtViewHolder holder, int position) {
        final Shirt shirt = shirts.get(position);
        holder.tvProductName.setText(shirt.getName());
        holder.tvProductPrice.setText(context.getString(R.string.list_shirt_product_price, shirt.getPrice()));
        //TODO: calculate width for the image depending on space available and screen size
        ImageDownloadManager.downloadImageIntoImageView(context, holder.ivPicture, shirt.getPicture(), imageSize, imageSize);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(shirt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (shirts != null) ? shirts.size() : 0;
    }

    public class ShirtViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPicture;
        public TextView tvProductName;
        public TextView tvProductPrice;

        ShirtViewHolder(View itemView) {
            super(itemView);
            ivPicture = (ImageView) itemView.findViewById(R.id.iv_picture);
            tvProductName = (TextView) itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = (TextView) itemView.findViewById(R.id.tv_product_price);
        }
    }

    public interface InteractionListener {
        void onItemClicked(Shirt shirt);
    }
}
