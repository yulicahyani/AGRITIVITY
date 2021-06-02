package com.bc0098.agritivity.ui.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bc0098.agritivity.R
import com.bc0098.agritivity.databinding.ActivityBeritaBinding
import com.bc0098.agritivity.vm.ViewModelFactory

class BeritaActivity : AppCompatActivity() {

    private lateinit var activityBeritaBinding: ActivityBeritaBinding
    private lateinit var beritaAdapter: BeritaAdapter
    private lateinit var beritaViewModel: BeritaViewModel
    private lateinit var beritaViewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBeritaBinding = ActivityBeritaBinding.inflate(layoutInflater)
        setContentView(activityBeritaBinding.root)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = "Berita"

        beritaAdapter = BeritaAdapter()
        beritaViewModelFactory = ViewModelFactory.getInstance(this)
        beritaViewModel = ViewModelProvider(this, beritaViewModelFactory)[BeritaViewModel::class.java]

        beritaViewModel.getBerita().observe(this, {
            activityBeritaBinding.progressBar.visibility = View.GONE
            beritaAdapter.setBerita(it)
            beritaAdapter.notifyDataSetChanged()
        })

        with(activityBeritaBinding){
            rvBerita.layoutManager = LinearLayoutManager(this@BeritaActivity)
            rvBerita.setHasFixedSize(true)
            rvBerita.adapter = beritaAdapter
        }
    }
}