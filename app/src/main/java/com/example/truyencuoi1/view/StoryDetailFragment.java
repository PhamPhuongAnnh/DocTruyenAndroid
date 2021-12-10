package com.example.truyencuoi1.view;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.truyencuoi1.R;
import com.example.truyencuoi1.adapters.StoryViewPaperAdapter;
import com.example.truyencuoi1.ViewModel.Home;

public class StoryDetailFragment extends BaseFragment<Home> {
    private int storyIndex;
    private String pageNum;


    @Override
    protected Class<Home> getViewModelClass() {
        return Home.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.story_detail_fragment;
    }

    @Override
    protected void initViews() {
        ViewPager viewPager = findViewById(R.id.view_paper);
        viewPager.setAdapter(new StoryViewPaperAdapter(mViewModel.getStoryListLiveData().getValue(), getActivity()));
        viewPager.setCurrentItem(storyIndex);
        TextView cateName = findViewById(R.id.cate_name);
        TextView storyNumber = findViewById(R.id.story_number);
        cateName.setText(mViewModel.getCurrentCategory().getValue());
        pageNum = Integer.toString(storyIndex + 1) + "/" + Integer.toString(mViewModel.getStoryListLiveData().getValue().size());
        storyNumber.setText(pageNum);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageNum = Integer.toString(position + 1) + "/" + Integer.toString(mViewModel.getStoryListLiveData().getValue().size() + 1);
                storyNumber.setText(pageNum);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setStoryIndex(int storyIndex) {
        this.storyIndex = storyIndex;
    }
}