package com.ridhotiyar.usergithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ridhotiyar.usergithub.databinding.ActivityDetailUserBinding

class detailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData(){
        val data = intent.getParcelableExtra<Users>("DATA") as Users
        supportActionBar?.setTitle(data.username)
        binding.detailName.text = data.name
        binding.repoT.text = data.repository
        binding.followersT.text = data.followers
        binding.followingT.text = data.following
        binding.location.text = data.location
        binding.detCompany.text = data.company

        var dAva:ImageView = findViewById(R.id.imgUser)
        dAva.setImageResource(data.photo)
    }
}