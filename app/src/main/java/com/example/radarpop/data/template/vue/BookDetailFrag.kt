package com.example.radarpop.data.template.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.radarpop.R
import androidx.navigation.fragment.findNavController

class  BookDetailFrag : Fragment() {

    //Variables utilisées dans le fragment du détail du films
    val filmList : MutableLiveData<GhibliModel> = MutableLiveData()
    private lateinit var TextViewName : TextView
    //private lateinit var loader : ProgressBar
    //private lateinit var error_gen : TextView

    private val viewModel: GhibliListViewModel by activityViewModels()

    override fun onCreateView(
            //on crée la vue liée au fragment
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ghibli_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewName = view.findViewById(R.id.ghibli_detail_name)
        //loader = view.findViewById(R.id.ghibli_loader)
        //error_gen = view.findViewById(R.id.ghibli_error)

        //on instancie les boutons contenus dans le layout
        view.findViewById<Button>(R.id.button_retour).setOnClickListener {
            findNavController().navigate(R.id.navigateToGhibliListFragment)
        }
        view.findViewById<Button>(R.id.button_info).setOnClickListener {
            findNavController().navigate(R.id.navigatetoInfos)
        }

        //on observe la liste de film que l'on a déjà récupéré avec le singleton pour ne récuperer ici que la description
        viewModel.filmList.observe(viewLifecycleOwner, Observer { filmModel ->
        })
        TextViewName.text = viewModel.Getdes()
    }

   /* private fun callApi() {
        filmList.value = FilmLoader
        Singleton.filmApi.getGhibliList().enqueue(object : Callback<List<GhibliListResp>> {
            override fun onFailure(call: Call<List<GhibliListResp>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<GhibliListResp>>, response: Response<List<GhibliListResp>>) {
                if (response.isSuccessful && response.body() != null) {
                    val filmResponse: List<GhibliListResp> = response.body()!!
                    //filmList.value = FilmSuccess(filmResponse.toString())
                    //TextViewName.text = response.body()!!.toString().slice(53..403)
                }
                /*else {
                    filmList.value = FilmError
                }*/
            }

        })
    }*/
}