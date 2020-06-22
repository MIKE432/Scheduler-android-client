package com.example.scheduler_android_client.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduler_android_client.R
import com.example.scheduler_android_client.main.model.StartButtonModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.start_button.*
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment(R.layout.start_fragment) {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
       var data = arrayOf(
           StartButtonModel(
               {
                   findNavController().navigate(R.id.action_startFragment_to_shoppingFragment)
               },
               R.drawable.shopping_button_image,
               R.string.shopping
           ), StartButtonModel(
               {
                   findNavController().navigate(R.id.action_startFragment_to_moviesFragment)
               },
               R.drawable.movies_button_image,
               R.string.movies
           ), StartButtonModel(
               {
                   findNavController().navigate(R.id.action_startFragment_to_notificationsFragment)
               },
               R.drawable.notifications_button_image,
               R.string.notifications
           ), StartButtonModel(
               {
                   findNavController().navigate(R.id.action_startFragment_to_notesFragment)
               },
               R.drawable.notes_button_image,
               R.string.notes
           )
       )

       viewManager = LinearLayoutManager(context)
       viewAdapter =
           SingleButtonsViewAdapter(
               data
           )

       start_fragment_recycleview.apply {
           adapter = viewAdapter
           layoutManager = viewManager

       }
    }
}

class SingleButtonsViewAdapter(private val buttons: Array<StartButtonModel>): RecyclerView.Adapter<SingleButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleButtonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.start_button, parent, false)

        return SingleButtonViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return buttons.size
    }

    override fun onBindViewHolder(holder: SingleButtonViewHolder, position: Int) {
        holder.bind(buttons[position])
    }

}

class SingleButtonViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(button: StartButtonModel) {
        start_fragment_button.setOnClickListener(button.onClick)
        start_fragment_button.setBackgroundResource(button.background)
        start_fragment_button.setText(button.text)
    }
}