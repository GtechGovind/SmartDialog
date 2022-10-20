package com.gtech.smartdialog.domain

import android.app.Dialog
import com.gtech.smartdialog.utils.DialogType

interface DialogListeners {
    fun onDialogClick(dialog: Dialog?, type: DialogType)
}