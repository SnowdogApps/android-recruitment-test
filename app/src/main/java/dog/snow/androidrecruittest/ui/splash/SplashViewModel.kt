package dog.snow.androidrecruittest.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(

) : ViewModel() {

    fun log() {
        Log.i(TAG, "adasfsfasfa")
    }

    companion object {
        private val TAG = SplashViewModel::class.simpleName
    }
}