package com.bc0098.agritivity.ui.detail.petani

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bc0098.agritivity.R
import com.bc0098.agritivity.data.source.entity.PetaniEntity
import com.bc0098.agritivity.databinding.ActivityDetailPetaniBinding
import com.bc0098.agritivity.databinding.ContentDetailPetaniBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_petani.*
import kotlinx.android.synthetic.main.items_petani.*

class DetailPetaniActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID= "extra_id"
    }

    private lateinit var activityDetailPetaniBinding: ActivityDetailPetaniBinding
    private lateinit var detailPetaniViewModel: DetailPetaniViewModel
    private lateinit var contentDetailPetaniBinding: ContentDetailPetaniBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailPetaniBinding = ActivityDetailPetaniBinding.inflate(layoutInflater)
        setContentView(activityDetailPetaniBinding.root)
       contentDetailPetaniBinding = activityDetailPetaniBinding.contentDetailPetani


        setSupportActionBar(activityDetailPetaniBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val petaniId = intent.getIntExtra(EXTRA_ID, 0)

        detailPetaniViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailPetaniViewModel::class.java]
        detailPetaniViewModel.setSelectedPetani(petaniId)

        val detailPetani = detailPetaniViewModel.getDetailPetani()
        setDetailPetani(detailPetani)

        fabChat.setOnClickListener {
            if (isWhatsAppInstalled()){
                val waIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+detailPetani.noTelp+"&text="+"hai"))
                startActivity(waIntent)
            }
            else{
                Toast.makeText(this, "Anda harus install WhatsApp terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun isWhatsAppInstalled(): Boolean{
        var isInstallled: Boolean

        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            isInstallled = true
        }catch (e: PackageManager.NameNotFoundException){
            isInstallled = false
        }

        return isInstallled
    }

    private fun setDetailPetani(detailPetani: PetaniEntity) {
            with(contentDetailPetaniBinding){
                Glide.with(this@DetailPetaniActivity)
                    .load(detailPetani.foto)
                    .apply(RequestOptions().override(350, 350))
                    .into(fotoPetani)

                namaPetani.text = detailPetani.nama
                status.text = StringBuilder("Status : ${detailPetani.status}")
                domisili.text = StringBuilder("Domisili : ${detailPetani.domisili}")
                keahlian.text = StringBuilder("Keahlian : ${detailPetani.keahlian}")
                pengalaman.text = StringBuilder("Pengalaman Kerja : ${detailPetani.pengalamanKerja}")
                keterangan.text = detailPetani.keterangan
                noTelp.text = StringBuilder("No Telp : ${detailPetani.noTelp}")
            }
    }
}