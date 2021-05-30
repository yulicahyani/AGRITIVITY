package com.bc0098.agritivity.ui.petani

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bc0098.agritivity.data.source.entity.PetaniEntity
import com.bc0098.agritivity.databinding.ItemsPetaniBinding
import com.bc0098.agritivity.ui.detail.petani.DetailPetaniActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PetaniAdapter: RecyclerView.Adapter<PetaniAdapter.PetaniViewHolder>() {

    private var listPetani = ArrayList<PetaniEntity>()

    fun setPetani(petani: List<PetaniEntity>?){
        if (petani == null) return
        this.listPetani.clear()
        this.listPetani.addAll(petani)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetaniViewHolder {
        val itemsPetaniBinding = ItemsPetaniBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetaniViewHolder(itemsPetaniBinding)
    }

    override fun onBindViewHolder(holder: PetaniViewHolder, position: Int) {
        val petani = listPetani[position]
        holder.bind(petani)
    }

    override fun getItemCount(): Int {
        return listPetani.size
    }

    class PetaniViewHolder(private val binding: ItemsPetaniBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(petani: PetaniEntity){
            with(binding){
                Glide.with(itemView.context)
                        .load(petani.foto)
                        .apply(RequestOptions().override(350, 350))
                        .into(petaniFoto)

                petaniNama.text = petani.nama
                petaniDomisili.text = petani.domisili
                petaniStatus.text = petani.status

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailPetaniActivity::class.java)
                    intent.putExtra(DetailPetaniActivity.EXTRA_ID, petani.id)
                    it.context.startActivity(intent)
                }
            }
        }

    }

}