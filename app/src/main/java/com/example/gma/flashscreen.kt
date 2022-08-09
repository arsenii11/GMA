package com.example.gma

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class flashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val iv_note: ImageView by lazy { findViewById(R.id.rediss) }
        iv_note.alpha = 0f
        iv_note.animate().setDuration(2000).alpha(1f).withEndAction() {

            //обращаемся к настройкам
            val sp = getSharedPreferences(
                "hasVisited", Context.MODE_PRIVATE
            )
            // проверяем, первый ли раз открывается программа (Если вход первый то вернет false)
            val hasVisited = sp.getBoolean("hasVisited", false)

            val i = Intent(this, MainActivity::class.java)

            if (!hasVisited) {
                // Сработает если Вход первый
                //Ставим метку что вход уже был
                val e = sp.edit()
                e.putBoolean("hasVisited", true)
                e.apply()

                i.putExtra("VISITED", false);
            }
            else {
                i.putExtra("VISITED", true);
            }

            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }}