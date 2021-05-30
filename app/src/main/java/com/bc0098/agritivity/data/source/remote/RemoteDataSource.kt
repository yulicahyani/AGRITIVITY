package com.bc0098.agritivity.data.source.remote

import android.util.Log
import com.bc0098.agritivity.api.NewsApiConfig
import com.bc0098.agritivity.data.source.remote.response.Berita
import com.bc0098.agritivity.data.source.remote.response.NewsResponse
import com.bc0098.agritivity.utils.IdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    fun getBerita(callback: LoadBeritaCallback){
        IdlingResource.increment()
        NewsApiConfig.getApiService().getBerita().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                response.body()?.berita.let {
                    if (it != null) {
                        callback.onAllBeritaReceived(it)
                    }
                }
                IdlingResource.decrement()
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("RemoteSource", "onFailure: ${t.message}")
            }

        })
    }

    interface LoadBeritaCallback{
        fun onAllBeritaReceived(newsResponse: List<Berita>)
    }
}