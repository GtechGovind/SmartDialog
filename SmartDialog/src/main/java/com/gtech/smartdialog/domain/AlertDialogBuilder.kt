package com.gtech.smartdialog.domain

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.gtech.smartdialog.R
import com.gtech.smartdialog.app.GtechApp
import com.gtech.smartdialog.databinding.CustomeAlertDialogBinding
import com.gtech.smartdialog.utils.DialogType

class AlertDialogBuilder(private val message: String, private val type: DialogType, private val listener: DialogListeners? = null) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val binding = CustomeAlertDialogBinding.inflate(requireActivity().layoutInflater)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setCancelable(false)
        builder.setView(binding.root)

        when (type) {
            DialogType.SUCCESS -> Glide.with(GtechApp.instance).load(R.drawable.success).into(binding.image)
            DialogType.INFO -> Glide.with(GtechApp.instance).load(R.drawable.info).into(binding.image)
            else -> Glide.with(GtechApp.instance).load(R.drawable.error).into(binding.image)
        }

        binding.message.text = message

        if (listener != null) {
            binding.button.setOnClickListener {
                listener.onDialogClick(dialog, type)
            }
        } else {
            binding.button.setOnClickListener {
                dialog?.dismiss()
            }
        }

        return  builder.create()

    }

}
