package io.github.tuguzt.theonewhowaits

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TimeTickReceiver : BroadcastReceiver() {
    private val _counter = MutableLiveData<UInt>()
    val counter: LiveData<UInt> get() = _counter

    override fun onReceive(context: Context, intent: Intent) {
        _counter.value = (counter.value ?: 0u) + 1u
    }
}
