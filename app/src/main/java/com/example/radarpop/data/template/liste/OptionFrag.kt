package com.example.radarpop.data.template.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.radarpop.R
import com.example.radarpop.data.template.apibook.BookDetailResp
import com.example.radarpop.data.template.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.fragment.findNavController

class  OptionFrag : Fragment() {

    private lateinit var TextViewName : TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewName = view.findViewById(R.id.title_acc)
        view.findViewById<Button>(R.id.next_page).setOnClickListener {
            findNavController().navigate(R.id.navigateToFirstPage)
        }
    }
}