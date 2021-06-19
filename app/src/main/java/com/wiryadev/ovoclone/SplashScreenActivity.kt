package com.wiryadev.ovoclone

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.accompanist.pager.ExperimentalPagerApi

class SplashScreenActivity : AppCompatActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        finish()
    }

}