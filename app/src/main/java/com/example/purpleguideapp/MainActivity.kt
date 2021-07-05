package com.example.purpleguideapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.parse.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ParseAnalytics.trackAppOpenedInBackground(intent)

      /* Retriving data and filter the results
       val query= ParseQuery.getQuery<ParseObject>("Fruits")
        query.whereEqualTo("name","apple")
        query.findInBackground { objects, e ->
            if (e!=null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                if(objects.size>0)
                {
                    for (parseObject in objects)
                    {
                        val name=parseObject.get("name")as String
                        val calories=parseObject.getInt("calories")as Int
                        println("NAME :"+name)
                        println("CALORIES :"+calories)
                    }
                }

            }
        }*/

     /*   //creating a class in parse
        val parseObj=ParseObject("Fruits")
        parseObj.put("name","apple")
        parseObj.put("calories",300)
        parseObj.saveInBackground { e ->
            if(e!=null)
            {
                Toast.makeText(applicationContext,e.localizedMessage.toString(),Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"SAVED".toString(),Toast.LENGTH_LONG).show()


            }
        }*/

    }
    fun signIn(view: View)
    {
        ParseUser.logInInBackground(usernameText.text.toString(),passwordText.text.toString(),
            LogInCallback{user, e ->
              if (e!=null)
              {
                  Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
              }else{
                  Toast.makeText(applicationContext,"Welcome"+user.username.toString(),Toast.LENGTH_LONG).show()
                   val intent=Intent(applicationContext, LocationActivity::class.java)
              }
            })

    }
    fun signUp(view:View)
    {
        val user =ParseUser()
        user.username=usernameText.text.toString()
        user.setPassword(passwordText.text.toString())
        user.signUpInBackground { e : ParseException? ->
            if(e!=null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"USER CREATED",Toast.LENGTH_LONG).show()
                 val intent= Intent(applicationContext,LocationActivity::class.java)
                startActivity(intent)
            }
        }

    }

}