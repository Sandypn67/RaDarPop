package com.example.radarpop.data.template.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.radarpop.R
import com.example.radarpop.data.template.apibook.GhibliDetailResp
import com.example.radarpop.data.template.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.fragment.findNavController
import com.example.radarpop.data.template.apibook.GhibliListResp

class  BookDetailFrag : Fragment() {

    private lateinit var TextViewName : TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ghibli_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewName = view.findViewById(R.id.ghibli_detail_name)
        callApi()

        view.findViewById<Button>(R.id.button_retour).setOnClickListener {
            findNavController().navigate(R.id.navigateToGhibliListFragment)
        }
        view.findViewById<Button>(R.id.button_info).setOnClickListener {
            findNavController().navigate(R.id.navigatetoInfos)
        }
    }

    private fun callApi() {
        val id = arguments?.getString("bookId") ?: -1
        Singleton.filmApi.getGhibliList().enqueue(object : Callback<List<GhibliListResp>> {
            override fun onFailure(call: Call<List<GhibliListResp>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<GhibliListResp>>, response: Response<List<GhibliListResp>>) {
                if (response.isSuccessful && response.body() != null) {
                    val ghibli: List<GhibliListResp> = response.body()!!
                    TextViewName.text = response.body()!!.single().description
                    TextViewName.text = response.body()!!.single().date
                }
            }

        })
    }
}