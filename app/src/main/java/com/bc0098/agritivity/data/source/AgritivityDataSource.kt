package com.bc0098.agritivity.data.source

import androidx.lifecycle.LiveData
import com.bc0098.agritivity.data.source.entity.BeritaEntity
import com.bc0098.agritivity.data.source.entity.PanduanEntity

interface AgritivityDataSource {

    fun getBerita(): LiveData<List<BeritaEntity>>
    fun geVideoResult(q: String): LiveData<List<PanduanEntity>>
}