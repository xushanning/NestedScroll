package com.xu.nest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * @author 许 on 2024/6/30.
 */
class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {


    private fun initView(view: View) {
        val adapter = MyAdapter()
        val rv: RecyclerView = view.findViewById(R.id.rv_dialog)

        rv.isNestedScrollingEnabled = false
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(context)
        val list = ArrayList<String>()
        for (i in 1..100) {
            list.add(i.toString())
        }
        adapter.setData(list)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_fragment_layout, null, false)
        initView(view)
        dialog.setContentView(view)

        val bottomSheet = dialog.delegate.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
        if (bottomSheet != null) {
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            behavior?.peekHeight = 0

            behavior?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                        dismiss()
                    }

                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }
            })
            view.post {
                behavior?.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }
}