package com.dyhdyh.base.components.example

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.dyhdyh.base.components.example.fragment.AFragment
import com.dyhdyh.base.components.example.fragment.BFragment
import com.dyhdyh.base.components.example.fragment.CFragment
import com.dyhdyh.support.fragmenthelper.adapter.CacheFragmentPagerAdapter
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_viewpager.*

class ExampleFragmentActivity : BaseCompatActivity() {
    override fun getContentViewId(): Int {
        return R.layout.activity_viewpager
    }

    override fun onAfterViews(savedInstanceState: Bundle?) {
        val adapter = CacheFragmentPagerAdapter(supportFragmentManager, AFragment(), BFragment(), CFragment())
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                ImmersionBar.with(this@ExampleFragmentActivity)
                    .statusBarDarkFont(position != 0)
                    .init()
            }
        })
    }
}
