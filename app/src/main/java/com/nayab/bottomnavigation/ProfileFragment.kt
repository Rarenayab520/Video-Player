package com.nayab.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nayab.bottomnavigation.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // -----------------------------
        // SET USER DATA
        // -----------------------------
        binding.profileName.text = "Nayab Asmat"
        binding.profileEmail.text = "nayab@gmail.com"

        // -----------------------------
        // BUTTON ACTIONS
        // -----------------------------

        // Edit Profile functionality
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profile Clicked!", Toast.LENGTH_SHORT).show()
        }

        // Settings button
        binding.btnSettings.setOnClickListener {
            Toast.makeText(requireContext(), "Settings Clicked!", Toast.LENGTH_SHORT).show()
        }

        // Logout button
        binding.btnLogout.setOnClickListener {
            requireActivity().finish()  // Simple logout
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
