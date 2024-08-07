package com.spacECE.spaceceedu.LibForSmall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacECE.spaceceedu.LibForSmall.books;
import com.spacECE.spaceceedu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class library_RecycleAdapter extends RecyclerView.Adapter<library_RecycleAdapter.MyViewHolder>{

    ArrayList<books> list;

    private final RecyclerViewClickListener listener;

    public library_RecycleAdapter(ArrayList<books> myList, RecyclerViewClickListener listener) {
        this.list = myList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_list_listitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_name.setText(list.get(position).getProduct_title());
        holder.book_category.setText(list.get(position).getProduct_desc());
        holder.book_price.setText(list.get(position).getProduct_price());
        Picasso.get()
                .load("http://43.205.45.96/libforsmall/product_images/"+list.get(position).product_image)
                .error(R.drawable.tile_icon_2)
                .into(holder.book_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<books> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView book_name;
        private final ImageView book_image;
        private final TextView book_category ;
        private final TextView book_price;
        public MyViewHolder(@NonNull View view) {
            super(view);
            book_name=view.findViewById(R.id.cardview_bookname);
            view.setOnClickListener(this);
            book_price=view.findViewById(R.id.cardview_price);
            view.setOnClickListener(this);
            book_category=view.findViewById(R.id.cardview_category);
            view.setOnClickListener(this);
            book_image=view.findViewById(R.id.cardview_bookimage);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
