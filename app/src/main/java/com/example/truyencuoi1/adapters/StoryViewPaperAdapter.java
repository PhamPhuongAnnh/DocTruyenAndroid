package com.example.truyencuoi1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.truyencuoi1.R;
import com.example.truyencuoi1.model.Truyen;

import java.util.List;

public class StoryViewPaperAdapter extends PagerAdapter {
    private List<Truyen> storyList;
    private Context mContext;

    public StoryViewPaperAdapter(List<Truyen> storyList, Context context) {
        this.storyList = storyList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return storyList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.story_viewpaper_item, container, false);
        TextView storyTitle = v.findViewById(R.id.story_title);
        TextView storyContent = v.findViewById(R.id.story_content);
        storyTitle.setText(storyList.get(position).getTen());
        storyContent.setText(storyList.get(position).getNoidung());
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
