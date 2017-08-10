package com.example.leandroocampo.t_shop.shop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopApplication;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.ui.TitleChangeable;
import com.example.leandroocampo.t_shop.common.ui.ToolbarChangeable;
import com.example.leandroocampo.t_shop.common.ui.fragment.BaseFragment;
import com.example.leandroocampo.t_shop.shop.presenter.ListShirtPresenter;
import com.example.leandroocampo.t_shop.shop.presenter.factory.ListShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.ui.adapter.ShirtListAdapter;
import com.example.leandroocampo.t_shop.shop.view.ListShirtView;

import java.util.List;

import javax.inject.Inject;

/**
 * Fragment that shows a list of shirts. Each item of the list takes you to a detail screen.
 */

public class ListShirtFragment extends BaseFragment<ListShirtPresenter,ListShirtView> implements ListShirtView {

    @Inject
    ListShirtPresenterFactory presenterFactory;

    private View progressBar;
    private RecyclerView rvShirts;

    //default constructors needed by the SO
    public ListShirtFragment() {

    }

    /**
     * Default method to create instances of {@link ListShirtFragment}
     * @return an instance of {@link ListShirtFragment}
     */
    public static ListShirtFragment newInstance() {
        return new ListShirtFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_shirt, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);

        rvShirts = (RecyclerView) view.findViewById(R.id.rv_shirts);
        rvShirts.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvShirts.setLayoutManager(gridLayoutManager);

        progressBar = view.findViewById(R.id.progress);
    }

    private void setToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((ToolbarChangeable) getActivity()).setToolbar(toolbar);
        ((TitleChangeable) getActivity()).setTitleToolbar(getContext().getString(R.string.app_name));
    }

    @Override
    public void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        rvShirts.setVisibility(View.INVISIBLE);
        presenter.onShirtsRequested();
    }


    @NonNull
    @Override
    protected ListShirtView getMVPView() {
        return this;
    }

    @NonNull
    @Override
    protected PresenterFactory<ListShirtPresenter> getPresenterFactory() {
        return presenterFactory;
    }

    @Override
    protected void initInject() {
        TShopApplication.getInstance().getInjector().getPresenterFactoryComponent().inject(this);
    }

    @Override
    public void showShirts(List<Shirt> shirts) {
        rvShirts.setAdapter(new ShirtListAdapter(shirts,getContext()));
        progressBar.setVisibility(View.INVISIBLE);
        rvShirts.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorFetchingList() {
        Toast.makeText(getContext(),getContext().getString(R.string.list_shirt_error_fetching_shirts)
                ,Toast.LENGTH_SHORT).show();
    }
}
