package com.example.myfirsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirsapp.data.models.RedditPost
import com.example.myfirsapp.presentation.adapters.RedditAdapter
import com.example.myfirsapp.presentation.fragments.NotesListFragment
import com.example.myfirsapp.presentation.fragments.RedditPostFragment
import com.example.myfirsapp.presentation.viewmodels.RedditViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RedditPostsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reddit_posts)

        val firstFragment = RedditPostFragment()
        val secondFragment =  NotesListFragment()

        setCurrentFragment(firstFragment)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.menuNotes->setCurrentFragment(secondFragment)
            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_nav_bar,fragment)
            commit()
        }

}