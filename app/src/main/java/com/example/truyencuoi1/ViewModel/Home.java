package com.example.truyencuoi1.ViewModel;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import com.example.truyencuoi1.model.HinhAnh;
import com.example.truyencuoi1.model.Truyen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends BaseViewModel{
    private List<HinhAnh> categoryList = new ArrayList<>();
    private List<Truyen> stories = new ArrayList<>();
    private AssetManager assetManager;
    private MutableLiveData<String> currentCategory = new MutableLiveData<>();
    private MutableLiveData<List<Truyen>> storyListLiveData = new MutableLiveData<>();


    public void initCategory(){
        categoryList.clear();
        try {
            String[] files = assetManager.list("data");
            for (String file : files){
                String name = file.replace(".txt", "");
                String imageName = "icon/" + name + ".png";
                categoryList.add(new HinhAnh(name, imageName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void initStory(String filePath) {
        stories.clear();
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(assetManager.open("data/" + filePath)));
            String mLine;
            while ((mLine = reader.readLine()) != null){
                text.append(mLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String[] storyText = text.toString().split("','0'\\);\n");
        for (String t : storyText){
            String[] splitText = t.split("\n");
            stories.add((new Truyen(splitText[0].trim(),
                    String.join("\n", Arrays.copyOfRange(splitText, 1, splitText.length)))));
            storyListLiveData.postValue(stories);
        }
    }

    public List<HinhAnh> getCategoryList() {
        return categoryList;
    }

    public List<Truyen> getStories() {
        return stories;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void setCurrentCategory(String current) {
        currentCategory.postValue(current);
    }

    public MutableLiveData<String> getCurrentCategory() {
        return currentCategory;
    }

    public MutableLiveData<List<Truyen>> getStoryListLiveData() {
        return storyListLiveData;
    }
}
