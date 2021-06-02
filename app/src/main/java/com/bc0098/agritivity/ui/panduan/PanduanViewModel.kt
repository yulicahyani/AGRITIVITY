package com.bc0098.agritivity.ui.panduan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.source.AgritivityRepository
import com.bc0098.agritivity.data.source.entity.PanduanEntity

class PanduanViewModel(private val agritivityRepository: AgritivityRepository): ViewModel() {

    fun getVideoResult(q: String): LiveData<List<PanduanEntity>> = agritivityRepository.geVideoResult(q)
}