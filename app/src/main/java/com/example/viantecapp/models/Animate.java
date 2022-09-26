package com.example.viantecapp.models;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Animate {
    public static void setAnimation(View animateView, int position, int lastPosition, Context mContext){
        if (position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            animateView.startAnimation(animation);
            lastPosition=position;
        }
    }
}
