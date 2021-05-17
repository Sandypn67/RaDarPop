package com.example.radarpop.data.template.liste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radarpop.data.template.Singleton
import com.example.radarpop.data.template.apibook.GhibliListResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GhibliListViewModel: ViewModel() {
    val pokeList : MutableLiveData<BookModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = BookLoader

        Singleton.bookApi.getBookList().enqueue(object : Callback<GhibliListResp> {
            override fun onFailure(call: Call<GhibliListResp>, t: Throwable) {
                pokeList.value = BookError
            }

            override fun onResponse(call: Call<GhibliListResp>, response: Response<GhibliListResp>) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    pokeList.value = PokemonSuccess(pokemonResponse.results)
//                    adapter.updateList(pokemonResponse.results)
//                    saveListIntoCache()
//                    showList(pokemonResponse.results)
                }
                else {
                    pokeList.value = BookError
                }
            }
        })
    }

}