package com.example.viantecapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viantecapp.R;
import com.example.viantecapp.models.Animate;
import com.example.viantecapp.models.Header;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.ViewHolder>{
    private List<Header> headers;
    private Context mContext;
    private LayoutInflater inflater;
    private int lastPosition = -1;
    public HeaderAdapter(List<Header> headers, Context mContext) {
        this.headers = headers;
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.header_item,parent,false);
        return new HeaderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Header current = headers.get(position);
        holder.txtTitle.setText(current.getHeaderName());
        Animate.setAnimation(holder.itemView,position,lastPosition,mContext);
    }

    @Override
    public int getItemCount() {
        return headers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.text_view_title);
        }
    }

}
