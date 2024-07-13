package com.xu.nest

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.NestedScrollingParent2
import androidx.core.view.NestedScrollingParentHelper
import com.orhanobut.logger.Logger


/**
 * @author 许 on 2024/6/29.
 */
class MyFrameLayout : FrameLayout, NestedScrollingParent2 {

    private val childHelper = NestedScrollingChildHelper(this)
    private val parentHelper = NestedScrollingParentHelper(this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        isNestedScrollingEnabled = true
    }

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        childHelper.isNestedScrollingEnabled = enabled
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        if (axes and SCROLL_AXIS_VERTICAL != 0) {
            //开始通知parent的嵌套滑动
            childHelper.startNestedScroll(axes, type)
            return true
        }
        return false
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        parentHelper.onNestedScrollAccepted(child, target, axes)
        Logger.d("Accepted")
    }

    override fun onStopNestedScroll(target: View, type: Int) {

    }


    /**
     * 在嵌套滑动的子控件未滑动之前，判断父控件是否优先与子控件处理(也就是父控件可以先消耗，然后给子控件消耗）
     *
     * @param target   具体嵌套滑动的那个子类
     * @param dx       水平方向嵌套滑动的子控件想要变化的距离 dx<0 向右滑动 dx>0 向左滑动
     * @param dy       垂直方向嵌套滑动的子控件想要变化的距离 dy<0 向下滑动 dy>0 向上滑动
     * @param consumed 这个参数要我们在实现这个函数的时候指定，回头告诉子控件当前父控件消耗的距离
     *                 consumed[0] 水平消耗的距离，consumed[1] 垂直消耗的距离 好让子控件做出相应的调整
     */
    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Logger.d("PreScroll")
        val array = IntArray(2)
        array[0] = 0
        array[1] = 0
        childHelper.dispatchNestedPreScroll(dx, dy, consumed, null)
        val leftY = dy - array[1] //parent留给我的
        consumed[1] = leftY
    }

    /**
     * 嵌套滑动的子控件在滑动之后，判断父控件是否继续处理（也就是父消耗一定距离后，子再消耗，最后判断父消耗不）
     *
     * @param target       具体嵌套滑动的那个子类
     * @param dxConsumed   水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed   垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed 水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed 垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     */
    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        Logger.d("Scroll")
    }


    override fun getNestedScrollAxes(): Int {
        return super.getNestedScrollAxes()
    }

    override fun onStopNestedScroll(target: View) {
        super.onStopNestedScroll(target)
    }
}
