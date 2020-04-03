package com.frend.assistednavigation;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import androidx.annotation.NonNull;

public class MediaHandlerThread extends HandlerThread {

    private Handler handler;

    public MediaHandlerThread(String name) {
        super(name);
    }


    @SuppressLint("HandlerLeak")
    @Override
    protected void onLooperPrepared() {
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){




                }
            }
        };
    }

    public Handler getHandler() {
        return handler;
    }
}
