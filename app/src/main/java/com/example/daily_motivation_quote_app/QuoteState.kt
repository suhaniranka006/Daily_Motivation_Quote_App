/**
 * PACKAGE DECLARATION: App's unique namespace
 * WHY: Organizes code and prevents naming conflicts
 */
package com.example.daily_motivation_quote_app

// COROUTINE IMPORTS: For asynchronous programming
// WHY: Need these to use coroutines for background operations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * SEALED CLASS: Represents restricted hierarchy of quote states
 * WHY: Perfect for representing finite set of states (Loading, Success, Error)
 * BENEFIT: Compiler knows all possible subclasses - great for when expressions
 */
sealed class QuoteState {
    /**
     * OBJECT: Single instance representing loading state
     * WHY: No need for multiple instances - loading state is always the same
     */
    object Loading : QuoteState()

    /**
     * DATA CLASS: Success state with actual quote data
     * @param quote The motivational quote string
     * WHY: Data class gives us equals(), hashCode(), toString() automatically
     */
    data class Success(val quote: String) : QuoteState()

    /**
     * DATA CLASS: Error state with error message
     * @param message Error description
     * WHY: Separate class for errors allows carrying error information
     */
    data class Error(val message: String) : QuoteState()
}

/**
 * COROUTINE FUNCTION: Fetches random motivational quote asynchronously
 * @param onResult Callback function that receives QuoteState
 * WHY: Uses coroutines for non-blocking network operations
 * HOW: Simulates network delay and returns random quote
 */
fun fetchQuote(onResult: (QuoteState) -> Unit) {
    // Immediately notify caller that loading has started
    onResult(QuoteState.Loading)

    /**
     * GLOBAL SCOUSE LAUNCH: Start coroutine in global scope
     * @param Dispatchers.Main Run on main thread (for UI updates)
     * WHY: Main dispatcher allows us to update UI from coroutine
     */
    GlobalScope.launch(Dispatchers.Main) {
        try {
            /**
             * DELAY: Simulate network/API call delay
             * @param 1000 milliseconds (1 second)
             * WHY: Real apps have network latency - this mimics that behavior
             */
            delay(1000)

            // Predefined list of motivational quotes
            val quotes = listOf(
                "Believe in yourself!!",
                "Stay Positive!!",
                "Keep Learning!!",
                "Never Give Up!!"
            )

            // Select random quote from the list
            val randomQuote = quotes.random()

            // Notify success with the random quote
            onResult(QuoteState.Success(randomQuote))

        } catch (e: Exception) {
            /**
             * ERROR HANDLING: Catch any exceptions during quote fetching
             * WHY: Network operations can fail - need graceful error handling
             */
            onResult(QuoteState.Error("Failed to fetch quote"))
        }
    }
}