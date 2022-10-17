package com.example.gma.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gma.Documents
import com.example.gma.Groups
import com.example.gma.Study
import com.example.gma.Tasks
import com.example.gma.databinding.FragmentHomeBinding
import org.w3c.dom.Document

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.imageButtonDoc.setOnClickListener{
            val randomIntent = Intent(activity, Documents::class.java)
            startActivity(randomIntent)
        }

        binding.imageButtonGroup.setOnClickListener{
            val groupIntent = Intent(activity, Groups::class.java)
            startActivity(groupIntent)
        }

        binding.imageButtonBook.setOnClickListener{
            val studyIntent = Intent(activity, Study::class.java)
            startActivity(studyIntent)
        }


        binding.imageButtonTasks.setOnClickListener{
            val tasksIntent = Intent(activity, Tasks::class.java)
            startActivity(tasksIntent)
        }



        val root: View = binding.root

    return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}