package com.example.radarpop.data.template.liste

import com.example.radarpop.data.template.apibook.GhibliListResp

sealed class GhibliModel
//maitrise l'héritage

data class FilmSuccess(val filmList: List<GhibliListResp>) : GhibliModel()
object FilmLoader : GhibliModel()
object FilmError : GhibliModel()