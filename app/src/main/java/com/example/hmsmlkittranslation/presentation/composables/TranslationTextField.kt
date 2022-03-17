package com.example.hmsmlkittranslation.presentation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hmsmlkittranslation.R

@Composable
fun TranslationTextField(textToBeTranslated: MutableState<String>) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 64.dp, 16.dp, 16.dp)
            .border(0.5.dp, Color.White),
        value = textToBeTranslated.value,
        onValueChange = {
            textToBeTranslated.value = it
        },
        singleLine = false,
        label = { Text(stringResource(id = R.string.et_translation)) },
        colors = TextFieldDefaults.textFieldColors(
            Color.White,
            unfocusedLabelColor = Color.White
        )
    )
}