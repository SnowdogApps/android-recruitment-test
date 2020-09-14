package dog.snow.androidrecruittest.ui.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    fun redirectToActivity(direction: Class<out AppCompatActivity>) {
        startActivity(Intent(this, direction))
        finish()
    }

    fun startActivity(direction: Class<out AppCompatActivity>) {
        startActivity(Intent(this, direction))
        finish()
    }

    protected abstract fun setupViewModel()
}