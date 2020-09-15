package dog.snow.androidrecruittest.ui.page.main

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkRequest
import androidx.work.Worker
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.databinding.ActivityMainBinding
import dog.snow.androidrecruittest.ui.common.broadcast.NetworkChangeReceiver
import kotlinx.android.synthetic.main.layout_banner.view.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val networkChangeReceiver = NetworkChangeReceiver() {isOffline ->
        binding.layoutAppbar.appbar.banner.visibility = if(isOffline) View.VISIBLE else View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar( binding.layoutAppbar.appbar.toolbar)

        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        registerNetworkBroadcast()
    }

    override fun onPause() {
        super.onPause()
        unregisterNetworkBroadcast()
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }

    /** Utils. */

    private fun registerNetworkBroadcast() {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(networkChangeReceiver, filter)
    }

    private fun unregisterNetworkBroadcast() {
        unregisterReceiver(networkChangeReceiver)
    }
}