package raf.rs.rsrafprojekat2nikolapaunovic5718rn.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import raf.rs.rsrafprojekat2nikolapaunovic5718rn.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        init()
    }

//    private fun init() {
//        initListeners()
//    }
//
//    private fun initListeners() {
//        login_LogIn_Btn.setOnClickListener {
//            val username = login_Username_Et.text.toString()
//            val pin_str = login_Pin_Et.text.toString()
//
//            if (username.isEmpty() || pin_str.isEmpty()) {
//
//                return@setOnClickListener
//            }
//
//            val pin = Integer.parseInt(pin_str)
//
//            if (pin_str.length != 4) {
//
//                return@setOnClickListener
//            }
//
//            if (userViewModel.login(username, pin)) {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, R.string.login_input_error, Toast.LENGTH_SHORT).show()
//            }
//
//        }
//    }

}