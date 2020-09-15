package dog.snow.androidrecruittest.ui.page.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar( binding.layoutAppbar.appbar.toolbar)
        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }

}