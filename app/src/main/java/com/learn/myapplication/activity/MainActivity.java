package com.learn.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.myapplication.R;
import com.learn.myapplication.adapter.MainAdapter;
import com.learn.myapplication.bean.MainData;
import com.learn.myapplication.utils.ConvertUtils;
import com.learn.myapplication.utils.MyDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


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
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        MyDecoration myDecoration = new MyDecoration();
        myDecoration.setColor(Color.GRAY).setMargin(ConvertUtils.dp2px(this, 15)).setDividerHeight(ConvertUtils.dp2px(this, 1));
        recyclerView.addItemDecoration(myDecoration);

        //adapter
        MainAdapter adapter = new MainAdapter(data);
        adapter.setOnItemClickLitener(new MainAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "这是" + data.get(position).getName(), Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,RequestActivity.class));
                        break;
                }


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
