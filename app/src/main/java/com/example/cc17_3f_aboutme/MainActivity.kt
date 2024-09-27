package com.example.cc17_3f_aboutme

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cc17_3f_aboutme.adapter.AboutMeAdapter
import com.example.cc17_3f_aboutme.model.AboutMe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvAboutMeRv: RecyclerView = findViewById(R.id.rvAboutMe)
        rvAboutMeRv.layoutManager = LinearLayoutManager(this)

        val aboutMe1 = AboutMe(R.mipmap.ic_launcher,
            "Colleen Mallari",
            "Working Student Athlete"
        ) { view ->
              val intent = Intent(this, AboutColleenActivity::class.java)
              startActivity(intent)
        }

        val aboutMe2 = AboutMe(R.drawable.download,
            "Keith Castor",
            "21 years old",
            { view ->
                val intent = Intent(this, AboutKeithCastorActivity::class.java)
                startActivity(intent)
            })

        val arrList = listOf(aboutMe1, aboutMe2)


        rvAboutMeRv.adapter = AboutMeAdapter(arrList)




    }
}