package com.nayab.bottomnavigation

import VideoAdapter
import VideoModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayab.bottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = binding.videoRecycler
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val videos = listOf(

            // -------------------------
            // ⭐ ENTERTAINMENT
            // -------------------------
            VideoModel(
                title = "Oggy – Funniest Episode Ever",
                videoRes = R.raw.oogy,
                thumbnailRes = R.drawable.oogy_thumb
            ),
            VideoModel(
                title = "Department Of Software Engineering",
                videoRes = R.raw.tiktok_2,
                thumbnailRes = R.drawable.tiktok_2_thumb
            ),
            VideoModel(
                title = "Motivation Boost – Inspirational Track",
                videoRes = R.raw.motivation,
                thumbnailRes = R.drawable.motivation_thumb
            ),
            VideoModel(
                title = "A beautiful Maxi ",
                videoRes = R.raw.tiktok,
                thumbnailRes = R.drawable.tiktok_thumb
            ),

            // -------------------------
            // ⭐ EDUCATION
            // -------------------------
            VideoModel(
                title = " Best Youtube Channels for Coding",
                videoRes = R.raw.education_1,
                thumbnailRes = R.drawable.edu_1_thumb
            ),
            VideoModel(
                title = "5 AI tools For Developers",
                videoRes = R.raw.education_2,
                thumbnailRes = R.drawable.edu_2_thumb
            ),
            VideoModel(
                title = "3 best AI TOOLS ",
                videoRes = R.raw.education_3,
                thumbnailRes = R.drawable.edu_3_thumb
            ),

            // -------------------------
            // ⭐ SONGS
            // -------------------------
            VideoModel(
                title = "Diljit Dosanjh – Hass Hass (HD)",
                videoRes = R.raw.diljitsong_hasshass,
                thumbnailRes = R.drawable.hass_hass_thumb
            ),
            VideoModel(
                title = "Latest Punjabi Banger – Full Song",
                videoRes = R.raw.latest,
                thumbnailRes = R.drawable.img
            ),
            VideoModel(
                title = "Midnight Vibes – Chill Song",
                videoRes = R.raw.midnight,
                thumbnailRes = R.drawable.midnight_call_thumb
            )
        )


        recycler.adapter = VideoAdapter(videos) { selectedVideo ->

            val fragment = VideoPlayerFragment().apply {
                arguments = Bundle().apply {
                    putInt("videoRes", selectedVideo.videoRes)
                    putString("title", selectedVideo.title)
                }
            }

            val container = requireActivity().findViewById<View>(R.id.video_player_container)
            container.visibility = View.VISIBLE

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.video_player_container, fragment)
                .addToBackStack("video_player")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
