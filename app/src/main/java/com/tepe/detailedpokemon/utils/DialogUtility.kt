package com.tepe.detailedpokemon.utils

import android.app.Activity
import android.app.AlertDialog

fun alertDialog(activity: Activity, title: String = "Error", msg: String, onOk: () -> Unit) {
    AlertDialog.Builder(activity).apply {
        setTitle(title)
        setMessage(msg)
        setCancelable(false)
        setNegativeButton("OK") { dialog, _ ->
            run {
                onOk()
                dialog?.dismiss()
            }
        }
    }.create().show()
}