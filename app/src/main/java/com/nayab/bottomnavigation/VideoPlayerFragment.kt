package com.nayab.bottomnavigation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.nayab.bottomnavigation.databinding.FragmentVideoPlayerBinding

class VideoPlayerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val videoView = view.findViewById<VideoView>(R.id.videoView)
        val title = view.findViewById<TextView>(R.id.videoTitle)

        val videoRes = requireArguments().getInt("videoRes")
        title.text = requireArguments().getString("title")

        val uri = Uri.parse("android.resource://${requireContext().packageName}/$videoRes")
        videoView.setVideoURI(uri)

        videoView.setOnPreparedListener { it.start() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Hide player container when closed
        requireActivity().findViewById<View>(R.id.video_player_container).visibility = View.GONE
    }
}
