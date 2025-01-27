package com.route.islamiapp.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islamiapp.R
import com.route.islamiapp.databinding.ActivityChapterDetailsBinding
import com.route.islamiapp.home.adapters.VersesAdapter
import com.route.islamiapp.model.AppConstants
import com.route.islamiapp.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    var chapter: Chapter? = null
    lateinit var adapter: VersesAdapter
    lateinit var binding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             intent.getParcelableExtra(AppConstants.CHAPTER_KEY, Chapter::class.java )
        }else{
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY)
        }
        adapter = VersesAdapter(readChapterDetailFile(chapter?.order))
        binding.verseRecyclerView.adapter = adapter
        binding.chapterTitleEnTextView.text = chapter?.titleEn
        binding.chapterTitleArTextView.text = chapter?.titleAr
        binding.backIcon.setOnClickListener{
            finish()
        }
    }

    private fun readChapterDetailFile(order: Int?): List<String> {
        val fileContent = assets.open("quran/${order}.txt").bufferedReader().use{
            it.readText()
        }

        return fileContent.split("\n").map {
            it.trim()
        }

    }
}