package com.example.online_shop.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.online_shop.Adapter.RecyclerViewAdapter;
import com.example.online_shop.Adapter.SaleAdapter;
import com.example.online_shop.R;
import com.example.online_shop.other.CategoriesActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView recyclerViewSale;
    View view;
    ImageView appCompatImageView;



    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_home,container, false);
        setHasOptionsMenu(true);
        /*toolbar = view.findViewById(R.id.toolbar);
        view.setSupportActionBar(toolbar);*/

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        init_category();

        initItemAdapter();
        initRecyclerView();

        addSaleItem();
        initSaleAdapter();

        return view;
    }
    private void init_category(){
        appCompatImageView = view.findViewById(R.id.iv_categories);
        appCompatImageView.setClickable(true);
        appCompatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoriesActivity categoriesActivity = new CategoriesActivity();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment_activity_main2, categoriesActivity);
                ft.setReorderingAllowed(true);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }
    private void initItemAdapter(){
        names.add("Телевизор");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Iphone 13");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Ноутбук");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Яндекс станция");
        prices.add("19 990");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView)view.findViewById(R.id.recycleList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(),names,prices,images));
    }

    private void addSaleItem(){


    }

    private void initSaleAdapter(){
        recyclerViewSale = (RecyclerView) view.findViewById(R.id.sale_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewSale.setLayoutManager(gridLayoutManager);
        recyclerViewSale.setAdapter(new SaleAdapter(getContext(), names, prices,images));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
