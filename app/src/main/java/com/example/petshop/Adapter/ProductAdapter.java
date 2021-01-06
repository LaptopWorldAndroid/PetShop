package com.example.petshop.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petshop.Class.ListProduct;
import com.example.petshop.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Activity context;
    int item_layout;
    List<ListProduct> listProducts;

    public ProductAdapter(Activity context, int item_layout, List<ListProduct> listProducts) {
        this.context = context;
        this.item_layout = item_layout;
        this.listProducts = listProducts;
    }

    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return listProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            // Link item layout and binding data
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout, null);

            holder.imvPhoto = convertView.findViewById(R.id.imgProductitem);
            holder.txtName = convertView.findViewById(R.id.Productitemname);
            holder.txtPrice = convertView.findViewById(R.id.PriProductitem);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListProduct Product = listProducts.get(position);
        holder.imvPhoto.setImageResource(Product.getImg ());
        holder.txtName.setText(Product.getName());
        holder.txtPrice.setText(String.valueOf(Product.getPrice()) + " VND");

        return convertView;
    }

    public static class ViewHolder{
        ImageView imvPhoto;
        TextView txtName, txtPrice;
    }

    public static class ItemClickListener {
    }
}

