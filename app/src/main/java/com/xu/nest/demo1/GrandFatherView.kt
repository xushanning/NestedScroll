package com.xu.nest.demo1

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * @author 许 on 2024/7/6.
 */
internal class GrandFatherView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}
