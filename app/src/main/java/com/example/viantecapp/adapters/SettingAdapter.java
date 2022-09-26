package com.example.viantecapp.adapters;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viantecapp.R;
import com.example.viantecapp.models.Animate;
import com.example.viantecapp.models.Setting;
import com.google.android.material.checkbox.MaterialCheckBox;
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
        holder.txtEventName.setText(current.getEventName());
        holder.txtNowNewAll.setText(current.getNowNew() + " / " + current.getNowAll());
        holder.txtPerDayNewAll.setText(current.getPerDayNew() + " / " + current.getPerDayAll());
        holder.txtPerWeekNewAll.setText(current.getPerWeekNew() + " / " + current.getPerWeekAll());
        Animate.setAnimation(holder.itemView,position,lastPosition,mContext);
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView txtEventName, txtNowNewAll, txtPerDayNewAll, txtPerWeekNewAll;
        MaterialCheckBox isTurnOn,isNotified, isHear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEventName = itemView.findViewById(R.id.text_view_event_name);
            txtNowNewAll = itemView.findViewById(R.id.text_view_now_new_all);
            txtPerDayNewAll = itemView.findViewById(R.id.text_view_per_day_new_all);
            txtPerWeekNewAll = itemView.findViewById(R.id.text_view_per_week_new_all);
            isTurnOn = itemView.findViewById(R.id.check_box_turn_on);
            isNotified = itemView.findViewById(R.id.check_box_notified);
            isHear = itemView.findViewById(R.id.check_box_hear);
        }
    }

}
