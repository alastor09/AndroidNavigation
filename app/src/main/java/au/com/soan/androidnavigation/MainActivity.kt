package au.com.soan.androidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.DialogFragmentNavigator
import au.com.soan.androidnavigation.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding: MainActivityBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        Navigation.findNavController(this, R.id.navHostFragment)
            .addOnDestinationChangedListener { _, destination, _ ->
                if(destination is DialogFragmentNavigator.Destination){
                    return@addOnDestinationChangedListener
                }
                when (destination.id) {
                    R.id.mainFragment -> {
                        supportActionBar?.setDisplayShowTitleEnabled(false)
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        binding.toolbar.visibility = View.VISIBLE
                    }
                    else -> {
                        supportActionBar?.setDisplayShowTitleEnabled(true)
                        supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        binding.toolbar.visibility = View.VISIBLE
                    }
                }
            }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_appHelp -> {
                Navigation.findNavController(this, R.id.navHostFragment).navigate(R.id.action_global_helpFragment)
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}