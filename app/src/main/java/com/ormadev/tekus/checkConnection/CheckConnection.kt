//@file:Suppress("DEPRECATION")

package com.ormadev.tekus.checkConnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class CheckConnection {

    fun CheckNetwork(context : Context): Boolean{

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val networkCapabilities = connectivityManager.activeNetwork?: return false
            val networkInfo = connectivityManager.getNetworkCapabilities(networkCapabilities)?: return  false

            return networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }else{
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

    }
}

