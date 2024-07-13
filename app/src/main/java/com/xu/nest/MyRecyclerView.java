package com.xu.nest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 许 on 2024/6/30.
 */

public class MyRecyclerView extends RecyclerView {
   public MyRecyclerView(@NonNull Context context) {
      super(context);
   }

   public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
      super(context, attrs);
   }

   public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
   }

   @Override
   public boolean dispatchTouchEvent(MotionEvent ev) {
      getParent().requestDisallowInterceptTouchEvent(true);
      return super.dispatchTouchEvent(ev);
   }
}
