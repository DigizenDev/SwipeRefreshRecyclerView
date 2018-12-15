package com.dyhdyh.base.components.example

import android.content.Intent

class MainActivity : BaseCompatActivity() {
    override fun onAfterViews() {
        startActivity(Intent(this, ExampleFragmentActivity::class.java))
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }
}
