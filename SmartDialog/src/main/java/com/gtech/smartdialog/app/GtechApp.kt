package com.gtech.smartdialog.app

import android.app.Application

class GtechApp: Application() {

    companion object {
        lateinit var instance: GtechApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}