package io.github.tuguzt.theonewhowaits

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryLowReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, R.string.battery_low_text, Toast.LENGTH_SHORT).show()
    }
}
