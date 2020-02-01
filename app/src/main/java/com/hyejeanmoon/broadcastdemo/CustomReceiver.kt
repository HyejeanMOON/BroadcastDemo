package com.hyejeanmoon.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "custom broadcast has received", Toast.LENGTH_LONG).show()
    }
}