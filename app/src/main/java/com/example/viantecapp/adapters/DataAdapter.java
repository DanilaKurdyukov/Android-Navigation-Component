package com.example.viantecapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viantecapp.R;
import com.example.viantecapp.models.Animate;
import com.example.viantecapp.models.ModelData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private List<ModelData> data;
    private Context mContext;
    private LayoutInflater inflater;
    private int lastPosition = -1;
    public DataAdapter(List<ModelData> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.data_item,parent,false);
        return new DataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelData current = data.get(position);
        holder.txtTime.setText(current.getTime().toString());
        holder.txtWhereFound.setText(current.getWhereFound());
        holder.txtType.setText(current.getType());
        holder.txtAdditionalInformation.setText(current.getAdditionalInformation());
        Animate.setAnimation(holder.itemView,position,lastPosition,mContext);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        MaterialButton btnReceived;
        MaterialTextView txtTime, txtWhereFound, txtType, txtAdditionalInformation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnReceived = itemView.findViewById(R.id.button_received);
            txtTime = itemView.findViewById(R.id.text_view_time);
            txtWhereFound = itemView.findViewById(R.id.text_view_whereFound);
            txtType = itemView.findViewById(R.id.text_view_type);
            txtAdditionalInformation = itemView.findViewById(R.id.text_view_additionalInformation);
        }
    }
}
