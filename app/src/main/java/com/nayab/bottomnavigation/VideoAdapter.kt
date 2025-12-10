import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.nayab.bottomnavigation.databinding.ItemVideoBinding

class VideoAdapter(
    private val videos: List<VideoModel>,
    private val onClick: (VideoModel) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]

        holder.binding.videoTitle.text = video.title
        holder.binding.thumbnail.setImageResource(video.thumbnailRes)  // thumbnail

        holder.binding.root.setOnClickListener {
            onClick(video)   // send clicked video
        }
    }

    override fun getItemCount() = videos.size
}
