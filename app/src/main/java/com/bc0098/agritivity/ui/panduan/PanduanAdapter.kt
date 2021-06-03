package com.bc0098.agritivity.ui.panduan

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bc0098.agritivity.data.source.entity.PanduanEntity
import com.bc0098.agritivity.databinding.ItemsPanduanBinding
import com.bc0098.agritivity.ui.detail.petani.DetailPetaniActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PanduanAdapter: RecyclerView.Adapter<PanduanAdapter.PanduanViewHolder>()  {

    private var listPanduan = ArrayList<PanduanEntity>()

    fun setPanduan(panduan: List<PanduanEntity>?){
        if (panduan == null) return
        this.listPanduan.clear()
        this.listPanduan.addAll(panduan)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanduanViewHolder {
        val itemsPanduanBinding = ItemsPanduanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PanduanViewHolder(itemsPanduanBinding)
    }

    override fun onBindViewHolder(holder: PanduanViewHolder, position: Int) {
        val panduan = listPanduan[position]
        holder.bind(panduan)
    }

    override fun getItemCount(): Int {
       return listPanduan.size
    }

    class PanduanViewHolder(private val binding: ItemsPanduanBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(panduan: PanduanEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(panduan.snippet.thumbnails.medium.url)
                    .apply(RequestOptions().override(350, 350))
                    .into(thumbnail)

                judulVideo.text = panduan.snippet.title
                channelTgl.text = StringBuilder("${panduan.snippet.channelTitle} - ${panduan.snippet.publishedAt}")

                val videoUrl = "https://youtu.be/${panduan.id.videoId}"

                itemView.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=${panduan.id.videoId}"))
                    it.context.startActivity(intent)
                }
            }
        }
    }

}