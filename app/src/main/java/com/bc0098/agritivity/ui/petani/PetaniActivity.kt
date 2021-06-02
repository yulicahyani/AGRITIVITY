package com.bc0098.agritivity.ui.petani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bc0098.agritivity.R
import com.bc0098.agritivity.databinding.ActivityPetaniBinding

class PetaniActivity : AppCompatActivity() {

    private  lateinit var activityPetaniBinding: ActivityPetaniBinding
    private lateinit var petaniAdapter: PetaniAdapter
    private lateinit var petaniViewModel: PetaniViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPetaniBinding= ActivityPetaniBinding.inflate(layoutInflater)
        setContentView(activityPetaniBinding.root)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = "Daftar Petani"

        petaniViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[PetaniViewModel::class.java]
        val petani = petaniViewModel.getDaftarPetani()
        petaniAdapter = PetaniAdapter()
        petaniAdapter.setPetani(petani)

        with(activityPetaniBinding){
            rvPetani.layoutManager = LinearLayoutManager(this@PetaniActivity)
            rvPetani.setHasFixedSize(true)
            rvPetani.adapter = petaniAdapter
        }
    }
}