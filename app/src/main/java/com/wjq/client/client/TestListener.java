package com.wjq.client.client;

/**
 * Created by weijianqiang
 * On 2019/11/20
 * Description:
 */
public class TestListener {

    private static final String TAG = "TestListener";

    // test two
    interface InnerListener{
        public void onChange(String result);
    }
}
