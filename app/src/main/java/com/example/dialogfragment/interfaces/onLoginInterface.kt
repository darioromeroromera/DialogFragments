package com.example.dialogfragment.interfaces

import androidx.fragment.app.DialogFragment

interface onLoginInterface {
    fun onDialogPositiveClick(dialog: DialogFragment?)
    fun onDialogNegativeClick(dialog: DialogFragment?)
}