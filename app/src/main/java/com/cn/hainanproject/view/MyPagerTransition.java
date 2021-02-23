package com.cn.hainanproject.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by tzl
 * on 2021/2/2
 */
public class MyPagerTransition implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        float MIN_SCALE = 0.75f;
        float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
        if (position > 1 || position < -1) {
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1 + position);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position <= 1) {
            page.setAlpha(1 - position);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        }
    }
}
