package com.example.leandroocampo.t_shop.cart.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leandroocampo.t_shop.R;

/**
 * Created by leandro.ocampo on 8/18/17.
 */

public class CartFragment extends Fragment {

    public static final String TAG = "CartFragment";

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
