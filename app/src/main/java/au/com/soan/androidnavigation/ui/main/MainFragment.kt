package au.com.soan.androidnavigation.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import au.com.soan.androidnavigation.databinding.MainFragmentBinding
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.countdown.observe(viewLifecycleOwner, {
            binding.message.text = "Countdown: $it"
        })

        viewModel.shouldShowAlert.observe(viewLifecycleOwner, {
            if(it) {
                viewModel.reset()
                navigateTo(MainFragmentDirections.actionMainFragmentToAlertFragment())
            }
        })

        binding.btnStart.setOnClickListener {
            viewModel.startCountdown()
        }

    }

    fun Fragment.navigateTo(navDirection: NavDirections) {
        findNavController().navigate(navDirection)
    }
}