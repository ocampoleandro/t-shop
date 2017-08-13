package com.example.leandroocampo.t_shop.shop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopApplication;
import com.example.leandroocampo.t_shop.common.manager.ImageDownloadManager;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.ui.TitleChangeable;
import com.example.leandroocampo.t_shop.common.ui.ToolbarChangeable;
import com.example.leandroocampo.t_shop.common.ui.fragment.BaseFragment;
import com.example.leandroocampo.t_shop.shop.presenter.DetailShirtPresenter;
import com.example.leandroocampo.t_shop.shop.presenter.factory.DetailShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.view.DetailShirtView;

import org.parceler.Parcels;

import javax.inject.Inject;

/**
 * Fragment that shows the detail of a {@link com.example.leandroocampo.t_shop.common.model.Shirt}.
 * It lets add the product to the cart.
 */

public class DetailShirtFragment extends BaseFragment<DetailShirtPresenter, DetailShirtView>
        implements DetailShirtView {

    public static final String SHIRT_PARAM = DetailShirtPresenter.SHIRT_PARAM;

    @Inject
    DetailShirtPresenterFactory presenterFactory;

    //default constructors needed by the SO
    public DetailShirtFragment() {

    }

    public static DetailShirtFragment newInstance(Shirt shirt) {
        DetailShirtFragment fragment = new DetailShirtFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SHIRT_PARAM, Parcels.wrap(shirt));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_shirt, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);

        Shirt shirt = presenter.onShirtNeeded();
        TextView tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
        TextView tvProductPrice = (TextView) view.findViewById(R.id.tv_product_price);
        TextView tvColour = (TextView) view.findViewById(R.id.tv_colour);
        TextView tvSize = (TextView) view.findViewById(R.id.tv_size);
        ImageView ivProductPicture = (ImageView) view.findViewById(R.id.iv_picture);
        tvProductName.setText(shirt.getName());
        tvProductPrice.setText(getContext().getString(R.string.detail_shirt_product_price, shirt.getPrice()));
        tvColour.setText(shirt.getColour());
        tvSize.setText(shirt.getSize());
        int imageSize = getContext().getResources().getDimensionPixelSize(R.dimen.detail_shirt_header_image_height);
        ImageDownloadManager.downloadImageIntoImageView(getContext(), ivProductPicture, shirt.getPicture(),
                imageSize, imageSize);
    }

    private void setToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((ToolbarChangeable) getActivity()).setToolbar(toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int scrollRange = -1;
            boolean isShow = false;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset < 120) {
                    ((TitleChangeable) getActivity()).setTitleToolbar(getContext().getString(R.string.detail_shirt_title_screen));
                    isShow = true;
                } else if (isShow) {
                    ((TitleChangeable) getActivity()).setTitleToolbar("");
                    isShow = false;
                }
            }
        });
        ((TitleChangeable) getActivity()).setTitleToolbar("");
    }

    @NonNull
    @Override
    protected DetailShirtView getMVPView() {
        return this;
    }

    @NonNull
    @Override
    protected PresenterFactory<DetailShirtPresenter> getPresenterFactory() {
        return presenterFactory;
    }

    @Override
    protected void initInject() {
        TShopApplication.getInstance().getInjector().getPresenterFactoryComponent().inject(this);
    }
}
