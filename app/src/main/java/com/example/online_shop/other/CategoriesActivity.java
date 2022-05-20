package com.example.online_shop.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.online_shop.Adapter.CategoriesAdapter;
import com.example.online_shop.R;
import com.example.online_shop.item.ItemCategories;


import java.util.ArrayList;

public class CategoriesActivity extends Fragment {
    private View view;
    private Toolbar toolbar;

    private ArrayList<ItemCategories> categories = new ArrayList<>();
    private CategoriesAdapter.RecyclerViewClickListener listener;

    private RecyclerView recyclerViewCategories;
//    private BackClick backClick;
//    private CategoriesAdapter.RecyclerViewClickListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.categories_layout, container, false);
        setHasOptionsMenu(true);

        toolbar = view.findViewById(R.id.categories_toolbar);
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

        initItemAdapterForCategories();
        intiAdapterCategories();

        return view;
    }

    private void initItemAdapterForCategories(){
        categories.add(new ItemCategories(1,"Все"));
        categories.add(new ItemCategories(2,"Компьютеры"));
        categories.add(new ItemCategories(3,"Аксессуары"));
        categories.add(new ItemCategories(4,"Смартфоны"));
        categories.add(new ItemCategories(5,"Умные вещи"));
        categories.add(new ItemCategories(6,"Наушники"));
        categories.add(new ItemCategories(7,"Наушники"));
        categories.add(new ItemCategories(8,"Наушники"));
        categories.add(new ItemCategories(9,"Наушники"));
        categories.add(new ItemCategories(10,"Компьютеры"));
        categories.add(new ItemCategories(11,"Аксессуары"));
        categories.add(new ItemCategories(12,"Смартфоны"));
        categories.add(new ItemCategories(13,"Компьютеры"));



    }

    private void intiAdapterCategories(){
        setOnClickListner();
        recyclerViewCategories = (RecyclerView) view.findViewById(R.id.categories_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerViewCategories.setLayoutManager(layoutManager);
        recyclerViewCategories.setAdapter(new CategoriesAdapter(getContext(), categories, listener));
    }

    private void setOnClickListner() {
        listener = new CategoriesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), position +"", Toast.LENGTH_SHORT).show();
                com.example.online_shop.other.CategoriesForProduct categories = new com.example.online_shop.other.CategoriesForProduct();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment_activity_main2, categories);

                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }


//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//
//        inflater.inflate(R.menu.menu_back, menu);
//
//        super.onCreateOptionsMenu(menu,inflater);
//
//    }

//    private class BackClick implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(getContext(),  "back", Toast.LENGTH_SHORT).show();
//            HomeActivity homeActivity = new HomeActivity();
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment_activity_main2, homeActivity);
//
//            ft.addToBackStack(null);
//            ft.commit();
//        }
//    }
}
