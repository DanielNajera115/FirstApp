package com.example.myfirsapp.models

sealed class SignInResult{
    object Successful : SignInResult()
    object Error : SignInResult()
}
