package dog.snow.androidrecruittest.ui.activities

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initViews()
    }

    private fun initViews() {
        initActionBar()
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        toolbar?.setNavigationOnClickListener { onToolbarNavigateUp() }
        configureActionBar(supportActionBar)
    }

    private fun configureActionBar(actionBar: ActionBar?) {
        actionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun onToolbarNavigateUp() {
        onBackPressed()
    }
}