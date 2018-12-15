package com.dyhdyh.base.components.example.fragment

import android.os.Bundle
import android.view.View
import com.dyhdyh.base.components.example.R
import com.dyhdyh.base.components.AbstractCompatFragment

/**
 * @author  dengyuhan
 * created 2018/12/16 01:40
 */
class BFragment : AbstractCompatFragment() {
    override fun getContentViewId(): Int {
        return R.layout.fragment_b
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}