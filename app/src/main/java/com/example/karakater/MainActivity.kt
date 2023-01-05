package com.example.karakater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.karakater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding : ActivityMainBinding by viewBinding()
    private val list : ArrayList<Karakters> = arrayListOf()
    private lateinit var listKarakterAdapter: ListKarakterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvKarakters.setHasFixedSize(true)
        list.addAll(KaraktersData.listData)

        getSupportActionBar()?.setTitle("Touhou Characters")

        showRecylerViewList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ProfileActivity::class.java)
        when(item.itemId){
            R.id.tbContact -> startActivity(intent)
        }
        return true
    }

    private fun showRecylerViewList() {
        binding.apply {
            rvKarakters.layoutManager = LinearLayoutManager(this@MainActivity)
            listKarakterAdapter = ListKarakterAdapter(list)
            rvKarakters.adapter = listKarakterAdapter
        }
    }
}