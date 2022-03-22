package com.bellukstudio.learn_mvvm.network

data class RecycleList(
    val items : List<DataGithub>
)

data class DataGithub(
    val name: String,
    val description : String,
    val owner: Owner
)
data class Owner(
    val avatar_url : String,

)
