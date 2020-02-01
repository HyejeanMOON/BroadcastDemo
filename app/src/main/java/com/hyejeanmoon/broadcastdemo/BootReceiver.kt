package com.hyejeanmoon.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "OS Boot Completed!", Toast.LENGTH_LONG).show()
    }
}