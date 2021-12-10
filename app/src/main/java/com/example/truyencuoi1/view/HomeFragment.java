package com.example.truyencuoi1.view;
import android.os.Handler;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.truyencuoi1.Constants;
import com.example.truyencuoi1.R;
import com.example.truyencuoi1.ViewModel.Home;
import com.example.truyencuoi1.adapters.StoryAdapter;
import com.example.truyencuoi1.listeners.RecycleViewListener;
import com.example.truyencuoi1.model.HinhAnh;
import com.example.truyencuoi1.model.Truyen;

import java.util.Objects;

public class HomeFragment extends  BaseFragment<Home>{
    private RecyclerView recyclerView;
    private StoryAdapter storyAdapter;
    @Override
    protected Class<Home> getViewModelClass() {
        return Home.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initViews() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        findViewById(R.id.bt_toggle, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        LinearLayout categoryList = findViewById(R.id.list_category);
        categoryList.removeAllViews();
        mViewModel.setAssetManager(getActivity().getAssets());
        mViewModel.initCategory();
        initRecycleView();
        for (HinhAnh category : mViewModel.getCategoryList()){
            View v = initCategoryItem(category);
            v.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View v) {
                    mViewModel.initStory(category.getTen() + ".txt");
                    mViewModel.setCurrentCategory(category.getTen());
                    storyAdapter.notifyDataSetChanged();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawerLayout.closeDrawers();
                        }
                    }, 150);
                }
            });
            categoryList.addView(v);
        }

    }
    private View initCategoryItem(HinhAnh item) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.nav_item, null, false);
        ImageView categoryImg = view.findViewById(R.id.category_img);
        TextView categoryText = view.findViewById(R.id.category_text);
        categoryText.setText(item.getTen());
        String iconPath = "file:///android_asset/" + item.getIcon();
        Glide.with(this).load(Uri.parse(iconPath)).into(categoryImg);
        return view;
    }

    private void initRecycleView(){
        recyclerView = findViewById(R.id.recycle_view_story);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        storyAdapter = new StoryAdapter(mViewModel.getStories());
        storyAdapter.setRecycleViewListener(new RecycleViewListener() {
            @Override
            public void onClick(Truyen story) {
                gotoStoryDetail(mViewModel.getStories().indexOf(story));
            }
        });
        recyclerView.setAdapter(storyAdapter);
    }

    private void gotoStoryDetail(int storyIdx){
        callBack.callBack(Constants.KEY_SHOW_STORY_DETAIL, storyIdx);
    }

}
