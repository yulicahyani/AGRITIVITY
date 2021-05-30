package com.bc0098.agritivity.ui.pekerjaan

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bc0098.agritivity.data.PekerjaanEntity
import com.bc0098.agritivity.data.PetaniEntity
import com.bc0098.agritivity.databinding.ItemsPekerjaanBinding
import com.bc0098.agritivity.ui.detail.pekerjaan.DetailPekerjaanActivity
import com.bc0098.agritivity.utils.DataDummy
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PekerjaanAdapter() : RecyclerView.Adapter<PekerjaanAdapter.PekerjaanViewHolder>() {

    private var listPekerjaan = ArrayList<PekerjaanEntity>()

    fun setPekerjaan(pekerjaan: List<PekerjaanEntity>?){
        if (pekerjaan == null) return
        this.listPekerjaan.clear()
        this.listPekerjaan.addAll(pekerjaan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): PekerjaanViewHolder {
        val itemsPekerjaanBinding = ItemsPekerjaanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PekerjaanViewHolder(itemsPekerjaanBinding)
    }

    override fun onBindViewHolder(holder: PekerjaanViewHolder, position: Int) {
        val pekerjaan = listPekerjaan[position]
        holder.bind(pekerjaan)
    }

    override fun getItemCount(): Int {
        return listPekerjaan.size
    }

    class PekerjaanViewHolder(private val binding: ItemsPekerjaanBinding): RecyclerView.ViewHolder(binding.root) {

        fun getDetailPetani(petaniId: Int): PetaniEntity {
            lateinit var petani: PetaniEntity
            val petaniList = DataDummy.generateDummyPetani()
            for (p in petaniList){
                if(p.id == petaniId){
                    petani = p
                }
            }

            return petani
        }


        fun bind(pekerjaan: PekerjaanEntity){

            val pemilikLahan: PetaniEntity = getDetailPetani(pekerjaan.idPetani)

            with(binding){
                Glide.with(itemView.context)
                    .load(pekerjaan.fotoLahan)
                    .apply(RequestOptions().override(350, 350))
                    .into(fotoLahan)

                Glide.with(itemView.context)
                    .load(pemilikLahan.foto)
                    .apply(RequestOptions().override(350, 350))
                    .into(fotoPetani)

                namaPetani.text = pemilikLahan.nama
                lokasiPekerjaan.text = pekerjaan.lokasi
                keterangan.text = pekerjaan.keterangan

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailPekerjaanActivity::class.java)
                    intent.putExtra(DetailPekerjaanActivity.EXTRA_ID, pekerjaan.id)
                    it.context.startActivity(intent)
                }
            }
        }
    }

}