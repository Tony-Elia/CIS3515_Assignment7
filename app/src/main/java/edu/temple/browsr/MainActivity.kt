package edu.temple.browsr

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), PageFragment.ControlActions {
    private val pageFragment : PageFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.page) as PageFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.page) == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.page, PageFragment())
                .commit()
        }
    }

    override fun back() = pageFragment.back()
    override fun forward() = pageFragment.forward()
}