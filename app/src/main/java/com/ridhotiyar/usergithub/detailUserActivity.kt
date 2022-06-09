package com.ridhotiyar.usergithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detailUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val data = intent.getParcelableExtra<Users>("DATA") as Users

        var dName:TextView = findViewById(R.id.detailName)
        dName.setText(data.name)
        var dAva:ImageView = findViewById(R.id.imgUser)
        dAva.setImageResource(data.photo)
        var dRepo:TextView = findViewById(R.id.repoT)
        dRepo.setText(data.repository.toString())
        var dFollowers:TextView = findViewById(R.id.followersT)
        dFollowers.setText(data.followers.toString())
        var dFollowing:TextView = findViewById(R.id.followingT)
        dFollowing.setText(data.following.toString())
        var dLoc:TextView = findViewById(R.id.location)
        dLoc.setText(data.location)
        var dCom:TextView = findViewById(R.id.detCompany)
        dCom.setText(data.company)

        supportActionBar?.setTitle(data.username)
    }
}