package com.example.purpleguideapp

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_place_name.*
import java.util.jar.Manifest

var globalName=""


class PlaceNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_name)

    }
    fun selectImage(view: View)
    {
           if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED)
           {
               requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),2)
           }else{
               val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
               startActivityForResult(intent,1)
           }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode==2){
             if(grantResults.size>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
             {
                 val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                 startActivityForResult(intent,1)
             }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==1&&resultCode==Activity.RESULT_OK&&data!=null)
        {
            val selected=data.data
            try {
                val bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,selected)
                imageView2.setImageBitmap(bitmap)

            }catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun next(view: View)
    {

    }
}