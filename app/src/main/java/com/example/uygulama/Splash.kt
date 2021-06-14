package com.example.uygulama

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        val baglanti=baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val baglantibilgi=baglanti.activeNetworkInfo
        if(baglantibilgi!=null&&baglantibilgi.isConnected){
            gorsel.alpha=0f
            gorsel.animate().setDuration(3000).alpha(1f).withEndAction{
                val i=Intent(this,MainActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }
        else{
            Toast.makeText(baseContext,"Çevrimdışı olduğunuz için uygulama sonlandırıldı - İnternet bağlantınızı kontrol ediniz.",Toast.LENGTH_LONG).show()
            finish()
        }




    }
}