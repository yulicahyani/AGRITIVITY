package com.bc0098.agritivity.ui.panduan

import android.app.ProgressDialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bc0098.agritivity.R
import com.bc0098.agritivity.databinding.ActivityHasilCameraBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class HasilCameraActivity : AppCompatActivity() {

    companion object{
        const val IMAGE_URI = "image_uri"
    }

    private var imageUri: Uri? = null
    internal var storage: FirebaseStorage? = null
    internal var storageReference: StorageReference? = null

    private lateinit var activityHasilCameraBinding: ActivityHasilCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHasilCameraBinding = ActivityHasilCameraBinding.inflate(layoutInflater)
        setContentView(activityHasilCameraBinding.root)

        val imagePath = intent.getStringExtra(IMAGE_URI)
        imageUri= Uri.parse(imagePath)
        activityHasilCameraBinding.imageCapture.setImageURI(imageUri)

        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference

        activityHasilCameraBinding.uploadBtn.setOnClickListener{
            uploadImage()
        }

    }

    private fun uploadImage() {
        if (imageUri != null){
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading....")
            progressDialog.show()

            val imageRef = storageReference!!.child("images/"+ UUID.randomUUID().toString())
            imageRef.putFile(imageUri!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "File Uploaded", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {
                    val progress = 100.0 * it.bytesTransferred/it.totalByteCount
                    progressDialog.setMessage("Upload"+progress.toInt()+"%...")
                }
        }
    }
}