package au.com.soan.androidnavigation.ui.main

import android.app.Dialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import au.com.soan.androidnavigation.databinding.HelpFragmentBinding
import au.com.soan.androidnavigation.utils.createDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HelpFragment : DialogFragment() {

    private lateinit var viewModel: HelpViewModel

    private lateinit var dialogView: View

    private var _binding: HelpFragmentBinding? = null
    private val binding: HelpFragmentBinding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return dialogView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = HelpFragmentBinding.inflate(layoutInflater, null, false)
        this.dialogView = binding.root
        return MaterialAlertDialogBuilder(requireContext()).createDialog(
            view = dialogView,
            cancelable = true
        )!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HelpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}