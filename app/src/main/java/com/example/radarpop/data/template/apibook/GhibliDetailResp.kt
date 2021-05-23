package com.example.radarpop.data.template.apibook


//A retirer car ne l'utilise plus
data class GhibliDetailResp(
    val name: String,
    val types : List<GhibliSlot>
)

data class GhibliSlot(
    val slot: Int,
    val type: GhibliType
)

data class GhibliType(
    val name :String,
    val url : String
)