package com.example.scheduler_android_client.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.scheduler_android_client.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.movie_types_fragment.*
import kotlinx.android.synthetic.main.movies_fragment.*

const val MOVIE_TYPES_AMOUNT = 2
val movieTypes = bundleOf("0" to "DVD", "1" to "Blue-Ray")

class MoviesFragment: Fragment() {
    private lateinit var moviesTypesAdapter: MovieTypesAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesTypesAdapter =
            MovieTypesAdapter(this)
        viewPager = view.findViewById(R.id.movie_pager)
        viewPager.adapter = moviesTypesAdapter
        TabLayoutMediator(tab_layout, movie_pager) { tab, position ->
            tab.text = movieTypes.getString("${position}")
        }.attach()
    }
}
class MovieTypesAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return MOVIE_TYPES_AMOUNT
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = MovieTypes()

        fragment.arguments = bundleOf(
            "type" to movieTypes.getString("${position}")
            )
        return fragment
    }
}

class MovieTypes: Fragment(R.layout.movie_types_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_types_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { arg -> arg.containsKey("type") }?.apply {
            movies_fragment_text.text = getString("type")
        }

    }
}