package com.example.quotesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), QuotesItemClicked {
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesArr = ArrayList<QuotesModal>()

        quotesArr.add(QuotesModal(R.drawable.age, "intelligence"))
        quotesArr.add(QuotesModal(R.drawable.age, "jealousy"))
        quotesArr.add(QuotesModal(R.drawable.age, "knowledge"))
        quotesArr.add(QuotesModal(R.drawable.age, "leadership"))
        quotesArr.add(QuotesModal(R.drawable.age, "learning"))
        quotesArr.add(QuotesModal(R.drawable.age, "legal"))
        quotesArr.add(QuotesModal(R.drawable.age, "life"))
        quotesArr.add(QuotesModal(R.drawable.age, "love"))
        quotesArr.add(QuotesModal(R.drawable.age, "marriage"))
        quotesArr.add(QuotesModal(R.drawable.age, "medical"))
        quotesArr.add(QuotesModal(R.drawable.age, "men"))
        quotesArr.add(QuotesModal(R.drawable.age, "mom"))
        quotesArr.add(QuotesModal(R.drawable.age, "money"))
        quotesArr.add(QuotesModal(R.drawable.age, "morning"))
        quotesArr.add(QuotesModal(R.drawable.age, "movies"))
        quotesArr.add(QuotesModal(R.drawable.age, "success"))
        quotesArr.add(QuotesModal(R.drawable.age, "age"))
        quotesArr.add(QuotesModal(R.drawable.age, "alone"))
        quotesArr.add(QuotesModal(R.drawable.age, "amazing"))
        quotesArr.add(QuotesModal(R.drawable.age, "anger"))
        quotesArr.add(QuotesModal(R.drawable.age, "architecture"))
        quotesArr.add(QuotesModal(R.drawable.age, "art"))
        quotesArr.add(QuotesModal(R.drawable.age, "attitude"))
        quotesArr.add(QuotesModal(R.drawable.age, "beauty"))
        quotesArr.add(QuotesModal(R.drawable.age, "best"))
        quotesArr.add(QuotesModal(R.drawable.age, "birthday"))
        quotesArr.add(QuotesModal(R.drawable.age, "business"))
        quotesArr.add(QuotesModal(R.drawable.age, "car"))
        quotesArr.add(QuotesModal(R.drawable.age, "change"))
        quotesArr.add(QuotesModal(R.drawable.age, "communications"))
        quotesArr.add(QuotesModal(R.drawable.age, "computers"))
        quotesArr.add(QuotesModal(R.drawable.age, "cool"))
        quotesArr.add(QuotesModal(R.drawable.age, "courage"))
        quotesArr.add(QuotesModal(R.drawable.age, "dad"))
        quotesArr.add(QuotesModal(R.drawable.age, "dating"))
        quotesArr.add(QuotesModal(R.drawable.age, "death"))
        quotesArr.add(QuotesModal(R.drawable.age, "design"))
        quotesArr.add(QuotesModal(R.drawable.age, "dreams"))
        quotesArr.add(QuotesModal(R.drawable.age, "education"))
        quotesArr.add(QuotesModal(R.drawable.age, "environmental"))
        quotesArr.add(QuotesModal(R.drawable.age, "equality"))
        quotesArr.add(QuotesModal(R.drawable.age, "experience"))
        quotesArr.add(QuotesModal(R.drawable.age, "failure"))
        quotesArr.add(QuotesModal(R.drawable.age, "faith"))
        quotesArr.add(QuotesModal(R.drawable.age, "family"))
        quotesArr.add(QuotesModal(R.drawable.age, "famous"))
        quotesArr.add(QuotesModal(R.drawable.age, "fear"))
        quotesArr.add(QuotesModal(R.drawable.age, "fitness"))
        quotesArr.add(QuotesModal(R.drawable.age, "food"))
        quotesArr.add(QuotesModal(R.drawable.age, "forgiveness"))
        quotesArr.add(QuotesModal(R.drawable.age, "freedom"))
        quotesArr.add(QuotesModal(R.drawable.age, "friendship"))
        quotesArr.add(QuotesModal(R.drawable.age, "funny"))
        quotesArr.add(QuotesModal(R.drawable.age, "future"))
        quotesArr.add(QuotesModal(R.drawable.age, "god"))
        quotesArr.add(QuotesModal(R.drawable.age, "good"))
        quotesArr.add(QuotesModal(R.drawable.age, "government"))
        quotesArr.add(QuotesModal(R.drawable.age, "graduation"))
        quotesArr.add(QuotesModal(R.drawable.age, "great"))
        quotesArr.add(QuotesModal(R.drawable.age, "happiness"))
        quotesArr.add(QuotesModal(R.drawable.age, "health"))
        quotesArr.add(QuotesModal(R.drawable.age, "history"))
        quotesArr.add(QuotesModal(R.drawable.age, "home"))
        quotesArr.add(QuotesModal(R.drawable.age, "hope"))
        quotesArr.add(QuotesModal(R.drawable.age, "humor"))
        quotesArr.add(QuotesModal(R.drawable.age, "imagination"))
        quotesArr.add(QuotesModal(R.drawable.age, "inspirational"))

        val quotesAdapter  = QuotesAdapter(this,this, quotesArr)
        recyclerView = findViewById(R.id.recycler)
        recyclerView.adapter = quotesAdapter
        recyclerView.layoutManager  = LinearLayoutManager(this)

    }

    override fun onItemClicked(item: QuotesModal) {
        val intent = Intent(this, QuotesItem::class.java)
        intent.putExtra("category", item.category)
        startActivity(intent)
    }
}