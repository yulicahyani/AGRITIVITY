package com.bc0098.agritivity.ui.detail.berita

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bc0098.agritivity.R
import com.bc0098.agritivity.data.source.remote.response.SourceResponse
import com.bc0098.agritivity.databinding.ActivityDetailBeritaBinding
import com.bc0098.agritivity.databinding.ContentDetailBeritaBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailBeritaActivity : AppCompatActivity() {

    companion object{
        const val author = "author"
        const val titles = "title"
        const val waktu = "waktu"
        const val sumber = "sumber"
        const val image = "image"
        const val contents = "content"
    }

    private lateinit var activityDetailBeritaBinding: ActivityDetailBeritaBinding
    private lateinit var contentDetailBeritaBinding: ContentDetailBeritaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBeritaBinding = ActivityDetailBeritaBinding.inflate(layoutInflater)
        setContentView(activityDetailBeritaBinding.root)
        contentDetailBeritaBinding = activityDetailBeritaBinding.contentDetailBerita
        setSupportActionBar(findViewById(R.id.toolbar))

        val author1 = intent.getStringExtra(author)
        val title1 = intent.getStringExtra(titles)
        val waktu1 = intent.getStringExtra(waktu)
        val sumber1 = intent.getStringExtra(sumber)
        val image1 = intent.getStringExtra(image)
        val contents1 = intent.getStringExtra(contents)

        with(contentDetailBeritaBinding){
            judulBerita.text = title1
            waktuBerita.text = waktu1
            Glide.with(this@DetailBeritaActivity)
                .load(image1)
                .apply(RequestOptions().override(350, 350))
                .into(imgBerita)
            sumberPenulis.text = StringBuilder("$sumber1 - $author1")
            contentBerita.text = contents1
        }

    }
}