package com.route.islamiapp.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.HeroCarouselStrategy
import com.route.islamiapp.databinding.FragmentHadithBinding
import com.route.islamiapp.home.adapters.HadethAdapter
import com.route.islamiapp.model.Hadeth

class HadithFragment : Fragment() {
    private lateinit var binding: FragmentHadithBinding
    lateinit var adapter: HadethAdapter
    lateinit var layoutManager: CarouselLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadithBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager =
            CarouselLayoutManager(HeroCarouselStrategy(), CarouselLayoutManager.HORIZONTAL)
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER

        adapter = HadethAdapter(readHadethFile())
        binding.hadethListRecyclerView.adapter = adapter
        binding.hadethListRecyclerView.layoutManager = layoutManager
    }

    private fun readHadethFile(): List<Hadeth> {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethList = fileContent.trim().split("#")
        return hadethList.map { hadethContent ->
            val singleHadethContent = hadethContent.trim().split("\n")
            val title = singleHadethContent[0]
            val description =
                singleHadethContent.subList(1, singleHadethContent.size).joinToString()
            Hadeth(title,description)
        }
    }
}