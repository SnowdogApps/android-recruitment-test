package dog.snow.androidrecruittest.utils

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.ui.page.splash.SplashActivity

fun AppCompatActivity.redirectToActivity(direction: Class<out AppCompatActivity>) {
    startActivity(Intent(this, direction))
    finish()
}

fun AppCompatActivity.startActivity(direction: Class<out AppCompatActivity>) {
    startActivity(Intent(this, direction))
    finish()
}

fun SplashActivity.showError(errorMessage: String?) {
    MaterialAlertDialogBuilder(this)
        .setTitle(R.string.cant_download_dialog_title)
        .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
        .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> splashViewModel.fetchData() }
        .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
        .create()
        .apply { setCanceledOnTouchOutside(false) }
        .show()
}

fun SplashActivity.setLoadingView(isLoading: Boolean) {
    binding.layoutProgressbar.progressbar.visibility = if (isLoading) View.VISIBLE else View.GONE
}