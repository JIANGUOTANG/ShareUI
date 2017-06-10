package com.jian.share;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShareDialog shareDialog = new ShareDialog(this) {
            @Override
            void onShareItemClick(int position) {
                //点击的位置
                Log.i("onClick", position + "");
            }
        };
        shareDialog.showDialog();//显示dialog
    }
}
