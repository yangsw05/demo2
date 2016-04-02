package com.example.yangshu.demo2;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String TAG = "Activity demo2";
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.i(TAG, "MainActivity onCreate");
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //1,显式调用
        //Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        //Intent intent=new Intent();
        //ComponentName componentName=new ComponentName(MainActivity.this,Main2Activity.class);
        //intent.setComponent(componentName);
        //startActivity(intent);

        //2.隐式调用
        //通过设置setAction
        //要设置Manifest 设置属性
        //Intent intent=new Intent();
        //intent.setAction("Jason_apk");
        //startActivity(intent);

        //3.打开系统自带的apk
        //3.1 打开浏览器
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri url= Uri.parse("http://www.baidu.com");
        intent.setData(url);
        startActivity(intent);
    }

}
