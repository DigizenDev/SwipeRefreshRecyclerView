package com.dyhdyh.base.components.example

import android.os.Bundle
import android.support.v4.widget.PopupWindowCompat
import android.view.Gravity
import android.view.View
import com.dyhdyh.base.components.example.dialog.ExampleDialog
import com.dyhdyh.base.components.example.dialog.ExamplePopupWindow

class MainActivity : BaseCompatActivity() {
    override fun onAfterViews(savedInstanceState: Bundle?) {
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
