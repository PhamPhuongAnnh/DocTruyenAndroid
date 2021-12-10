package com.example.truyencuoi1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.truyencuoi1.R;
import com.example.truyencuoi1.listeners.RecycleViewListener;
import com.example.truyencuoi1.model.Truyen;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private List<Truyen> stories;
    private RecycleViewListener recycleViewListener;

    public StoryAdapter(RecycleViewListener recycleViewListener) {
        this.recycleViewListener = recycleViewListener;
    }
    public void setRecycleViewListener(RecycleViewListener recycleViewListener) {
        this.recycleViewListener = recycleViewListener;
    }
    public StoryAdapter(List<Truyen> stories) {
        this.stories = stories;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Truyen truyen = stories.get(position);
        holder.storyName.setText(truyen.getTen());
        holder.currentStory = truyen;
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView storyName;
        public LinearLayout storyItemContainer;
        public Truyen currentStory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storyName = itemView.findViewById(R.id.story_name);
            storyItemContainer = itemView.findViewById(R.id.story_item_container);
            storyItemContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recycleViewListener != null){
                        recycleViewListener.onClick(currentStory);
                    }
                }
            });
        }
    }
}
