package com.tsorrow.junior.custom.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.tsorrow.junior.custom.BindDelayActivity;
import com.tsorrow.junior.custom.BindImmediateActivity;

public class BindDelayService extends Service {
    private static final String TAG = "BindDelayService";
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public BindDelayService getService(){
            return BindDelayService.this;
        }
    }

    private void refresh(String text) {
        Log.d(TAG, text);
        BindDelayActivity.showText(text);
    }

    @Override
    public IBinder onBind(Intent intent) {
        refresh("onBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        refresh("onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        refresh("onUnbind");
        return true;
    }

    @Override
    public void onCreate() {
        refresh("onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        refresh("onStartCommand. flags="+flags);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        refresh("onDestroy");
        super.onDestroy();
    }
}
