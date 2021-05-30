package com.bc0098.agritivity.ui.detail.pekerjaan

import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.PekerjaanEntity
import com.bc0098.agritivity.data.PetaniEntity
import com.bc0098.agritivity.utils.DataDummy

class DetailPekerjaanViewModel: ViewModel() {

    private var pekerjaanId: Int = 0

    fun setSelectedPekerjaan(pekerjaanId: Int){
        this.pekerjaanId = pekerjaanId
    }

    fun getDetailPekerjaan(): PekerjaanEntity {
        lateinit var pekerjaan: PekerjaanEntity
        val pekerjaanList = DataDummy.generateDummyPekerjaan()
        for (p in pekerjaanList){
            if(p.id == pekerjaanId){
                pekerjaan = p
            }
        }

        return pekerjaan
    }

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
}