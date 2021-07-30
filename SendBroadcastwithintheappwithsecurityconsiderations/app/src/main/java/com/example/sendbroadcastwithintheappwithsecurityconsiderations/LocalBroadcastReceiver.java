package com.example.sendbroadcastwithintheappwithsecurityconsiderations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent sendIntent = new Intent(context,Recieve_broadcast.class);
        String message = intent.getStringExtra("message");
        sendIntent.putExtra("message",message);

        context.startActivity(sendIntent);
    }
}