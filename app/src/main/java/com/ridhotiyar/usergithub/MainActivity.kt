package com.ridhotiyar.usergithub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ridhotiyar.usergithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<Users>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("GitHub Users")

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<Users>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepo = resources.getStringArray(R.array.repository)
            var dataFollower = resources.getStringArray(R.array.followers)
            var dataFollowing = resources.getStringArray(R.array.following)
            val listUsers = ArrayList<Users>()
            for (i in dataName.indices) {
                val user = Users(dataName[i],dataCompany[i], dataPhoto.getResourceId(i, -1),
                dataUsername[i], dataLocation[i], dataRepo[i], dataFollower[i], dataFollowing[i])
                listUsers.add(user)
            }
            return listUsers
        }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUsersAdapter = ListUsersAdapter(list)
        rvUsers.adapter = listUsersAdapter

        listUsersAdapter.setOnItemClickCallback(object : ListUsersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                val intentToDetail = Intent(this@MainActivity, detailUserActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

}