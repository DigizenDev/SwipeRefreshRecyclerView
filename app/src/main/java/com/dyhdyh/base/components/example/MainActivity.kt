package com.dyhdyh.base.components.example

import android.view.View
import android.view.WindowManager
import com.dyhdyh.base.components.example.dialog.ExampleDialog

class MainActivity : BaseCompatActivity() {
    override fun onAfterViews() {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //startActivity(Intent(this, ExampleFragmentActivity::class.java))
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }


    fun clickDialog(v: View) {
        ExampleDialog(this).show()
    }
}
