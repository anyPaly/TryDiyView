package com.example.light.trydiyview;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by Light on 2017/6/21.
 */

public class MyAnimation {
    // 入动画
    public static void StartAnimationIN(ViewGroup viewGroup, int duration){
        for (int i = 0; i < viewGroup.getChildCount(); i++){
            viewGroup.getChildAt(i).setVisibility(View.VISIBLE);
            viewGroup.getChildAt(i).setClickable(true); // 可以点击
            viewGroup.getChildAt(i).setFocusable(true); // 可以获取焦点
        }

        Animation animation;
        /**
         * formDegrees 初始角度
         * toDeDegrees 结束角度
         * pivotXType x轴的参照物
         * pivotXValue 参照x轴的参照物的那个位置进行旋转
         * pivotYType y轴的参照物
         * pivotYValue 参照y轴的参照物的那个位置进行旋转
         */
        animation = new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setFillAfter(true);   // 停留在动画运行结束的位置
        animation.setDuration(duration);    // 动画运行时间
        
        viewGroup.startAnimation(animation);
    }

    // 出动画
    public static void StartAnimationOUT(final ViewGroup viewGroup, int duration, int startOffSet){
        Animation animation;
        animation = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setFillAfter(true);   // 停留在动画运行结束的位置
        animation.setDuration(duration);    // 动画运行时间
        animation.setStartOffset(startOffSet);  // 动画延迟启动时间
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                for (int i = 0; i < viewGroup.getChildCount(); i++){
                    viewGroup.getChildAt(i).setVisibility(View.GONE);
                    viewGroup.getChildAt(i).setClickable(false); // 不可以点击
                    viewGroup.getChildAt(i).setFocusable(false); // 不可以获取焦点
                }
                viewGroup.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        
        viewGroup.startAnimation(animation);
    }
}
