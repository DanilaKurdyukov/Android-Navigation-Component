package com.example.viantecapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viantecapp.R;
import com.example.viantecapp.models.Event;
import com.example.viantecapp.models.Setting;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder>{

    private List<Setting> settings;
    private Context mContext;
    private LayoutInflater inflater;
    private int lastPosition=-1;

    public SettingAdapter(List<Setting> settings, Context mContext) {
        this.settings = settings;
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.settings_item,parent,false);
        return new SettingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Setting current = settings.get(position);
        holder.isSoundOn.setChecked(current.isSoundOn());
        holder.isTurnOn.setChecked(current.isTurnOn());
        holder.isNotify.setChecked(current.isNotify());
        holder.txtName.setText(current.getName());
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        SwitchMaterial isTurnOn, isSoundOn, isNotify;
        MaterialTextView txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            isTurnOn = itemView.findViewById(R.id.switch_isTurnOn);
            isSoundOn = itemView.findViewById(R.id.switch_isSoundOn);
            isNotify = itemView.findViewById(R.id.switch_isNotify);
            txtName = itemView.findViewById(R.id.text_view_settingName);
        }
    }

}
