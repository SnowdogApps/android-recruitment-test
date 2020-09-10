package dog.snow.androidrecruittest.ui.page.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R

class MainActivity : AppCompatActivity(R.layout.main_activity){
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}