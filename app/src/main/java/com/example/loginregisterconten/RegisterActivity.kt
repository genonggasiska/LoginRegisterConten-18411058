package com.example.loginregisterconten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginregisterconten.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // ke halaman login
        binding.tvLogToReg.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

            // menampilkan pesan selamat datang di halaman register
            Toast.makeText(this, "Welcome To Login Page", Toast.LENGTH_SHORT).show()
        }

        // ketika tombol Register diklik
        binding.btnReg.setOnClickListener {
            val pass = binding.edtPersonPassReg.text.toString()
            val confPass = binding.edtPersonConfirmPassReg.text.toString()
            val nama = binding.edtPersonNameReg.text.toString()

            // validasi password
            if (pass.isEmpty()){
                binding.edtPersonPassReg.error = "Password tidak boleh kosong"
                binding.edtPersonPassReg.requestFocus()
                return@setOnClickListener
            }

            if (pass.length < 6 ){
                binding.edtPersonPassReg.error = "Password minimal 6 karakter"
                binding.edtPersonPassReg.requestFocus()
                return@setOnClickListener
            }

            // validasi confirmasi password
            if (confPass.isEmpty()){
                binding.edtPersonConfirmPassReg.error = "Password tidak boleh kosong"
                binding.edtPersonConfirmPassReg.requestFocus()
                return@setOnClickListener
            }

            if (confPass.length < 6 ){
                binding.edtPersonConfirmPassReg.error = "Password minimal 6 karakter"
                binding.edtPersonConfirmPassReg.requestFocus()
                return@setOnClickListener
            }

            if (pass != confPass) {
                binding.edtPersonConfirmPassReg.error = "Password tidak sama"
                binding.edtPersonConfirmPassReg.requestFocus()
                return@setOnClickListener
            }

            // validasi nama
            if (nama.isEmpty()){
                binding.edtPersonNameReg.error = "Nama tidak boleh kosong"
                binding.edtPersonNameReg.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Register Sukses", Toast.LENGTH_SHORT).show()
        }
    }
}