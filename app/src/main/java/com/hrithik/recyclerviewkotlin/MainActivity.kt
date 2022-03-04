package com.hrithik.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithik.recyclerviewkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
      ///  populateList()

    }


}