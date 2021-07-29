package com.endrollmodel.gptablayout;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Objects;

public class GPTabLayout extends LinearLayout{
    private GPTabSelectedListener listener;
    private int dataType;
    private final static int TC_MODE = 0;
    private final static int VC_MODE = 1;

    public GPTabLayout(@NonNull Context context) {
        super(context);
        if (this.getRootView() == null) {
            ((ViewGroup) this.getRootView()).setClipChildren(false);
        }
        setClipChildren(false);
        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public GPTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (this.getRootView() == null) {
            ((ViewGroup) this.getRootView()).setClipChildren(false);
        }
        setClipChildren(false);
        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public void setListener(GPTabSelectedListener listener) {
        this.listener = listener;
    }

    public void setData(String... strings) {
        dataType = TC_MODE;
        for (int i = 0; i < strings.length; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.gpitem, null, false);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f));
            ImageView gpImage = view.findViewById(R.id.gpImage);
            TextView gpText = view.findViewById(R.id.gpText);
            gpText.setText(strings[i]);
            gpImage.setBackground(gpAnimation());
            int finalI = i;
            view.setOnClickListener(v -> {
                ((AnimationDrawable) gpImage.getBackground()).stop();
                ((AnimationDrawable) gpImage.getBackground()).start();
                if (listener != null) listener.selectedIndex(finalI);
            });
            addView(view);
        }
    }

    public void setData(ViewPager2 vp, GPItemInfo info) {
        dataType = VC_MODE;
        for (int i = 0; i < Objects.requireNonNull(vp.getAdapter()).getItemCount(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.gpitem, null, false);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f));
            ImageView gpImage = view.findViewById(R.id.gpImage);
            gpImage.setBackground(gpAnimation());
            int finalI = i;
            view.setOnClickListener(v -> vp.setCurrentItem(finalI, true));
            info.selectView(i, view.findViewById(R.id.gpText));
            addView(view);
        }
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ((AnimationDrawable) (getChildAt(position).findViewById(R.id.gpImage)).getBackground()).stop();
                ((AnimationDrawable) (getChildAt(position).findViewById(R.id.gpImage)).getBackground()).start();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    public void selectChild(int position){
        getChildAt(position).performClick();
    }

    public AnimationDrawable gpAnimation() {
        int playDuration = 35;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame0, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame1, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame2, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame3, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame4, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame5, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame6, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame7, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame8, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame9, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame10, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame11, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame12, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame13, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame14, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame15, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame16, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame17, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame18, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame19, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame20, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame21, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame22, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame23, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame24, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame25, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame26, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame27, null), playDuration);
        animationDrawable.addFrame(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ame28, null), playDuration);
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }
}
