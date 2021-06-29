package au.com.soan.androidnavigation.utils

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import au.com.soan.androidnavigation.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun MaterialAlertDialogBuilder.createDialog(title: Int? = null,
                                            message: Any? = null, // should be an Int ( string resource ) or a String
                                            view: Any? = null, // should be of type Int ( a layout ) or View
                                            positiveButtonText: Int? = null,
                                            positiveButtonAction: DialogInterface.() -> Unit = {},
                                            negativeButtonText: Int? = null,
                                            negativeButtonAction: DialogInterface.() -> Unit = {dismiss()},
                                            cancelable:Boolean = true): AlertDialog?{

    // Make sure there is enough content to show an alert
    if(title == null && message == null && view ==null) return null

    title?.let { setTitle(context.resources.getString(it)) }
    message?.let{
        when(it){
            is Int -> setMessage(context.resources.getString(it))
            is String -> setMessage(it)
            else -> {}
        }
    }
    // Only set the view if it's a layout Int or a View
    when(view){
        is Int -> setView(view)
        is View -> setView(view)
    }
    positiveButtonText?.let{
        setPositiveButton(it) { dialog, _ -> dialog.positiveButtonAction() }
    }
    negativeButtonText?.let{
        setNegativeButton(it) { dialog, _ -> dialog.negativeButtonAction() }
    }
    setCancelable(cancelable)

    return create().apply {
        window?.setBackgroundDrawableResource(R.drawable.bg_dialog)
    }
}