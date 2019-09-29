package com.tsorrow.test.network.service;

import android.app.IntentService;
import android.content.Intent;

public class AsyncService extends IntentService {
    private static final String TAG = "AsyncService";
    public AsyncService(String name) {
        super("com.tsorrow.test.network.service.AsyncService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(30*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
