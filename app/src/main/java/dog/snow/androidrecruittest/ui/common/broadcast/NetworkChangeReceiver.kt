package dog.snow.androidrecruittest.ui.common.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager



class NetworkChangeReceiver(
    private val onChanged: (Boolean) -> Unit
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val connMgr = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            onChanged.invoke(connMgr.activeNetwork == null)
    }
}