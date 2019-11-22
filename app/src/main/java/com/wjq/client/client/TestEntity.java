package com.wjq.client.client;

import java.util.ArrayList;

/**
 * Created by weijianqiang
 * On 2019/11/20
 * Description:
 */
public class TestEntity {

    private static final String TAG = "TestEntity";
    private static TestEntity testEntity;

    private ArrayList<TestListener.InnerListener> listeners = new ArrayList<>();

    private TestEntity(){}

    public static TestEntity getInstance(){
        if (testEntity == null){
            testEntity = new TestEntity();
        }
        return testEntity;
    }

    public void add(TestListener.InnerListener listener){
        if (listener != null && !listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    public void notifyMsg(){
        for (int i =0;i<listeners.size();i++){
            TestListener.InnerListener listener = listeners.get(i);
            if ( listener != null){
                listener.onChange("i:"+i);
            }
        }
    }
}
