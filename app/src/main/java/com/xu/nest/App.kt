package com.xu.nest

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * @author 许 on 2024/6/29.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val strategy = PrettyFormatStrategy.newBuilder().tag("xsn").build()
        Logger.addLogAdapter(AndroidLogAdapter(strategy))
    }
}