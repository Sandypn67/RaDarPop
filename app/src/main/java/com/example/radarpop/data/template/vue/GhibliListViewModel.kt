package com.example.radarpop.data.template.vue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radarpop.data.template.Singleton
import com.example.radarpop.data.template.controleur.GhibliListResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GhibliListViewModel: ViewModel() {
    val filmList : MutableLiveData<GhibliModel> = MutableLiveData()
    val listGhibli: MutableLiveData<List<GhibliListResp>> = MutableLiveData()
    init {
        callApi()
    }

    private fun callApi() {
        filmList.value = FilmLoader
        //appelle le singleton pour recuperer la liste de films récuperée de l'api et teste la réponse
        Singleton.filmApi.getGhibliList().enqueue(object : Callback<List<GhibliListResp>> {

            //s'il y a un probleme dans la réponse
            override fun onFailure(call: Call<List<GhibliListResp>>, t: Throwable) {
                filmList.value = FilmError
            }

            //si la réponse du singleton n'a pas eu de probleme lors de l'appel
            override fun onResponse(call: Call<List<GhibliListResp>>, response: Response<List<GhibliListResp>>) {
                if (response.isSuccessful && response.body() != null) {
                    val filmResponse: List<GhibliListResp> = response.body()!!
                    filmList.value = FilmSuccess(filmResponse)
                    listGhibli.value = filmResponse
                }
                else {
                    filmList.value = FilmError
                }
            }
        })
    }

    // permet de récuperer uniquement la description dans tout ce que le singleton récupere
    fun Getdes(): String {
        val descrip: String
        descrip = listGhibli.value!![0].description
        return descrip
    }

}