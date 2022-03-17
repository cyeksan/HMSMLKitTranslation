package com.example.hmsmlkittranslation.presentation.translate

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hmsmlkittranslation.presentation.composables.TranslateButton
import com.example.hmsmlkittranslation.presentation.composables.TranslationResultText
import com.example.hmsmlkittranslation.presentation.composables.TranslationTextField
import com.example.hmsmlkittranslation.ui.theme.darkBackground

@Composable
fun TranslateScreen() {
    val context = LocalContext.current.applicationContext
    val translateViewModel = hiltViewModel<TranslateViewModel>()
    val state = translateViewModel.state.value
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBackground)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TranslationTextField(textToBeTranslated = translateViewModel.textToBeTranslatedState)
        TranslateButton {
            translateViewModel.translate(context, translateViewModel.textToBeTranslatedState.value)
        }
        when (state) {
            is TranslationState.TranslationLoading -> LinearProgressIndicator()
            is TranslationState.TranslationSuccess -> TranslationResultText(translationResult = state.translationResult)
            is TranslationState.TranslationFail -> Toast.makeText(context, state.errorMessage, Toast.LENGTH_LONG).show()
            else -> {
            }
        }
    }
}