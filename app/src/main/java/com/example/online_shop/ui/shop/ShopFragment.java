package com.example.online_shop.ui.shop;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.online_shop.R;

public class ShopFragment extends Fragment {
    View view;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_shop, container, false);
       return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
