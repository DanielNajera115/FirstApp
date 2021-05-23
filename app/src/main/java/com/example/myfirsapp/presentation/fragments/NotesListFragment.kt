package com.example.myfirsapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirsapp.R
import com.example.myfirsapp.data.database.entity.MyPosts
import com.example.myfirsapp.presentation.viewmodels.RedditPostingViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesListFragment : Fragment() {

    val redditPostsViewModel : RedditPostingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle = view?.findViewById<TextView>(R.id.tvTitle)
        val tvComment = view?.findViewById<TextView>(R.id.tvComment)
        val tvStar = view?.findViewById<TextView>(R.id.tvStar)
        val btnEnter = view?.findViewById<Button>(R.id.btnEnter)

        btnEnter?.setOnClickListener {
            val myPost = MyPosts(0,tvTitle?.text.toString(),Integer.parseInt(tvComment?.text.toString()),tvStar?.text.toString())
            redditPostsViewModel.insert(myPost)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }
}