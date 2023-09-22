package com.example.practical_5_mad_041_5a3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implicitIntent()
    }

    private fun implicitIntent(){
        findViewById<Button>(R.id.browse).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(findViewById<EditText>(R.id.url).text.toString())
            ).also {startActivity(it)
            }
        }

        findViewById<Button>(R.id.call).setOnClickListener {
            val number=findViewById<EditText>(R.id.phone).text.toString().trim()
            Intent(Intent.ACTION_DIAL).setData((Uri.parse("tel:$number"))).apply{startActivity(this)}
        }

        findViewById<Button>(R.id.callLog).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also{startActivity(it)
            }
        }

        findViewById<Button>(R.id.gallery).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also{startActivity(it)
            }
        }

        findViewById<Button>(R.id.camera).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{startActivity(it)}
        }
        findViewById<Button>(R.id.alarm).setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also{startActivity(it)}
        }
    }
}