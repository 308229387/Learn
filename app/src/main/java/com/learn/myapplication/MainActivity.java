package com.learn.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import bean.MainData;


//https://blog.csdn.net/myfittinglife/article/details/88633980   学习分割线
public class MainActivity extends AppCompatActivity {
    private List<MainData> data = new ArrayList<MainData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //样式
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //间隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //adapter
        MainAdapter adapter = new MainAdapter(data);
        adapter.setOnItemClickLitener(new MainAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"这是"+data.get(position).getName(),Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            MainData apple = new MainData("Apple", R.mipmap.apple_pic);
            data.add(apple);
            MainData banana = new MainData("Banana", R.mipmap.banana_pic);
            data.add(banana);
            MainData orange = new MainData("Orange", R.mipmap.orange_pic);
            data.add(orange);
            MainData watermelon = new MainData("Watermelon", R.mipmap.watermelon_pic);
            data.add(watermelon);
            MainData pear = new MainData("Pear", R.mipmap.pear_pic);
            data.add(pear);
            MainData grape = new MainData("Grape", R.mipmap.grape_pic);
            data.add(grape);
            MainData pineapple = new MainData("Pineapple", R.mipmap.pineapple_pic);
            data.add(pineapple);
            MainData strawberry = new MainData("Strawberry", R.mipmap.strawberry_pic);
            data.add(strawberry);
            MainData cherry = new MainData("Cherry", R.mipmap.cherry_pic);
            data.add(cherry);
            MainData mango = new MainData("Mango", R.mipmap.mango_pic);
            data.add(mango);
        }
    }

}
