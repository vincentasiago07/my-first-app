package com.example.myinitentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore





class MainActivity : AppCompatActivity() {
    var sms:Button?=null
    var email:Button?=null
    var stk:Button?=null
    var camera:Button?=null
    var share:Button?=null
    var call:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stk=findViewById(R.id.button7)
        sms=findViewById(R.id.button9)
        email=findViewById(R.id.button8)
        share=findViewById(R.id.button10)
        call=findViewById(R.id.button11)
        camera=findViewById(R.id.button12)
        setContentView(R.layout.activity_main)

        stk!!.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        sms!!.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0718951621")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)

        }
        email!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "DEAR SIR.....")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        share!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        call!!.setOnClickListener {
            val phone = "0718951621"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)

        }
        camera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }
    }
}