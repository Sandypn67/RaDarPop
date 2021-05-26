package com.example.radarpop.data.template.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.radarpop.R

class FavFrag: Fragment() {

    private lateinit var TextViewName : TextView
    private lateinit var TextViewSites: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewName = view.findViewById(R.id.sites)
        TextViewSites = view.findViewById(R.id.insta)
        view.findViewById<Button>(R.id.next_page).setOnClickListener {
            findNavController().navigate(R.id.navigateToGhibliListFragment)
        }
    }
}