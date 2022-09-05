package com.example.gma.ui.account

import android.R
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.gma.databinding.FragmentAccountBinding
import java.io.File


private const val ACTIVITY = "ACCOUNT"

private const val GALLERY_REQUEST = 1
const val APP_PREFERENCES_Path = "Nickname"
var profile: SharedPreferences? = null

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

        //opening gallery to choose an image
        binding.imageButton3.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }




        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.profilePic.setImageURI(imageUri)
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



}