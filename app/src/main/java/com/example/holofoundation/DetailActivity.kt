package com.example.holofoundation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_IDOL = "Extra_Idol"
    }

    private lateinit var idolTitle : TextView
    private lateinit var idolName : TextView
    private lateinit var idolDetail : TextView
    private lateinit var idolImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val idol = intent.getParcelableExtra<Idols>(EXTRA_IDOL) as Idols
        idolTitle = findViewById(R.id.idol_title)
        idolName = findViewById(R.id.idol_name)
        idolDetail = findViewById(R.id.idol_details)
        idolImage = findViewById(R.id.idol_image)


        Glide.with(this)
            .load(idol.image)
            .into(idolImage)
        idolName.text = idol.name.toString()
        idolDetail.text = idol.details.toString()
        idolTitle.text = idol.bio.toString()


    }

}
