package com.example.online_shop.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.online_shop.Adapter.ProductAdapter;
import com.example.online_shop.R;
import com.example.online_shop.item.Product;


import java.util.ArrayList;
import java.util.Collections;

public class CategoriesForProduct extends Fragment {
    private View view;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Product> products = new ArrayList<>();
    private CheckBox checkBoxFilterPrice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.categories_for_product_fragment, container, false);
        setHasOptionsMenu(true);

        checkBoxFilterPrice = view.findViewById(R.id.filter_image_price);
        onClickCheckBox(checkBoxFilterPrice);

        toolbar = view.findViewById(R.id.categories_for_product_toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.baseline_keyboard_backspace_black_24); //помещаешь иконку
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),  "back", Toast.LENGTH_SHORT).show();
//                onBackPressed();
            }
        });
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initItemProduct();
        initProductAdapter();


        return view;
    }

    private void onClickCheckBox(CheckBox checkBox){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Product.key = true;
                    Toast.makeText(getContext(), "true", Toast.LENGTH_SHORT).show();
                    Collections.sort(products);
                    ProductAdapter productAdapter = new ProductAdapter(getContext(), products);
                    recyclerView.setAdapter(productAdapter);


                }
                else {
                    Product.key = false;
                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                    Collections.sort(products);
                    ProductAdapter productAdapter = new ProductAdapter(getContext(), products);
                    recyclerView.setAdapter(productAdapter);
                }
            }
        });

    }


    private void initProductAdapter(){
        recyclerView = view.findViewById(R.id.categories_for_product_list);

        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ProductAdapter productAdapter = new ProductAdapter(getContext(), products);
        recyclerView.setAdapter(productAdapter);
    }

    private void initItemProduct(){

        products.add(new Product(1,"Телефон", 28000,"image.png"));
        products.add(new Product(2,"Macbook pro 14", 280000,"image.png"));
        products.add(new Product(3,"Macbook pro 13", 143432,"image.png"));
        products.add(new Product(4,"Lenovo IdeaPad L3", 300000,"image.png"));
        products.add(new Product(5,"Acer Aspire A3", 250000,"image.png"));
        products.add(new Product(6,"Iphone 13 pro", 111111,"image.png"));
        products.add(new Product(7,"Iphone 12 pro", 22222,"image.png"));
        products.add(new Product(8,"Iphone 12", 33333,"image.png"));


    }

}
