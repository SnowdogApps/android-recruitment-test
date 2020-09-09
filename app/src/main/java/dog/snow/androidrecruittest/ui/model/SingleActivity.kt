package dog.snow.androidrecruittest.ui.model

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

abstract class SingleActivity : AppCompatActivity() {

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initActionBar()
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        toolbar?.setNavigationOnClickListener { onBackPressed() }
        configureActionBar(supportActionBar)
    }

    private fun configureActionBar(actionBar: ActionBar?) {
        actionBar?.setDisplayShowTitleEnabled(true)
    }
}
