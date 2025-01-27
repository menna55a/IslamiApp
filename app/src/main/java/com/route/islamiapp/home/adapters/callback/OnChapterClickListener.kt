package com.route.islamiapp.home.adapters.callback

import com.route.islamiapp.model.Chapter

// interface have one fun (fun interface)
fun interface OnChapterClickListener {
    fun onChapterClick(chapter : Chapter , position: Int)
}