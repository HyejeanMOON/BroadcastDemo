package com.hyejeanmoon.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LocalBroadCastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "local broadcast has received!", Toast.LENGTH_LONG).show()
    }
}