package com.omercankoc.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun innerClass(view : View){
        val intent : Intent = Intent(this,BroadcastInnerClass::class.java)
        sendBroadcast(intent)
    }

    fun broadcastClass(view : View){
        val intent : Intent = Intent(this,BroadcastClass::class.java)
        sendBroadcast(intent)
    }

    class BroadcastInnerClass : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Inner Class Broadcast",Toast.LENGTH_LONG).show()
        }
    }
}