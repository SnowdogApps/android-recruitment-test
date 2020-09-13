package dog.snow.androidrecruittest.ui.page.splash

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.utils.subscribe
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import javax.inject.Inject

class SplashActivity : AppCompatActivity(R.layout.splash_activity) {

    //TODO: add navigation and databinding libraries.

    @Inject //TODO: refactor this to be used by BaseActivity
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    /** Utils. */

    private fun setupViewModel() {
        splashViewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
        splashViewModel.fetchDataState.subscribe(this) {
            
        }
    }

    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> /*tryAgain()*/ }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }
}