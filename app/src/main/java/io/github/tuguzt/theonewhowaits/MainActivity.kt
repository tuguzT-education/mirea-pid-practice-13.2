package io.github.tuguzt.theonewhowaits

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.github.tuguzt.theonewhowaits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val timeTickReceiver = TimeTickReceiver()
    private val batteryLowReceiver = BatteryLowReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerReceiver(timeTickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
        registerReceiver(batteryLowReceiver, IntentFilter(Intent.ACTION_BATTERY_LOW))

        timeTickReceiver.counter.observe(this) {
            binding.print.text = getString(R.string.minutes_text, it.toInt())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeTickReceiver)
        unregisterReceiver(batteryLowReceiver)
    }

    fun cancelWait(@Suppress("UNUSED_PARAMETER") view: View) {
        unregisterReceiver(timeTickReceiver)
        Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show()
    }
}
