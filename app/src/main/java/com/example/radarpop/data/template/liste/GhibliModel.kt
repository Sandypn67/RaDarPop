package com.example.radarpop.data.template.liste

sealed class BookModel
//maitrise l'héritage

data class PokemonSuccess(val bookList : List<Ghibli>) : BookModel()
object BookLoader : BookModel()
object BookError : BookModel()