package com.nayab.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nayab.bottomnavigation.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // You can update or set dynamic values here if needed
        binding.aboutTitle.text = "Video Explorer App"
        binding.appVersion.text = "Version 1.0.0"
        binding.aboutDesc.text =
            "This application showcases video browsing, explore features, a user profile, and a navigation drawer with tabs — built using Kotlin and a clean UI."
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
