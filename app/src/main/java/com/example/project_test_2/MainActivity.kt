package com.example.project_test_2

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var coinanimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coin: ImageView = findViewById(R.id.coin)
        coin.setBackgroundResource(R.drawable.coin_animation)
        coinanimation = coin.background as AnimationDrawable

        val btnTotalExpenditure = findViewById<Button>(R.id.btnTotalExpenditure)
        val btnAddExpense = findViewById<Button>(R.id.btnAddExpense)

        btnTotalExpenditure.setOnClickListener {
            // Navigate to TotalExpenditureActivity
            val intent = Intent(this, TotalExpenditureActivity::class.java)
            startActivity(intent)
        }

        btnAddExpense.setOnClickListener {
            // Navigate to AddExpenseActivity
            val intent = Intent(this, AddExpenseActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            coinanimation.start()
        } else {
            coinanimation.stop()
        }
    }
}
