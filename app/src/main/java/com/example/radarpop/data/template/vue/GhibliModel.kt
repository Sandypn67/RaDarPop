package com.example.radarpop.data.template.vue

import com.example.radarpop.data.template.controleur.GhibliListResp

sealed class GhibliModel
//maitrise l'héritage

data class FilmSuccess(val filmList: List<GhibliListResp>) : GhibliModel()
object FilmLoader : GhibliModel()
object FilmError : GhibliModel()