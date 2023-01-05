package com.example.karakater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.karakater.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    private val binding : ActivityDetailBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSupportActionBar()?.setTitle("Character Detail")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setData()
    }

    private fun setData() {
        binding.apply {
            val karakters = intent.getParcelableExtra<Karakters>(EXTRA_DETAIL)

            tvKarakterName.text = karakters?.name
            tvAbility.text = karakters?.ability
            tvLive.text = karakters?.live
            tvDetail.text = karakters?.detail

            Glide.with(this@DetailActivity)
                .load(karakters?.photo)
                .apply(RequestOptions())
                .into(ivKarakter)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }
}