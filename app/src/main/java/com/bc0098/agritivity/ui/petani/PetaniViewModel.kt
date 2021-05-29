package com.bc0098.agritivity.ui.petani

import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.PetaniEntity
import com.bc0098.agritivity.utils.DataDummy

class PetaniViewModel: ViewModel() {
    fun getDaftarPetani(): List<PetaniEntity> = DataDummy.generateDummyPetani()
}