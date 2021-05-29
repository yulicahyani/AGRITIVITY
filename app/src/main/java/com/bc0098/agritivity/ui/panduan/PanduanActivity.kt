package com.bc0098.agritivity.ui.panduan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bc0098.agritivity.databinding.ActivityPanduanBinding

class PanduanActivity : AppCompatActivity() {

    private lateinit var activityPanduanBinding: ActivityPanduanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityPanduanBinding = ActivityPanduanBinding.inflate(layoutInflater)
        setContentView(activityPanduanBinding.root)

        activityPanduanBinding.cameraBtn.setOnClickListener{
            val moveIntent = Intent(it.context, CameraActivity::class.java)
            startActivity(moveIntent)
        }
    }

}