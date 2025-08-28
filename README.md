# ✨ Daily Motivation Quote App (Kotlin + Coroutines + Sealed Classes)

A simple Daily Motivation Quote App built with Kotlin and XML UI.
The app demonstrates sealed classes, coroutines, and clean UI state management in a practical way.

## 🚀 How It Works

User opens the app.

1. A quote is fetched asynchronously (simulating  call using delay()).

2. App uses a sealed class (QuoteState) to represent:

3.Loading → Shows loading text/indicator.

4. Success → Displays the fetched quote.

5. Error → Shows error message (if fetching fails).

- User can tap **“Get New Quote”** button to fetch another random motivational quote.

## ✨ Features

💡 Daily Motivational Quotes (randomized from a local list ).

⏳ Sealed Class UI State → Loading, Success, Error.

⚡ Kotlin Coroutines for asynchronous fetching.

🎨 Clean Gradient UI with CardView for quote display.

🔄 Smooth Animations when quote changes.

🧑‍💻 Demonstrates modern state management pattern in Kotlin.

## 📱 Screenshots


## 🛠️ Tech Stack

Language: Kotlin

UI: XML Layouts (CardView, Material Components)

IDE: Android Studio

## Concepts Used:

Sealed Classes → Representing UI state (Loading / Success / Error).

Coroutines → Asynchronous fetch.

State Management Pattern → when expressions for handling states.

lateinit properties for UI components.

Material Time Picker (optional for daily reminders).


## 📂 Project Structure

daily_quote_app/

 ┣ 📂 java/com/example/daily_quote_app
 
 ┃ ┣ QuoteState.kt        # Sealed class (Loading, Success, Error)
 
 ┃ ┣ QuoteRepository.kt   # Provides quotes (simulated fetch)
 
 ┃ ┗ MainActivity.kt      # UI logic + coroutine + state handling
 
 ┣ 📂 res/layout
 
 ┃ ┗ activity_main.xml    # Main UI (CardView + Button)
 
 ┣ 📂 res/drawable
 
 ┃ ┣ bg_gradient.xml      # Gradient background
 
 ┃ ┗ btn_gradient.xml     # Button style
 
 ┣ 📂 res/values
 
 ┃ ┗ strings.xml, colors.xml
 
 ┗ AndroidManifest.xml


## 📊 UML Diagram

classDiagram

class QuoteState {

    <<sealed>>
    
    +Loading

    +Success(quote: String)
    
    +Error(message: String)
    
}

class QuoteRepository {

    +fetchRandomQuote(): String
    
}

class MainActivity {

    -quoteText: TextView
    
    -btnFetch: Button
    
    +onCreate()
    
    +fetchQuote()
    
}

QuoteState <.. MainActivity

MainActivity --> QuoteRepository

## 📌 Future Enhancements

🌍 Fetch quotes from a real API using Retrofit.

📆 Show a Daily Scheduled Quote Notification using WorkManager.

❤️ Allow users to Save Favorite Quotes in Room DB.

🔗 Add Share Quote feature (WhatsApp, Twitter, etc.).

🎨 Upgrade UI to Material 3 with animations & dark mode.
