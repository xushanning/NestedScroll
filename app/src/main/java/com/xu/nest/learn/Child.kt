package com.xu.nest.learn

import androidx.core.view.NestedScrollingChild
import androidx.core.view.NestedScrollingChild2

/**
 * @author 许 on 2024/6/29.
 */
class Child : NestedScrollingChild {
    override fun setNestedScrollingEnabled(enabled: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isNestedScrollingEnabled(): Boolean {
        TODO("Not yet implemented")
    }


    override fun startNestedScroll(axes: Int): Boolean {
        TODO("Not yet implemented")
    }


    override fun stopNestedScroll() {
        TODO("Not yet implemented")
    }


    override fun hasNestedScrollingParent(): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * 当父控件消耗事件后，子控件处理后，又继续将事件分发给父控件,由父控件判断是否消耗剩下的距离。
     *
     * @param dxConsumed     水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed     垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed   水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed   垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param offsetInWindow 子控件在当前window的偏移量
     * @return 如果返回true, 表示父控件又继续消耗了
     */
    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * 在子控件滑动前，将事件分发给父控件，由父控件判断消耗多少
     *
     * @param dx             水平方向嵌套滑动的子控件想要变化的距离 dx<0 向右滑动 dx>0 向左滑动
     * @param dy             垂直方向嵌套滑动的子控件想要变化的距离 dy<0 向下滑动 dy>0 向上滑动
     * @param consumed       子控件传给父控件数组，用于存储父控件水平与竖直方向上消耗的距离，consumed[0] 水平消耗的距离，consumed[1] 垂直消耗的距离
     * @param offsetInWindow 子控件在当前window的偏移量
     * @return 如果返回true, 表示父控件已经消耗了
     */
    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?): Boolean {
        TODO("Not yet implemented")
    }

    override fun dispatchNestedFling(velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean {
        TODO("Not yet implemented")
    }
}