package com.example.dialogfragment.controller

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.MainActivity
import com.example.dialogfragment.dialogues.LoginDialogImpl
import com.example.dialogfragment.dialogues.LoginDialogLambda
import com.example.dialogfragment.interfaces.onLoginInterface

class Controller (val contexto: Context) : onLoginInterface {

    init {
        initEvent()
    }

    private fun initEvent() {
        val mainActivity = contexto as MainActivity
        mainActivity.binding.btnDialogInterface.setOnClickListener { view ->
            initDialogWithInterface(mainActivity)
        }
        mainActivity.binding.btnDialogLambda.setOnClickListener { view ->
            val dialog = LoginDialogLambda({ user, pass ->
                mainActivity.binding.tvUser.text = "Usuario: $user"
                mainActivity.binding.tvPass.text = "Contraseña: $pass"
            },
                { message ->
                    Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show()
                })
            dialog.show(mainActivity.supportFragmentManager, "Login")
        }
    }

    private fun initDialogWithInterface(mainActivity: MainActivity) {
        val dialog = LoginDialogImpl(this)
        dialog.show(mainActivity.supportFragmentManager, "Login")
    }

    override fun onDialogPositiveClick(dialog: DialogFragment?) {
        val myDialogLogin= dialog as LoginDialogImpl
        val user = myDialogLogin.userName
        val pass = myDialogLogin.password
        val mainActivity = contexto as MainActivity
        mainActivity.binding.tvUser.text = "Usuario: $user"
        mainActivity.binding.tvPass.text = "Contraseña: $pass"
    }

    override fun onDialogNegativeClick(dialog: DialogFragment?) {
        Toast.makeText(contexto, "Operacion cancelada", Toast.LENGTH_LONG).show()
    }
}