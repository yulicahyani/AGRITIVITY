package com.bc0098.agritivity.ui.panduan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bc0098.agritivity.MainActivity
import com.bc0098.agritivity.vm.ViewModelFactory
import com.bc0098.agritivity.databinding.ActivityPanduanBinding

class PanduanActivity : AppCompatActivity() {

    companion object{
        const val HASIL_PREDIKSI = "hasil_prediksi"
    }

    private lateinit var activityPanduanBinding: ActivityPanduanBinding
    private lateinit var panduanAdapter: PanduanAdapter
    private lateinit var panduanViewModel: PanduanViewModel
    private lateinit var panduanViewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityPanduanBinding = ActivityPanduanBinding.inflate(layoutInflater)
        setContentView(activityPanduanBinding.root)

        activityPanduanBinding.cameraBtn.setOnClickListener{
            val moveIntent = Intent(it.context, CameraActivity::class.java)
            startActivity(moveIntent)
        }

        val hasil = intent.getStringExtra(HASIL_PREDIKSI)
        activityPanduanBinding.resultPredict.text = hasil

//        val keyword = "panduan bertani"

        val keyword = hasil

        panduanAdapter = PanduanAdapter()
        panduanViewModelFactory = ViewModelFactory.getInstance(this)
        panduanViewModel = ViewModelProvider(this, panduanViewModelFactory)[PanduanViewModel::class.java]

        activityPanduanBinding.searchBtn.setOnClickListener {
            activityPanduanBinding.progressBar.visibility = View.VISIBLE
            if (keyword != null) {
                panduanViewModel.getVideoResult(keyword).observe(this, {
                    activityPanduanBinding.progressBar.visibility = View.GONE
                    panduanAdapter.setPanduan(it)
                    panduanAdapter.notifyDataSetChanged()
                })
            }
        }

        with(activityPanduanBinding ){
            rvPanduan.layoutManager = LinearLayoutManager(this@PanduanActivity)
            rvPanduan.setHasFixedSize(true)
            rvPanduan.adapter = panduanAdapter
        }

        onBackPressed()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}