package com.example.threadsiw;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread{

    private Handler handler ;


//to keep alive using looper prepare
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler(Looper.myLooper());

        Looper.loop();
    }

    public void addTaskToMessageQueue(Runnable task){
        if(handler!=null){
            handler.post(task);
        }
    }
}
