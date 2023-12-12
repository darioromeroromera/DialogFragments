package com.example.dialogfragment.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.R
import com.example.dialogfragment.controller.Controller
import com.example.dialogfragment.databinding.DialogLayoutBinding
import com.example.dialogfragment.interfaces.onLoginInterface
import java.lang.IllegalStateException

class LoginDialogImpl(
    val controller: Controller
) : DialogFragment() {
    lateinit var userName: String
    lateinit var password: String
    lateinit var listener: onLoginInterface


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        listener = controller as onLoginInterface
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val viewDialogLogin = inflater.inflate(R.layout.dialog_layout, null)
            builder.setView(viewDialogLogin)
            builder.setMessage("Login")
            builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, id ->
                val binding = DialogLayoutBinding.bind(viewDialogLogin)
                userName = binding.etUser.text.toString()
                password = binding.etPass.text.toString()
                listener.onDialogPositiveClick(this)
            })
            builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                listener.onDialogNegativeClick(this)
            })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
