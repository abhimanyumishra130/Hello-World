package com.example.threadsyou;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class WorkerThread extends HandlerThread {

    private Handler handler ;

    public WorkerThread(String name,Handler handler) {
        super(name);
        this.handler = handler;
    }

    //to keep alive using looper prepare

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        for(int i=0; i<=10; i++){
            //progressBar.setProgress(i*10);
            if (i*10>=10){
                try {
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    msg.obj=i*10;
                    handler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
