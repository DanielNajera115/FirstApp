package com.example.myfirsapp.presentation.viewmodels



import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirsapp.domain.usecase.SignInUseCase
import com.example.myfirsapp.domain.usecase.SignInUseCaseImpl
import com.example.myfirsapp.models.SignInResult
import com.example.myfirsapp.models.SignInState
import com.example.myfirsapp.utils.SingleLiveEvent
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SignInViewModel @ViewModelInject constructor(
    private val signInUseCase :  SignInUseCase
) : ViewModel() {



    private val _signInStateLiveData: MutableLiveData<SignInState> = MutableLiveData(SignInState.Idle)
    val signInStateLiveData: LiveData<SignInState> = _signInStateLiveData

    private val _signInResultLiveEvent: SingleLiveEvent<SignInResult> = SingleLiveEvent()
    val signInResultLiveData: LiveData<SignInResult> = _signInResultLiveEvent


    fun signIn(userName: String, password: String) {

        val signIn = signInUseCase(userName,password)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    _signInStateLiveData.postValue(SignInState.Connecting) }
            .doOnComplete{
                _signInStateLiveData.postValue(SignInState.Connected)
                _signInResultLiveEvent.postValue(SignInResult.Successful)}
            .doOnError {
                _signInStateLiveData.postValue(SignInState.Idle)
                _signInResultLiveEvent.postValue(SignInResult.Error)
            }
                .subscribe()
    }
}