package com.example.gma

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gma.presentation.MainActivity
import com.example.gma.utils.bindView
import com.nikhilpanju.fabfilter.main.MainListAdapter


var animationPlaybackSpeed: Double = 0.8

class Tasks : AppCompatActivity() {


        private val recyclerView: RecyclerView by bindView(R.id.recycler_view)
        // layout/nav_drawer views

        private lateinit var mainListAdapter: MainListAdapter
        private val loadingDuration: Long
            get() = (resources.getInteger(R.integer.loadingAnimDuration) / animationPlaybackSpeed).toLong()

        /**
         * Used to open nav drawer when opening app for first time (to show options)
         */
        private val prefs: SharedPreferences
            get() = getSharedPreferences("FabFilter", Context.MODE_PRIVATE)
        private var isFirstTime: Boolean
            get() = prefs.getBoolean("isFirstTime", true)
            set(value) = prefs.edit { putBoolean("isFirstTime", value) }
        /**
         * Used by FiltersLayout since we don't want to expose mainListAdapter (why?)
         * (Option: Combine everything into one activity if & when necessary)
         */
        var isAdapterFiltered: Boolean
            get() = mainListAdapter.isFiltered
            set(value) {
                mainListAdapter.isFiltered = value
            }

        ///////////////////////////////////////////////////////////////////////////
        // Methods
        ///////////////////////////////////////////////////////////////////////////

        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_tasks_list)


            // RecyclerView Init
            mainListAdapter = MainListAdapter(this)
            recyclerView.adapter = mainListAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            updateRecyclerViewAnimDuration()



 val backbuttongr: ImageButton= findViewById(R.id.backbuttongr)

            backbuttongr.setOnClickListener{
                val IntentT = Intent(this@Tasks, MainActivity::class.java)
                startActivity(IntentT)
            }



            // Open Nav Drawer when opening app for the first time

        }

        /**
         * Callback for motionLayoutCheckbox
         * isChecked = true -> Use [FiltersMotionLayout]
         * isChecked = false -> Use [FiltersLayout]
         */


        /**
         * Update RecyclerView Item Animation Durations
         */
        private fun updateRecyclerViewAnimDuration() = recyclerView.itemAnimator?.run {
            removeDuration = loadingDuration * 60 / 100
            addDuration = loadingDuration
        }

        /**
         * Open browser for given string resId URL
         */
        private fun openBrowser(@StringRes resId: Int): Unit =
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(resId))))

        /**
         * Called from FiltersLayout to get adapter scale down animator
         */
        fun getAdapterScaleDownAnimator(isScaledDown: Boolean): ValueAnimator =
            mainListAdapter.getScaleDownAnimator(isScaledDown)
    }