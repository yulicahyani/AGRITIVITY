package com.bc0098.agritivity.ui.pekerjaan

import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.PekerjaanEntity
import com.bc0098.agritivity.utils.DataDummy

class PekerjaanViewModel: ViewModel() {

    fun getDaftarPekerjaan(): List<PekerjaanEntity> = DataDummy.generateDummyPekerjaan()
}