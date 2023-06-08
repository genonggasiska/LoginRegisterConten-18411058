package com.example.loginregisterconten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.loginregisterconten.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // pesan saat log-out
            Toast.makeText(this, "Anda Telah Log-Out", Toast.LENGTH_SHORT).show()
        }

        // tangkap nama/email yang digunakan untuk login kemudian taruh ke dalam variabel 'nama' dan atur sebagai creator di halaman conten
        val nama = intent.getStringExtra("extra")
        binding.created.text = "Created by " + nama

    }
}