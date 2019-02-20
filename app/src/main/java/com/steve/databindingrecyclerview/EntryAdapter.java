package com.steve.databindingrecyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.steve.databindingrecyclerview.databinding.RowItemBinding;

import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.MyViewHolder> {

    private List<Entry> entries;
    private LayoutInflater inflater;

    public EntryAdapter (Context context, List<Entry> list) {
        this.entries = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null ) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }
        RowItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_item, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.setEntry(entries.get(i));
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final RowItemBinding binding;

        public MyViewHolder(final RowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

}
