package com.gtech.smartdialog.domain

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gtech.smartdialog.R
import com.gtech.smartdialog.app.GtechApp
import com.gtech.smartdialog.databinding.CustomLoadingDialogBinding

class LoadingDialogBuilder(private val activity: AppCompatActivity) {

    private lateinit var binding: CustomLoadingDialogBinding
    private lateinit var dialog: AlertDialog

    fun start(message: String = "Loading please wait ...") {

        binding = CustomLoadingDialogBinding.inflate(activity.layoutInflater)
        val builder = AlertDialog.Builder(activity)
        builder.setView(binding.root)
        builder.setCancelable(false)
        dialog = builder.create()

        Glide.with(GtechApp.instance).load(R.drawable.loading).into(binding.image)
        binding.message.text = message

        dialog.show()
    }

    fun stop() {
        if (this::dialog.isInitialized) {
            dialog.dismiss()
        }
    }

}
