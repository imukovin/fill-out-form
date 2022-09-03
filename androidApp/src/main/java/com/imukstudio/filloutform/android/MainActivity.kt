package com.imukstudio.filloutform.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.imukstudio.filloutform.Greeting
import com.tejpratapsingh.pdfcreator.activity.PDFCreatorActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.save_to_pdf).setOnClickListener {
            startActivity(Intent(this, PdfFormCreatorActivity::class.java))
        }

    }
}
