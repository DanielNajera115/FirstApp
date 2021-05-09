package com.example.myfirsapp.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myfirsapp.R
import com.example.myfirsapp.RedditPostsActivity
import com.example.myfirsapp.data.FireBaseRepository
import com.example.myfirsapp.models.SignInResult
import com.example.myfirsapp.presentation.viewmodels.SignInViewModel

class SignInFragment : Fragment() {

    private val signInViewModel: SignInViewModel by viewModels()

    lateinit var firebase: FireBaseRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firebase = FireBaseRepository()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInViewModel.signInResultLiveData.observe(viewLifecycleOwner, Observer(this::handleSignIn))

        val btnSignIn = getView()?.findViewById<Button>(R.id.btnSignIn)
        val tvUserName = getView()?.findViewById<TextView>(R.id.tvUserName)
        val tvPassword = getView()?.findViewById<TextView>(R.id.tvPassword)

        btnSignIn?.setOnClickListener { signInViewModel.signIn(tvUserName?.text.toString(),tvPassword?.text.toString()) }

    }

    private fun handleSignIn(signInState: SignInResult){
        var intent = Intent(context, RedditPostsActivity::class.java)
        if(signInState == SignInResult.Successful){
            startActivity(intent)
        }
    }
}