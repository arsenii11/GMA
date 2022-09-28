package com.example.gma.ui.account

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.gma.databinding.FragmentAccountBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

private var imageUri: Uri? = null


private const val ACTIVITY = "ACCOUNT"

private const val GALLERY_REQUEST = 1
const val APP_PREFERENCES_Path = "Nickname"
var profile: SharedPreferences? = null
private val PICK_IMAGE_REQUEST = 1
var FilePath = ""

class AccountsFragment : Fragment() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(AccountsViewModel::class.java)

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //Setting a profile picture
        setProfileImage()


        //opening gallery to choose an image
        binding.editPhoto.setOnClickListener { v ->
            if (activity?.checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE)  !== PackageManager.PERMISSION_GRANTED &&
                activity?.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)  !== PackageManager.PERMISSION_GRANTED
            ) {
                val permissions = arrayOf<String>(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                activity?.let { ActivityCompat.requestPermissions(it, permissions, 1) }
            }
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_IMAGE_REQUEST)
        }




        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            imageUri = data?.data
            binding.profilePic.setImageURI(imageUri)

            try {


            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(activity?.getContentResolver(), Uri.parse(
                imageUri.toString()
            ))


            var file: File? = null
                file = File(Environment.getExternalStorageDirectory().toString() + File.separator + "ProfilePhoto")
                file.createNewFile()

                    // Compress the bitmap and save in jpg format
                    val stream: OutputStream = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
                    stream.flush()
                    stream.close()
                FilePath = file.getPath()
                profile = activity?.getSharedPreferences(APP_PREFERENCES_Path, Context.MODE_PRIVATE)
                val editor = profile!!.edit()
                editor.putString("key1", FilePath).apply()



            }

            catch (e: IOException) {
                e.printStackTrace()
            }



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



   fun setProfileImage() {
        val accountPhoto= activity?.getSharedPreferences(APP_PREFERENCES_Path, Context.MODE_PRIVATE)
       if (accountPhoto != null) {
           FilePath = accountPhoto.getString("key1", "").toString()
       }
        val Photo = File(FilePath)
        if (Photo.exists()) {
            try {
                Glide.with(this).load(Photo)
                    .signature(ObjectKey(System.currentTimeMillis().toString())).into(binding.profilePic)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

   fun fileFromBitmap(): AsyncTask<Void, Integer, String> {
       var context: Context
       var bitmap: Bitmap
       var fileNameToSave: String



       return TODO("Provide the return value")
   }
}