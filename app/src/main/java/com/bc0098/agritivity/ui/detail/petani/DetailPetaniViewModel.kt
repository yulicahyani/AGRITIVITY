package com.bc0098.agritivity.ui.detail.petani

import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.PetaniEntity
import com.bc0098.agritivity.utils.DataDummy

class DetailPetaniViewModel : ViewModel(){

    private var petaniId: Int = 0

    fun setSelectedPetani(petaniId: Int){
        this.petaniId = petaniId
    }

    fun getDetailPetani(): PetaniEntity{
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