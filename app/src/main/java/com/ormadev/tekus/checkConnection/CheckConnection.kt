package com.ormadev.tekus.checkConnection

//import android.content.Context
//import android.net.ConnectivityManager
//import android.net.NetworkCapabilities
//import android.os.Build
//
//class CheckConnection {
//
//    fun CheckNetwork(context : Context): Boolean{
//
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            val networkCapabilities = connectivityManager.activeNetwork?: return false
//            val networkInfo = connectivityManager.getNetworkCapabilities(networkCapabilities)?: return  false
//
//            return networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
//                    networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
//        }else{
//            val networkInfo = connectivityManager.activeNetworkInfo
//            return networkInfo != null && networkInfo.isConnected
//        }
//
//    }
//}

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class CheckConnection {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false

            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }

    fun isNetworkMetered(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED) == false
        } else {
            false // No se puede determinar si la conexión es de medición en versiones anteriores a M
        }
    }
}
