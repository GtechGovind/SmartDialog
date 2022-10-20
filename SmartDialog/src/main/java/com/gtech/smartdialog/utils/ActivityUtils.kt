package com.gtech.smartdialog.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gtech.smartdialog.domain.DialogListeners
import com.gtech.smartdialog.domain.LoadingDialogBuilder
import com.gtech.smartdialog.domain.AlertDialogBuilder

// Loading dialog
lateinit var loadingDialogBuilder: LoadingDialogBuilder

fun AppCompatActivity.startLoader(message: String) {
    try {
        this.runOnUiThread {
            loadingDialogBuilder = LoadingDialogBuilder(this)
            loadingDialogBuilder.start(message)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun AppCompatActivity.stopLoader() {
    try {
        this.runOnUiThread {
            loadingDialogBuilder.stop()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Fragment.startLoader(message: String) {
    try {
        this.requireActivity().runOnUiThread {
            loadingDialogBuilder = LoadingDialogBuilder(requireActivity() as AppCompatActivity)
            loadingDialogBuilder.start(message)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Fragment.stopLoader() {
    try {
        this.requireActivity().runOnUiThread {
            loadingDialogBuilder.stop()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Fragment.showAlert(
    message: String, type: DialogType, dialogListeners: DialogListeners? = null
) {
    try {
        requireActivity().runOnUiThread {
            AlertDialogBuilder(
                message, type, dialogListeners
            ).show(requireActivity().supportFragmentManager, null)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun AppCompatActivity.showAlert(
    message: String, type: DialogType, dialogListeners: DialogListeners? = null
) {
    try {
        this.runOnUiThread {
            AlertDialogBuilder(message, type, dialogListeners).show(
                this.supportFragmentManager, null
            )
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
