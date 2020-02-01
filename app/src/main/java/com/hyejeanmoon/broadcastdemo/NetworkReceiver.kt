package com.hyejeanmoon.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isAvailable) {
            Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Network is disconnected", Toast.LENGTH_LONG).show()
        }

    }
}