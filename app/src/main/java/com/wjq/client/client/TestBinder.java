package com.wjq.client.client;

import android.util.Log;

/**
 * Created by weijianqiang
 * On 2019/11/20
 * Description:
 */
public class TestBinder {

    private static final String TAG = "TestBinder";

    TestListener.InnerListener listener = new TestListener.InnerListener() {
        @Override
        public void onChange(String result) {
            Log.d(TAG, "onChange: "+result);
            Log.d(TAG, "onChange: this:"+this);
        }
    };

    public void addListener(){
        TestEntity.getInstance().add(listener);
    }
}
