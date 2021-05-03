package com.example.myfirsapp.presentation.viewmodels



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirsapp.domain.SignInUseCaseImpl
import com.example.myfirsapp.models.SignInResult
import com.example.myfirsapp.models.SignInState
import com.example.myfirsapp.utils.SingleLiveEvent
import io.reactivex.schedulers.Schedulers

class SignInViewModel: ViewModel(){

    private val signInUseCase =  SignInUseCaseImpl()

    private val _signInStateLiveData: MutableLiveData<SignInState> = MutableLiveData(SignInState.Idle)
    val signInStateLiveData: LiveData<SignInState> = _signInStateLiveData

    private val _signInResultLiveEvent: SingleLiveEvent<SignInResult> = SingleLiveEvent()
    val signInResultLiveData: LiveData<SignInResult> = _signInResultLiveEvent


    fun signIn(userName: String, password: String) {

        val signIn = signInUseCase(userName,password)
            .doOnComplete{ _signInStateLiveData.postValue(SignInState.Connected)
            _signInResultLiveEvent.postValue(SignInResult.Successful)}
            .doOnError { Log.d("view","eso") }

        if(signInResultLiveData.value == SignInResult.Successful){
            Log.d("view","yepmodel")
        }else{
            Log.d("view","nopmodel")
        }

    }
}