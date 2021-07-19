package com.tongfu.mytestapp.network.networkstate

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.net.NetworkSpecifier
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tongfu.mytestapp.R

class NetworkStateActivity : AppCompatActivity() {
    private val connManager :ConnectivityManager by lazy { getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    private val networkCallback by lazy { object: ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            runOnUiThread {
                Toast.makeText(this@NetworkStateActivity , "网络已连接" , Toast.LENGTH_LONG).show()
            }
            super.onAvailable(network)
        }

        override fun onLost(network: Network) {
            runOnUiThread {
                Toast.makeText(this@NetworkStateActivity , "网络已断开" , Toast.LENGTH_LONG).show()
            }
            super.onLost(network)
        }

        override fun onUnavailable() {
            super.onUnavailable()
        }
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_state)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            connManager.registerNetworkCallback(NetworkRequest.Builder().apply {
            }.setNetworkSpecifier(object:NetworkSpecifier(){

            }) .build() , networkCallback )
        }

        connManager.requestNetwork(NetworkRequest.Builder().build() ,networkCallback)
    }

    override fun onDestroy() {
        connManager.unregisterNetworkCallback(networkCallback)
        super.onDestroy()
    }
}