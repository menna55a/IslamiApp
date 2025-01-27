package com.route.islamiapp.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.route.islamiapp.R
import com.route.islamiapp.databinding.FragmentQuranBinding
import com.route.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    lateinit var binding: FragmentSebhaBinding
    private var counter = 0
   // private val sebhaList = listOf("سبحان الله", "الحمد الله", "الله اكبر")
    lateinit var azkarList : MutableList<String>
    private var sebhaIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()

        // binding.sebhaTextFiled.text = sebhaList[sebhaList]
        binding.sebhaTextFiled.text = azkarList[sebhaIndex]
        binding.sebhaTimeTextFiled.text = counter.toString()


        // Set a click listener for the Sebha ImageView
        binding.sebhaImageView.setOnClickListener{
            rotateSebha()
            updateCounter()
        }
    }

    private fun updateCounter() {
        val rotateAnimation = RotateAnimation(
            0f,360f,    // From 0 to 360 degrees
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,  // Pivot X
            RotateAnimation.RELATIVE_TO_SELF, 0.5f   // Pivot Y
        )
        rotateAnimation.duration = 500   //Animation duration in milliseconds
        rotateAnimation.fillAfter = true
        //rotateAnimation.repeatCount = RotateAnimation.INFINITE    // Infinite rotation
        binding.sebhaImageView.startAnimation(rotateAnimation)
    }

    private fun rotateSebha() {
        if (counter < 33) {
            counter++
            binding.sebhaTimeTextFiled.text = counter.toString()
        } else {
            // Reset counter and move to the next phrase
            counter = 0
            binding.sebhaTimeTextFiled.text = counter.toString()

            sebhaIndex = (sebhaIndex + 1) % azkarList.size
            binding.sebhaTextFiled.text = azkarList[sebhaIndex]
        }
       // counter++
       // if(counter % 33 == 0){
         //   sebhaIndex = (sebhaIndex + 1) % sebhaList.size
          //  binding.sebhaTextFiled.text = sebhaList[sebhaIndex]
       // }
        //binding.sebhaTimeTextFiled.text = counter.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
       // binding = null
    }
}