package com.example.radarpop.data.template.liste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radarpop.data.template.Singleton
import com.example.radarpop.data.template.apibook.GhibliListResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GhibliListViewModel: ViewModel() {
    val filmList : MutableLiveData<GhibliModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        filmList.value = FilmLoader

        Singleton.filmApi.getGhibliList().enqueue(object : Callback<List<GhibliListResp>> {
            override fun onFailure(call: Call<List<GhibliListResp>>, t: Throwable) {
                filmList.value = FilmError
            }

            override fun onResponse(call: Call<List<GhibliListResp>>, response: Response<List<GhibliListResp>>) {
                if (response.isSuccessful && response.body() != null) {
                    val filmResponse: List<GhibliListResp> = response.body()!!
                    filmList.value = FilmSuccess(filmResponse)
                }
                else {
                    filmList.value = FilmError
                }
            }
        })
    }

}