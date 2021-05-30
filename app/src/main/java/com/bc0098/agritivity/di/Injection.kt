package com.bc0098.agritivity.di

import com.bc0098.agritivity.data.source.AgritivityRepository
import com.bc0098.agritivity.data.source.remote.RemoteDataSource

object Injection {

    fun provideAgritivityRepository(): AgritivityRepository{
        val remoteAgritivityRepository = RemoteDataSource.getInstance()

        return AgritivityRepository.getInstance(remoteAgritivityRepository)
    }
}