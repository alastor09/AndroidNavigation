package au.com.soan.androidnavigation.ui.main

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {

    private val _alertCountdown: MutableLiveData<Int> = MutableLiveData(10)

    val countdown: LiveData<Int> = _alertCountdown

    private val _shouldAlert: MutableLiveData<Boolean> = MutableLiveData(false)

    val shouldShowAlert: LiveData<Boolean> = _shouldAlert

    private fun createCountdownTimer() =
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                warnCountdownTimer(millisUntilFinished)
            }

            override fun onFinish() {
                _shouldAlert.value = true
            }
        }

    private fun warnCountdownTimer(millsLeft: Long) {
        val roundedTime = (millsLeft.toDouble() / 1000.0).roundToInt()
        _alertCountdown.value = roundedTime
    }

    fun startCountdown(){
        val timer = createCountdownTimer()
        timer.start()
    }

    fun reset(){
        _alertCountdown.value = 10
        _shouldAlert.value = false
    }
}