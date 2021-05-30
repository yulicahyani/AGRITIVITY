package com.bc0098.agritivity.ui.berita

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bc0098.agritivity.data.source.entity.BeritaEntity
import com.bc0098.agritivity.databinding.ItemsBeritaBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BeritaAdapter: RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    private var listBerita = ArrayList<BeritaEntity>()

    fun setBerita(berita: List<BeritaEntity>?){
        if (berita == null) return
        this.listBerita.clear()
        this.listBerita.addAll(berita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val itemsBeritaBinding = ItemsBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BeritaViewHolder(itemsBeritaBinding)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = listBerita[position]
        holder.bind(berita)
    }

    override fun getItemCount(): Int {
       return listBerita.size
    }

    class BeritaViewHolder(private val binding: ItemsBeritaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(berita: BeritaEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(berita.image)
                    .apply(RequestOptions().override(350, 350))
                    .into(imgBerita)

                judulBerita.text = berita.title
                waktuBerita.text = berita.waktu
                deskripsiBerita.text = berita.description
            }
        }
    }

}