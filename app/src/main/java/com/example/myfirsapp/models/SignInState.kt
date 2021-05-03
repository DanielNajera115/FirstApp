package com.example.myfirsapp.models

sealed class SignInState{
    object Idle : SignInState()
    object Connecting : SignInState()
    object Connected : SignInState()
}
