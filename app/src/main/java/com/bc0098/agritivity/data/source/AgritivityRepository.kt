package com.bc0098.agritivity.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bc0098.agritivity.data.source.entity.BeritaEntity
import com.bc0098.agritivity.data.source.remote.RemoteDataSource
import com.bc0098.agritivity.data.source.remote.response.Berita

class AgritivityRepository private constructor(private val remoteDataSource: RemoteDataSource): AgritivityDataSource{

    companion object{
        @Volatile
        private var instance : AgritivityRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): AgritivityRepository =
            instance ?: synchronized(this){
                instance ?: AgritivityRepository(remoteDataSource)
            }
    }

    override fun getBerita(): LiveData<List<BeritaEntity>> {
        val beritaResults = MutableLiveData<List<BeritaEntity>>()
        remoteDataSource.getBerita(object : RemoteDataSource.LoadBeritaCallback{
            override fun onAllBeritaReceived(newsResponse: List<Berita>) {
                val listBerita = ArrayList<BeritaEntity>()
                for (response in newsResponse){
                    val berita = BeritaEntity(
                        response.author,
                        response.title,
                        response.description,
                        response.waktu,
                        response.sumber,
                        response.image,
                        response.content
                    )

                    listBerita.add(berita)
                }

                beritaResults.postValue(listBerita)
            }

        })

        return beritaResults
    }

}