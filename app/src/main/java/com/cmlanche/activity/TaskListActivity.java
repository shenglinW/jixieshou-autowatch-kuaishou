package com.cmlanche.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.cmlanche.common.Constants;
import com.cmlanche.jixieshou.R;
import com.cmlanche.model.AppInfo;

import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setTitle("Task List");
        mTextView1 = findViewById(R.id.textView1);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AppInfo info = new AppInfo();
        info.setFree(true);
        info.setPeriod(3);
        if (v.getId() == mTextView1.getId()) {
            info.setAppName("快手极速版");
            info.setName("快手极速版");
            info.setPkgName(Constants.pkg_kuaishou_fast);
        } else if (v.getId() == mTextView2.getId()) {
            info.setAppName("快看点");
            info.setName("快看点");
            info.setPkgName(Constants.pkg_kuaikandian);
        } else if (v.getId() == mTextView3.getId()) {
            info.setAppName("抖音极速版");
            info.setName("抖音极速版");
            info.setPkgName(Constants.pkg_douyin_fast);
        }
        Intent data = new Intent();
        data.putExtra("appInfo", JSON.toJSONString(info));
        setResult(RESULT_OK, data);
        finish();
    }
}
