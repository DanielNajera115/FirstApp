package com.example.myfirsapp.data

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.reactivex.Completable


class FireBaseRepository {

    private lateinit var auth: FirebaseAuth

  init {
      auth = Firebase.auth
      val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
          .requestEmail()
          .build()
  }


    fun currentUser() = auth.currentUser

    fun signInFireBase(email: String, password: String): Completable{
        var itWorks : Boolean = false

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                Log.d("hello",email)
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("FIRE", "signInWithEmail:success")
                    val user = auth.currentUser
                    itWorks = true
                }
            }
            return Completable.complete()
    }

}
