package com.example.quotesapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class QuotesItem : AppCompatActivity() {
    lateinit var category : String
    lateinit var quotes : TextView
    lateinit var author : TextView
    lateinit var categoryName : TextView
    lateinit var quoteText : Any
    lateinit var quoteAuthor : Any
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_item)
        quotes = findViewById(R.id.quotesText)
        author = findViewById(R.id.authorName)
        categoryName = findViewById(R.id.category)
        progressBar = findViewById(R.id.progressBar)

        category = intent.getStringExtra("category").toString()
        categoryName.text = category
        loadQuotes(category)
    }
    private fun loadQuotes(category: String) {
        val queue = Volley.newRequestQueue(this)
        progressBar.visibility = View.VISIBLE
        val url = "https://api.api-ninjas.com/v1/quotes?category=$category"
        val headers = hashMapOf(
            "X-Api-Key" to "7H5xFe2gHySJ4v2uXJeCiA==IF9LCRb5fR98yxtQ",
        )
        val jsonArrayRequest = object : JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                val quotesArray = response.getJSONObject(0)
                  quoteText = quotesArray.getString("quote")
                  quoteAuthor = quotesArray.getString("author")

                progressBar.visibility = View.GONE
                quotes.text = quoteText as String
                author.text = quoteAuthor as String

            },
            { error ->
                Log.d("error", "$error")
            }
        )
        {
            override fun getHeaders(): MutableMap<String, String> {
                return headers
            }
        }
        queue.add(jsonArrayRequest)
    }

    fun copy(view: View) {
        copyToClipboard(quoteText)
    }

    private fun copyToClipboard(textToCopy: Any) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("text", textToCopy.toString())
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show()

    }
    fun next(view: View) {
        loadQuotes(category)
    }
    fun share(view: View) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$quoteText")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "share this Quote using...")
        startActivity(shareIntent)
    }

}