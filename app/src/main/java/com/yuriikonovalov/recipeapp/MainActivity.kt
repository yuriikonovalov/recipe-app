package com.yuriikonovalov.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.yuriikonovalov.recipeapp.databinding.ActivityMainBinding
import com.yuriikonovalov.recipeapp.util.AdaptiveNavUtils
import com.yuriikonovalov.recipeapp.util.addSystemTopPadding
import com.yuriikonovalov.recipeapp.util.doOnApplyWindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.applyWindowInsets()
        initNavController()
        binding.setupNavigationViews()
    }

    private fun initNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
    }

    private fun ActivityMainBinding.setupNavigationViews() {
        navModalDrawer.setupWithNavController(navController)
        navRail.setupWithNavController(navController)
        navStandardDrawer.setupWithNavController(navController)

        AdaptiveNavUtils.updateNavigationViewLayout(
            screenWidth = resources.configuration.screenWidthDp,
            drawerLayout = binding.drawerLayout,
            modalNavDrawer = binding.navModalDrawer,
            navRail = binding.navRail,
            standardNavDrawer = binding.navStandardDrawer
        )
    }

    private fun ActivityMainBinding.applyWindowInsets() {
        drawerLayout.addSystemTopPadding(binding.navModalDrawer)
        sideNavContainer.doOnApplyWindowInsetsCompat { container, windowInsetsCompat, _ ->
            container.updatePadding(
                left = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left
            )
        }
    }

    override fun onBackPressed() {
        // If the drawer is open then pressing back button closes it.
        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }
}