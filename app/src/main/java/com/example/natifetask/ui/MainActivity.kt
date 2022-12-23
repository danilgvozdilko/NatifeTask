package com.example.natifetask.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.natifetask.R
import com.example.natifetask.databinding.ActivityMainBinding
import com.example.natifetask.navigation.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router
    val viewModel: MainActivityViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupNavigation()
        setContentView(binding.root)
        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mainFragment -> {
                    val sharedPreferences =
                        this.getSharedPreferences(
                            getString(R.string.user_status),
                            Context.MODE_PRIVATE
                        )
                    val isLogined = sharedPreferences.getBoolean(getString(R.string.logedIn), false)
                    if (isLogined) {
                        viewModel.navigateToHomeFragment()
                    } else {
                        Toast.makeText(
                            this,
                            getString(R.string.need_login_or_create),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                R.id.selectedFragment -> {
                    val sharedPreferences =
                        this.getSharedPreferences(
                            getString(R.string.user_status),
                            Context.MODE_PRIVATE
                        )
                    val isLogined = sharedPreferences.getBoolean(getString(R.string.logedIn), false)
                    if (isLogined) {
                        viewModel.navigateToSelected()
                    } else {
                        Toast.makeText(this, getString(R.string.need_login), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                R.id.settingsFragment -> {
                    val sharedPreferences =
                        this.getSharedPreferences(
                            getString(R.string.user_status),
                            Context.MODE_PRIVATE
                        )
                    val isLogined = sharedPreferences.getBoolean(getString(R.string.logedIn), false)
                    if (isLogined) {
                        viewModel.navigateToSettings()
                    } else {
                        Toast.makeText(this, getString(R.string.need_login), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

        binding.navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.log_out -> {
                    val sharedPreferences =
                        this.getSharedPreferences(
                            getString(R.string.user_status),
                            Context.MODE_PRIVATE
                        )
                    val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
                    editor?.putBoolean(getString(R.string.logedIn), false)
                    editor?.commit()
                    viewModel.navigateToLogin()

                }
                R.id.settingsFragment -> {
                    viewModel.navigateToSettings()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }


    private fun setupNavigation() {
        router.attachNavController(navController)
    }

}