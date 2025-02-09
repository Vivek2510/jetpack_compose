Overview

This project is a basic structured template following the Clean Architecture principles. It includes essential configurations and implementations for:

String Localization with multiple languages.

Dark and Light Theme support.

API Calling setup using UseCase and ViewModel.

Local Storage setup with an example of storing login data.

Features

Multi-language Support: Easily switch between different languages.

Theming: Toggle between dark and light mode.

API Integration: Pre-configured API setup with UseCase and ViewModel.

Local Storage: Example implementation for storing user login data.


Project Structure

This project follows Clean Architecture, which separates concerns into different layers:

project-root/
│── data/               # Data sources (local & remote)
│── domain/             # Business logic (UseCases, Repositories)
│── presentation/       # UI Layer (ViewModels, Screens, Components)
│── core/               # Common utilities (Networking, Storage, Themes)
│── localization/       # Multi-language setup
│── themes/             # Dark and Light mode configurations
│── storage/            # Local storage setup (e.g., shared preferences, database)


Setup Instructions

Clone the repository:

git clone <repository-url>

Navigate to the project directory:

cd project-root

Open the project in Android Studio.

Sync the Gradle files.

Run the project:

./gradlew assembleDebug  # Build the debug APK

or use Run > Run 'app' in Android Studio.



Usage

To enable multi-language support, modify the localization files.

To switch themes, use the theme provider or settings.

Use API services via the UseCase & ViewModel layers.

Store and retrieve local data using the storage module.
