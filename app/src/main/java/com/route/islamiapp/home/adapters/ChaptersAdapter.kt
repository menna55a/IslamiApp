package com.route.islamiapp.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamiapp.databinding.ItemChapterBinding
import com.route.islamiapp.home.adapters.callback.OnChapterClickListener
import com.route.islamiapp.model.Chapter

class ChaptersAdapter(val chapterList: List<Chapter>) :
    Adapter<ChaptersAdapter.ChapterViewHolder>(){
        var onChapterClickListener : OnChapterClickListener? = null

    // Inner Class
   inner class ChapterViewHolder(val binding: ItemChapterBinding): ViewHolder(binding.root){
        fun bind(chapter: Chapter){
            /*
            val x = 5
            "x = $x"
            // x = 5
             */
            binding.chapterOrderTextView.text = "${chapter.order}"
            binding.chapterLengthTextView.text = "${chapter.length} Verses"
            binding.chapterTitleArTextView.text = chapter.titleAr
            binding.chapterTitleEnTextView.text = chapter.titleEn

            binding.root.setOnClickListener{
                onChapterClickListener?.onChapterClick(chapter, position)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun getItemCount(): Int = chapterList.size


    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = chapterList[position]
        holder.bind(chapter)
    }
}