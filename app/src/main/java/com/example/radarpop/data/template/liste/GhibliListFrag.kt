package com.example.radarpop.data.template.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radarpop.R

class GhibliListFrag : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader : ProgressBar
    private lateinit var error_gen : TextView

    private val adapter = GhibliAdapter(listOf(), ::onClickedPokemon)
    private val viewModel: GhibliListViewModel by viewModels()


    //methode pour faire du cache mais pas utilisée ici
    //private val sharedPref : SharedPreferences? = activity?.getSharedPreferences("app", Context.MODE_PRIVATE)

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.book_recyclerview)
        loader = view.findViewById(R.id.book_loader)
        error_gen = view.findViewById(R.id.book_error)
        recyclerView.apply {
            layoutManager = this@GhibliListFrag.layoutManager
            adapter =this@GhibliListFrag.adapter
        }
        viewModel.pokeList.observe(viewLifecycleOwner, Observer { bookModel ->
            loader.isVisible = bookModel is BookLoader
            error_gen.isVisible = bookModel is BookError
            if(bookModel is PokemonSuccess) {
                adapter.updateList(bookModel.bookList)
            }

        })

    }

    private fun showList(pokeList: List<Ghibli>) {
        adapter.updateList(pokeList)
    }
    private fun onClickedPokemon(id: Int) {
        findNavController().navigate(R.id.navigateToBookDetailFragment, bundleOf("pokemonId" to (id+1)))
    }
}