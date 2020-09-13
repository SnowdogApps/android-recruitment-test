package dog.snow.androidrecruittest.ui.page.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.databinding.SplashActivityBinding
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.utils.subscribe
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    //TODO: add navigation and databinding libraries.

    @Inject //TODO: refactor this to be used by BaseActivity
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var splashViewModel: SplashViewModel
    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity)
        setupViewModel()
    }

    /** Utils. */

    private fun setupViewModel() {
        splashViewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
        splashViewModel.fetchDataState.subscribe(this) {
            setLoadingView(false)
            when(it) {
                is Resource.Success -> {

                }
                is Resource.Loading -> setLoadingView(true)
                is Resource.Error -> showError(it.message)
            }
        }
    }

    private fun setLoadingView(isLoading: Boolean) {
        binding.layoutProgressbar.progressbar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> splashViewModel.fetchData() }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }
}