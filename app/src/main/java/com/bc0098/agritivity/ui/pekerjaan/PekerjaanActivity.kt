package com.bc0098.agritivity.ui.pekerjaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bc0098.agritivity.databinding.ActivityPekerjaanBinding

class PekerjaanActivity : AppCompatActivity() {

    private lateinit var activityPekerjaanBinding: ActivityPekerjaanBinding
    private lateinit var pekerjaanAdapter: PekerjaanAdapter
    private lateinit var pekerjaanViewModel: PekerjaanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityPekerjaanBinding = ActivityPekerjaanBinding.inflate(layoutInflater)
        setContentView(activityPekerjaanBinding.root)

        pekerjaanViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[PekerjaanViewModel::class.java]
        val pekerjaan = pekerjaanViewModel.getDaftarPekerjaan()
        pekerjaanAdapter = PekerjaanAdapter()
        pekerjaanAdapter.setPekerjaan(pekerjaan)

        with(activityPekerjaanBinding){
            rvPekerjaan.layoutManager = LinearLayoutManager(this@PekerjaanActivity)
            rvPekerjaan.setHasFixedSize(true)
            rvPekerjaan.adapter = pekerjaanAdapter
        }
    }
}