package com.bc0098.agritivity.ui.detail.pekerjaan

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bc0098.agritivity.R
import com.bc0098.agritivity.data.source.entity.PekerjaanEntity
import com.bc0098.agritivity.data.source.entity.PetaniEntity
import com.bc0098.agritivity.databinding.ActivityDetailPekerjaanBinding
import com.bc0098.agritivity.databinding.ContentDetailPekerjaanBinding
import com.bc0098.agritivity.ui.detail.petani.DetailPetaniActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_petani.*
import kotlinx.android.synthetic.main.content_detail_pekerjaan.*

class DetailPekerjaanActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var activityDetailPekerjaanBinding: ActivityDetailPekerjaanBinding
    private lateinit var detailPekerjaanViewModel: DetailPekerjaanViewModel
    private lateinit var contentDetailPekerjaanBinding: ContentDetailPekerjaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailPekerjaanBinding = ActivityDetailPekerjaanBinding.inflate(layoutInflater)
        setContentView(activityDetailPekerjaanBinding.root)
        contentDetailPekerjaanBinding = activityDetailPekerjaanBinding.contentDetailPekerjaan

        setSupportActionBar(findViewById(R.id.toolbar))

        setSupportActionBar(activityDetailPekerjaanBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pekerjaanId = intent.getIntExtra(EXTRA_ID, 0)

        detailPekerjaanViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailPekerjaanViewModel::class.java]
        detailPekerjaanViewModel.setSelectedPekerjaan(pekerjaanId)

        val detailPekerjaan = detailPekerjaanViewModel.getDetailPekerjaan()
        val detailPetani = detailPekerjaanViewModel.getDetailPetani(detailPekerjaan.idPetani)
        setDetailPekerjaan(detailPekerjaan, detailPetani)

        activityDetailPekerjaanBinding.fabChat.setOnClickListener {
            if (isWhatsAppInstalled()){
                val waIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+detailPetani.noTelp+"&text="+"Halo saya ingin melamar pekerjaan"))
                startActivity(waIntent)
            }
            else{
                Toast.makeText(this, "Anda harus install WhatsApp terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        contentDetailPekerjaanBinding.fotoPemilikLahan.setOnClickListener{
            val detailPetaniIntent = Intent(it.context, DetailPetaniActivity::class.java)
            detailPetaniIntent.putExtra(DetailPetaniActivity.EXTRA_ID, detailPekerjaan.idPetani)
            startActivity(detailPetaniIntent)
        }
        contentDetailPekerjaanBinding.namaPemilikLahan.setOnClickListener{
            val detailPetaniIntent = Intent(it.context, DetailPetaniActivity::class.java)
            detailPetaniIntent.putExtra(DetailPetaniActivity.EXTRA_ID, detailPekerjaan.idPetani)
            startActivity(detailPetaniIntent)
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

    private fun setDetailPekerjaan(detailPekerjaan: PekerjaanEntity, detailPetani: PetaniEntity) {
        with(contentDetailPekerjaanBinding){
            Glide.with(this@DetailPekerjaanActivity)
                .load(detailPetani.foto)
                .apply(RequestOptions().override(350, 350))
                .into(fotoPemilikLahan)

            namaPemilikLahan.text = detailPetani.nama

            Glide.with(this@DetailPekerjaanActivity)
                .load(detailPekerjaan.fotoLahan)
                .apply(RequestOptions().override(350, 350))
                .into(fotoLahan)

            lokasiPekerjaan.text = detailPekerjaan.lokasi
            waktuPekerjaan.text = detailPekerjaan.waktu
            upahPekerjaan.text = detailPekerjaan.upah
            jmlPekerjaan.text = detailPekerjaan.jmlPekerja
            luasLahan.text = detailPekerjaan.luasLahan
            keterangan.text = detailPekerjaan.keterangan

        }
    }
}