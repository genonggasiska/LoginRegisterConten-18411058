package com.example.loginregisterconten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginregisterconten.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // pinda ke halaman register
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

            // menampilkan pesan selamat datang di halaman register
            Toast.makeText(this, "Welcome To Register Page", Toast.LENGTH_SHORT).show()
        }

        // Login ke halaman utama
        binding.btnLogin.setOnClickListener {
            val pass = binding.edtPersonPass.text.toString()
            val nama = binding.edtPersonName.text.toString()

            if (pass.isEmpty()){
                binding.edtPersonPass.error = "Password tidak boleh kosong"
                binding.edtPersonPass.requestFocus()
                return@setOnClickListener
            }

            if (pass.length < 6 ){
                binding.edtPersonPass.error = "Password minimal 6 karakter"
                binding.edtPersonPass.requestFocus()
                return@setOnClickListener
            }

            if (nama.isEmpty()){
                binding.edtPersonName.error = "Nama tidak boleh kosong"
                binding.edtPersonName.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
                // kirim nama yang dipakai login ke halaman konten
                intent.putExtra("extra", binding.edtPersonName.text.toString())
            startActivity(intent)
            Toast.makeText(this, "Welcome,$nama", Toast.LENGTH_SHORT).show()
        }
    }
}
