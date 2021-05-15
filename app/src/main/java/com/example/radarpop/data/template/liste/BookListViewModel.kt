package com.example.radarpop.data.template.liste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radarpop.data.template.Singleton
import com.example.radarpop.data.template.apibook.BookListResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookListViewModel: ViewModel() {
    val pokeList : MutableLiveData<BookModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = BookLoader

        Singleton.bookApi.getBookList().enqueue(object : Callback<BookListResp> {
            override fun onFailure(call: Call<BookListResp>, t: Throwable) {
                pokeList.value = BookError
            }

            override fun onResponse(call: Call<BookListResp>, response: Response<BookListResp>) {
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