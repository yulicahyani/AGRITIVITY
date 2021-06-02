package com.bc0098.agritivity.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bc0098.agritivity.data.source.entity.BeritaEntity
import com.bc0098.agritivity.data.source.entity.PanduanEntity
import com.bc0098.agritivity.data.source.remote.RemoteDataSource
import com.bc0098.agritivity.data.source.remote.response.Berita
import com.bc0098.agritivity.data.source.remote.response.VideoYoutube

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

    override fun geVideoResult(q: String): LiveData<List<PanduanEntity>> {
        val videoresults = MutableLiveData<List<PanduanEntity>>()
        remoteDataSource.geVideoResult(q, object : RemoteDataSource.LoadVideoResultCallback{
            override fun onAllVideoReceived(videoResponse: List<VideoYoutube>) {
                val listVideo = ArrayList<PanduanEntity>()
                for (response in videoResponse){
                    val video = PanduanEntity(
                        response.id,
                        response.snippet
                    )

                    listVideo.add(video)
                }

                videoresults.postValue(listVideo)
            }

        })

        return videoresults
    }

}