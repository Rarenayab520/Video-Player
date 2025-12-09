package com.nayab.bottomnavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nayab.bottomnavigation.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // -------------------------------
        // CLICKABLE CARDS → OPEN VIDEOS
        // -------------------------------

        // ⭐ Trending
        binding.trendingCard.setOnClickListener {
            openVideo("https://youtu.be/K5zbQuuQixs?si=nYZWEqyJd_k6Nf-e") // Diljit
        }

        // ⭐ Music
        binding.cardMusic.setOnClickListener {
            openVideo("https://youtu.be/Dl_n2_ekfN4?si=Ugk0vj8rQjy-dHs6") // Nidnight
        }

        // ⭐ Entertainment (Replacing Gaming)
        binding.cardGaming.setOnClickListener {
            openVideo("https://www.youtube.com/watch?v=MBKgWORXkYk") // Oggy – Funniest Episode
        }

        // ⭐ Education
        binding.cardEducation.setOnClickListener {
            openVideo("https://www.youtube.com/watch?v=F9UC9DY-vIU") // Kotlin crash course
        }

        // ⭐ Recommended
        binding.recommendedCard.setOnClickListener {
            openVideo("https://youtu.be/cl0a3i2wFcc?si=sr47IvB8iGnaepwX") // Goat
        }
    }

    private fun openVideo(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
