package com.omercankoc.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class OutsideBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Gonderilen veriyi al ve goster.
        var bundle : Bundle = intent!!.extras!!
        var message : String? = bundle.getString("message")
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
}