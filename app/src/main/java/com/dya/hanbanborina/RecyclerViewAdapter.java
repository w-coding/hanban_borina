package com.dya.hanbanborina;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {

    List<Item> aText1;
    List<Item> searchText1;
    Context context;
    public RecyclerViewAdapter(Context ct , List<Item>iaText1){
        context = ct;
        aText1 = iaText1;

       this.searchText1 = new ArrayList<>(iaText1);


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.recycler_view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Item itemData =aText1.get(position);
        holder.Text1.setText(itemData.getText1());
        holder.Text2.setText(itemData.getText2());



        holder.cardViewCopy.setOnClickListener(view -> {

            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(
                    Context.CLIPBOARD_SERVICE
            );
            ClipData clipData = ClipData.newPlainText("text", itemData.getText1() +"\n"+itemData.getText2()+"\n"+"\n"+"#ئەپڵیکەیشنی_هەنبانەبۆرینە"+"\n");
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context, "کۆپی کرا", Toast.LENGTH_SHORT).show();

        });




    }


    @Override
    public int getItemCount() {
        return aText1.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }


    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List <Item> filterList = new ArrayList<>();

            if (charSequence.toString().isEmpty()){
                filterList.addAll(searchText1);
            }else {

                for (Item text : searchText1 ){
                    if (text.getText1().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filterList.add(text);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            aText1.clear();
            aText1.addAll((List)filterResults.values);
            notifyDataSetChanged();


        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Text1;
        TextView Text2;
       CardView cardViewCopy;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Text1= itemView.findViewById(R.id.text1);
            Text2= itemView.findViewById(R.id.text2);
            cardViewCopy= itemView.findViewById(R.id.cardViewPlay);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }
    }
}
