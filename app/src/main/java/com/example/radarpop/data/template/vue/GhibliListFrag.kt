package com.example.radarpop.data.template.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radarpop.R
import com.example.radarpop.data.template.controleur.GhibliAdapter

class GhibliListFrag : Fragment() {

    //Déclaration des variables de la page de liste de films
    private lateinit var recyclerView: RecyclerView
    private lateinit var loader : ProgressBar
    private lateinit var error_gen : TextView

    private val adapter = GhibliAdapter(listOf(), ::onClickedGhibli)
    private val viewModel: GhibliListViewModel by activityViewModels()


    //methode pour faire du cache mais pas utilisée ici
    //private val sharedPref : SharedPreferences? = activity?.getSharedPreferences("app", Context.MODE_PRIVATE)

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ghibli_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.ghibli_recyclerview)
        loader = view.findViewById(R.id.ghibli_loader)
        error_gen = view.findViewById(R.id.ghibli_error)
        recyclerView.apply {
            layoutManager = this@GhibliListFrag.layoutManager
            adapter =this@GhibliListFrag.adapter
        }
        //renvoit un visuel différent en fonction de ce qu'il récupère de l'api
        viewModel.filmList.observe(viewLifecycleOwner, Observer { filmModel ->
            //un loader est visible si l'app a du mal à télécharger les données
            loader.isVisible = filmModel is FilmLoader
            // affiche un message d'erreur si l'app ne peut récuperer les données de l'api
            error_gen.isVisible = filmModel is FilmError
            //affiche la liste actualisée lorsqu'il recupère l'api
            if(filmModel is FilmSuccess) {
                adapter.updateList(filmModel.filmList)
            }

        })

        //implementation des boutons de la bottom bar
/*
        view.findViewById<Button>(R.id.infos).setOnClickListener {
            findNavController().navigate(R.id.navigateToOptionFragment)
        }
        view.findViewById<Button>(R.id.favourite).setOnClickListener {
            findNavController().navigate(R.id.navigateToFavFragment)
        }

 */
    }

    //en fonction de la cellule clickée, on ne va pas sur la même page de détail (seule change la description affichée)
    private fun onClickedGhibli(id: Int) {
        findNavController().navigate(R.id.navigateToBookDetailFragment, bundleOf("pokemonId" to (id+1)))
    }
}