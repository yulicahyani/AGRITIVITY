package com.bc0098.agritivity.ui.berita

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bc0098.agritivity.data.source.AgritivityRepository
import com.bc0098.agritivity.data.source.entity.BeritaEntity

class BeritaViewModel(private val agritivityRepository: AgritivityRepository): ViewModel() {

    fun getBerita(): LiveData<List<BeritaEntity>> = agritivityRepository.getBerita()
}