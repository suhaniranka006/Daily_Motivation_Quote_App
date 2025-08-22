package com.example.daily_motivation_quote_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Import your QuoteState class
// If it's in different package, use: import com.example.daily_motivation_quote_app.QuoteState

class MainActivity : AppCompatActivity() {

    private lateinit var quoteText: TextView
    private lateinit var fetchQuoteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI components
        quoteText = findViewById(R.id.quoteText)
        fetchQuoteButton = findViewById(R.id.fetchQuoteButton)

        // Set click listener for fetch quote button
        fetchQuoteButton.setOnClickListener {
            /**
             * Call the fetchQuote function with a callback
             * The callback receives QuoteState and updates UI accordingly
             */
            fetchQuote { state ->
                /**
                 * WHEN EXPRESSION: Handle different states of quote fetching
                 * WHY: Sealed class allows exhaustive when expression (compiler checks all cases)
                 */
                when (state) {
                    is QuoteState.Loading -> {
                        // Show loading message
                        quoteText.text = "Loading..."
                    }
                    is QuoteState.Success -> {
                        // Show the fetched quote
                        quoteText.text = state.quote
                    }
                    is QuoteState.Error -> {
                        // Show error message
                        quoteText.text = state.message
                    }
                }
            }
        }

        /**
         * EDGE-TO-EDGE HANDLING: Make content extend behind system bars
         * WHY: Modern Android design guideline
         */

    }
}