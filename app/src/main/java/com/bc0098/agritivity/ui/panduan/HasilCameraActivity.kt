package com.bc0098.agritivity.ui.panduan

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bc0098.agritivity.api.CloudFunctionApiConfig
import com.bc0098.agritivity.data.source.remote.response.PredictResponse
import com.bc0098.agritivity.databinding.ActivityHasilCameraBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HasilCameraActivity : AppCompatActivity() {

    companion object{
        const val IMAGE_URI = "image_uri"
        const val REQUEST_URL = "https://us-central1-agritivity.cloudfunctions.net/predict"
    }

    private var imageUri: Uri? = null
    private var storage: FirebaseStorage? = null
    private var storageReference: StorageReference? = null

    private lateinit var hasil: String

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

        activityHasilCameraBinding.uploadBtnHasil.setOnClickListener {
            callCloudFunction()

        }

    }

    private fun callCloudFunction(){

        CloudFunctionApiConfig.getApiService().getResult().enqueue(object : Callback<PredictResponse>{
            override fun onResponse(call: Call<PredictResponse>, response: Response<PredictResponse>, ) {
                if (response.isSuccessful){
                    response.body()?.let { showResponse(it.prediction) }
                    Log.i(TAG, "post submitted to API." + response.body().toString())
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                Log.e(TAG, "Unable to submit post to API.")
            }

        })
    }

    private fun showResponse(response: String) {
        val intent = Intent(this, PanduanActivity::class.java)
        intent.putExtra(PanduanActivity.HASIL_PREDIKSI, response)
        startActivity(intent)
    }



    private fun uploadImage() {
        if (imageUri != null){
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading....")
            progressDialog.show()


            val imageRef = storageReference!!.child("images/" + "photo-predict")
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
                    progressDialog.setMessage("Upload" + progress.toInt() + "%...")
                }
        }
    }
}

//    private fun callCloudfunction(){
//
//        val client = OkHttpClient.Builder()
//            .connectTimeout(30 , TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .build()
//
//        val jsonObject = JSONObject()
//        jsonObject.put("image_url", "https://storage.googleapis.com/agritivity.appspot.com/images/photo-predict")
//
//        val body = jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
//
//        val request: Request = Request.Builder()
//            .url(REQUEST_URL)
//            .post(body)
//            .build()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                    if (!response.isSuccessful){
//                        throw IOException("Unexpected code $response")
//                    }else{
////
////                        for ((name, value) in response.headers) {
////                            println("$name: $value")
////                        }
//
//                        println(response.body!!.string())
////                        hasil = response.body!!.toString()
////                        activityHasilCameraBinding.hasilPrediksi.text = response.body!!.string()
//
//
//                        lifecycleScope.launch(Dispatchers.Default){
//                            delay(2000)
//                            withContext(Dispatchers.Main) {
//                                activityHasilCameraBinding.hasilPrediksi.text = response.body!!.toString()
//                            }
//                        }
////
////                        Handler(Looper.getMainLooper()).postDelayed({
////                            val intent = Intent(applicationContext, PanduanActivity::class.java)
////                            intent.putExtra(PanduanActivity.HASIL_PREDIKSI, response.body!!.string())
////                            startActivity(intent)
////                            finish()
////                        }, 2000)
//                    }
//            }
//
//        })
//
//    }