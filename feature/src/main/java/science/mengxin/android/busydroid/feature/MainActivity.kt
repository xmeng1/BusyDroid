package science.mengxin.android.busydroid.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun someMethod(theButton: View) {
        Log.v("Basic Study", "Button Click" + theButton.transitionName)
    }
}
