package com.example.hmsmlkittranslation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hmsmlkittranslation.ui.theme.HMSMLKitTranslationTheme
import com.example.hmsmlkittranslation.presentation.translate.TranslateScreen
import com.huawei.hms.mlsdk.common.MLApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MLApplication.getInstance().apiKey = resources.getString(R.string.api_key)
        setContent {
            HMSMLKitTranslationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "translate") {
                        composable("translate") { TranslateScreen() }
                    }
                }
            }
        }
    }
}