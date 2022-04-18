package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email")
        textview?.text =email

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerClicks()
        setUpDrawer()
        updateEmailInHeader(email!!)

    }

    private fun drawerClicks() {
        navigation_view?.setNavigationItemSelectedListener {
            when (it.itemId){
               R.id.home -> {
                   drawer_layout?.closeDrawer(GravityCompat.START)
               true
               }
               R.id.log_out -> {
                   finish()
                   val i = Intent(this,LoginActivity::class.java)
                   startActivity(i)

               true
               }
                else-> true
            }
        }
    }

    private fun updateEmailInHeader(email:String) {
        val headerView = navigation_view?.getHeaderView(0)
        val textViewEmail = headerView?.findViewById<TextView>(R.id.email_header)
        textViewEmail?.text = email
    }

    private fun setUpDrawer() {
        val toggle = ActionBarDrawerToggle(this,drawer_layout
            ,R.string.open,R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawer_layout?.openDrawer(GravityCompat.START)
                true

            }
            else -> true
        }

    }
}