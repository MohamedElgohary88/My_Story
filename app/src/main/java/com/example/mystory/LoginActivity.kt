package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login()

    }

    private fun login() {

        val arr:ArrayList<User> = ArrayList()
        arr.add(User("mm","33"))
        arr.add(User("aa","11"))
        arr.add(User("bb","22"))

        login.setOnClickListener {
            val username = user_name?.text.toString()
            val password = password?.text.toString()

            val user = User(username,password)

            for (userArray in arr) {
                if ( userArray.email == user.email &&
                    userArray.password == user.password ){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                    break
                }else{
                    Toast.makeText(this,"Please Check Your Data",Toast.LENGTH_SHORT).show()
                }
            }
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("email",user.email)
            startActivity(i)
        }
    }

    private fun checkFields() {
  login.setOnClickListener { if(user_name?.text?.isEmpty() == true){
      user_name.error = "Please Check Your User Name"
  }else if ( password?.text?.isEmpty() == true) {
      user_name.error = "Please Check Your User Name"
  }else if (checkbox?.isChecked != true){
      user_name.error = "Please Check Your User Name"
  } else{
      Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show() } }
    }

}