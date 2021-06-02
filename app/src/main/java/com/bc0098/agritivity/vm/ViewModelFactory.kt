package com.bc0098.agritivity.vm

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bc0098.agritivity.data.source.AgritivityRepository
import com.bc0098.agritivity.di.Injection
import com.bc0098.agritivity.ui.berita.BeritaViewModel
import com.bc0098.agritivity.ui.panduan.PanduanViewModel

class ViewModelFactory private constructor(private val mAgritivityRepository: AgritivityRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(requireActivity: AppCompatActivity): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideAgritivityRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(BeritaViewModel::class.java) -> {
                BeritaViewModel(mAgritivityRepository) as T
            }

            modelClass.isAssignableFrom(PanduanViewModel::class.java) -> {
                PanduanViewModel(mAgritivityRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}