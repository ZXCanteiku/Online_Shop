package com.example.online_shop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.online_shop.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.ViewHolder>{

    private static final String TAG = "SaleAdapter";
    private ArrayList<String> SaleNames = new ArrayList<>();
    private ArrayList<String> Sales = new ArrayList<>();
    private ArrayList<String> ImageSales = new ArrayList<>();
    private Context context;

    public SaleAdapter(Context context, ArrayList<String> SaleNames, ArrayList<String> Sales, ArrayList<String> ImageSales){
        this.SaleNames = SaleNames;
        this.Sales = Sales;
        this.ImageSales = ImageSales;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sale_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_sale.setText(Sales.get(i));
        viewHolder.tv_name_sale.setText(SaleNames.get(i));
        Picasso.with(context).load(ImageSales.get(i)).into(viewHolder.iv_sale);
        viewHolder.iv_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,viewHolder.tv_name_sale.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return SaleNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_sale;
        TextView tv_name_sale;
        ImageView iv_sale;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_sale = itemView.findViewById(R.id.tv_sale);
            tv_name_sale = itemView.findViewById(R.id.tv_name_sale);
            iv_sale = itemView.findViewById(R.id.iv_sale);


        }
    }

}
