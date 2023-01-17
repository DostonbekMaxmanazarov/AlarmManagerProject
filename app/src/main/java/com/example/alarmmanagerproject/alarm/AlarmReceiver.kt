package com.example.alarmmanagerproject.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("ALARM_MESSAGE") ?: return
        println("Alarm message = $message")
    }
}