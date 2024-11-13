package com.example.infinitelearning_arfa

object Routes {
    const val ListActivity = "list"
    const val ManageActivity = "manage"
    const val AboutActivity = "about"
    const val DetailActivity = "detail/{itemId}"

    fun createDetailRoute(itemId: Int) = "detail/$itemId"
}