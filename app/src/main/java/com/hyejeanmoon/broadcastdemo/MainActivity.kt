package com.hyejeanmoon.broadcastdemo

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.hyejeanmoon.broadcastdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var intentFilter: IntentFilter
    private lateinit var networkReceiver: NetworkReceiver
    private lateinit var binding: ActivityMainBinding
    private lateinit var customReceiver: CustomReceiver
    private lateinit var customIntentFilter: IntentFilter
    private lateinit var localBroadcastManager: LocalBroadcastManager
    private lateinit var localIntentFilter: IntentFilter
    private lateinit var localBroadCastReceiver: LocalBroadCastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        networkReceiver = NetworkReceiver()
        intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")

        registerReceiver(networkReceiver, intentFilter)

        customReceiver = CustomReceiver()
        customIntentFilter = IntentFilter()
        customIntentFilter.addAction("com.hyejeanmoon.broadcastdemo.mooon")
        registerReceiver(customReceiver, customIntentFilter)

        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        localIntentFilter = IntentFilter()
        localIntentFilter.addAction("com.hyejeanmoon.broadcastdemo.mooon.local")
        localBroadCastReceiver = LocalBroadCastReceiver()
        localBroadcastManager.registerReceiver(localBroadCastReceiver, localIntentFilter)

        binding.btnSendBroadCast.setOnClickListener {
            sendBroadCast()
        }

        binding.btnSendLocalBroadCast.setOnClickListener {
            sendLocalBroadCast()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkReceiver)
        unregisterReceiver(customReceiver)
        localBroadcastManager.unregisterReceiver(localBroadCastReceiver)
    }

    private fun sendBroadCast() {
        val intent = Intent("com.hyejeanmoon.broadcastdemo.mooon")
        sendBroadcast(intent)
    }

    private fun sendLocalBroadCast() {
        val intent = Intent("com.hyejeanmoon.broadcastdemo.mooon.local")
        localBroadcastManager.sendBroadcast(intent)

    }
}
