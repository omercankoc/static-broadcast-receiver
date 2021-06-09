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

    fun insideBroadcast(view : View){
        // InsideBroadcast sinifina veri gonder.
        val intent : Intent = Intent(this,InsideBroadcast::class.java)
        val bundle : Bundle = Bundle()
        bundle.putString("message","Static Broadcast Receiver is running inside the Class...")
        intent.putExtras(bundle)
        sendBroadcast(intent)
    }

    fun outsideBroadcast(view : View){
        // OutsideBroadcast sinifina veri gonder.
        val intent : Intent = Intent(this,OutsideBroadcast::class.java)
        val bundle : Bundle = Bundle()
        bundle.putString("message","Static Broadcast Receiver is running outside the Class...")
        intent.putExtras(bundle)
        sendBroadcast(intent)
    }

    class InsideBroadcast : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // Gonderilen veriyi al ve goster.
            var bundle : Bundle = intent!!.extras!!
            var message : String? = bundle.getString("message")
            Toast.makeText(context,message,Toast.LENGTH_LONG).show()
        }
    }
}