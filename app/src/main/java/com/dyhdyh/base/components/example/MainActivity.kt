package com.dyhdyh.base.components.example

import android.support.v4.widget.PopupWindowCompat
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.dyhdyh.base.components.example.dialog.ExampleDialog
import com.dyhdyh.base.components.example.dialog.ExamplePopupWindow

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


    fun clickPopupWindow(v: View) {
        PopupWindowCompat.showAsDropDown(ExamplePopupWindow(this),v,0,0,Gravity.TOP)
    }
}
