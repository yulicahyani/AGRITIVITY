package com.bc0098.agritivity.data.source

import androidx.lifecycle.LiveData
import com.bc0098.agritivity.data.source.entity.BeritaEntity

interface AgritivityDataSource {

    fun getBerita(): LiveData<List<BeritaEntity>>
}