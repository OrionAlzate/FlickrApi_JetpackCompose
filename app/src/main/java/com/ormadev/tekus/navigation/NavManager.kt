package com.ormadev.tekus.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ormadev.tekus.viewModel.FlickrViewModel
import com.ormadev.tekus.views.FlickrImageView
import com.ormadev.tekus.views.HomeView

@Composable
fun NavManager(viewModel: FlickrViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
//            ContentHomeView(viewModel, navController) // corregir
            HomeView(viewModel, navController)

        }

        composable(
            "FlickrImageView/{title}/{imageUrl}",
            arguments = listOf(
                navArgument("title"){type = NavType.StringType},
                navArgument("imageUrl"){type = NavType.StringType})
            ){

            val title : String = (it.arguments?.getString("title") ?: "").toString()
            val encodedImageUrl : String = (it.arguments?.getString("imageUrl") ?: "").toString()
            val imageUrl : String = Uri.decode(encodedImageUrl)

            FlickrImageView(viewModel, navController, title, imageUrl)
        }

    }
}