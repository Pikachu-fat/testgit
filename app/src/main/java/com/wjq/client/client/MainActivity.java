package com.wjq.client.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button bindKDXF;
    TestBinder testBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button startServiceBtn = (Button) findViewById(R.id.startService);


        //添加test log
        testBinder = new TestBinder();
        final Intent intent = new Intent("com.wjq.service");
        startService(intent);

        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i =0;i<3;i++){
                    // test git --amend
                    Intent intent = new Intent("com.wjq.service");
                    startService(intent);
                }

            }
        });

        bindKDXF = (Button) findViewById(R.id.bindkdxf);
        bindKDXF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // v1.0
                for (int i =0;i<3;i++){
                    Intent intent = new Intent("com.cmcc.tvclient.kdxfbindService");
                    startService(intent);
                }

            }
        });

        findViewById(R.id.notifycode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.cmcc.tvclient.voicerecognition.call");
                startService(intent);
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: add");
                testBinder.addListener();
                Log.d(TAG, "testBinder: "+testBinder);
            }
        });

        findViewById(R.id.set_null).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: set null");
                testBinder = null;
                Log.d(TAG, "testBinder: "+testBinder);
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: show");
                TestEntity.getInstance().notifyMsg();
            }
        });
    }
}
