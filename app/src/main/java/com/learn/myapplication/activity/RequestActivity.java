package com.learn.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.learn.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequestActivity extends Activity {
    @BindView(R.id.ok_button_http)
    Button okHttpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ok_button_http})
    public void onViewClicked(View view) {
        Toast.makeText(RequestActivity.this, "ok_button_http", Toast.LENGTH_LONG).show();
    }

}
