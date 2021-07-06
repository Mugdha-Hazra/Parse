package com.example.purpleguideapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import java.util.ArrayList

class LocationActivity : AppCompatActivity() {
    var namearray=ArrayList<String>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater=menuInflater
        menuInflater.inflate(R.menu.add_place,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId==R.id.add_place)
        {
            val intent= Intent(applicationContext,PlaceNameActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        getParseData()
    }
    fun getParseData(){
        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,namearray)


    }


}