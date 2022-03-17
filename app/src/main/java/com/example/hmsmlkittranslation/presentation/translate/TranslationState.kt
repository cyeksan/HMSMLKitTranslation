package com.example.hmsmlkittranslation.presentation.translate

sealed class TranslationState {
    object BeforeTranslation: TranslationState()
    object TranslationLoading: TranslationState()
    class TranslationSuccess(val translationResult: String): TranslationState()
    class TranslationFail(val errorMessage: String): TranslationState()
}