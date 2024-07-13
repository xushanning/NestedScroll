package com.xu.nest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

    }

    override fun onResume() {
        super.onResume()
        val adapter = MyAdapter()
        val rv: RecyclerView = findViewById(R.id.rv_home)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<String>()
        for (i in 1..100) {
            list.add(i.toString())
        }
        adapter.setData(list)
        val dialogFragment = MyBottomSheetDialogFragment()
        dialogFragment.show(supportFragmentManager, "dialogFragment")
    }
}