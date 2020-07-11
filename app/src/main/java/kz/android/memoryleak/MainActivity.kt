package kz.android.memoryleak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Library.initLibrary(this)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.container,
                    MainActivityFragment()
                )
                .commitAllowingStateLoss()
            supportFragmentManager.executePendingTransactions()
        }
    }

    fun replaceFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                MainActivityFragment()
            )
            .addToBackStack("tag")
            .commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }
}
