package com.example.searchview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchview.Adapter.Model.modelclass;
import com.example.searchview.R;
import com.example.searchview.Result_Activity.result_activity;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Vholder> implements Filterable {

    List<modelclass> list = new ArrayList<>();
    List<modelclass> list1 = new ArrayList<>();
    List<modelclass> filteredLists = new ArrayList<>();
    Context c;

    public ItemsAdapter(Context ctx, List<modelclass> list) {
        this.c = ctx;
        this.list = list;
        this.list1 = list;
        this.filteredLists = list1;

    }

    @NonNull
    @Override
    public Vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        Vholder vh = new Vholder(view);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull Vholder holder, final int position) {
        modelclass mclass = list.get(position);
        holder.tview.setText(mclass.getName());

        holder.tview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Toast.makeText(c, list.get(position).getName(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(c, result_activity.class);
                i.putExtra("modelclass",list.get(position));
                c.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Vholder extends RecyclerView.ViewHolder {
        TextView tview;

        public Vholder(@NonNull View itemView) {
            super(itemView);

            tview = itemView.findViewById(R.id.tview);

        }
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();

                if (charString.isEmpty()) {
                    list = list1;
                } else {

                    List<modelclass> filterList = new ArrayList<>();

                    for (modelclass data : list1) {

                        if (data.getName().toLowerCase().contains(charString)) {
                            filterList.add(data);
                        }
                    }

                    list = filterList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = list;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                list = (List<modelclass>) results.values;
                notifyDataSetChanged();
            }
        };

    }
}

