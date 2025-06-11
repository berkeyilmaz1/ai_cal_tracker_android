# AI Calorie Tracker 🍎

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![API Level](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://developer.android.com/guide/topics/manifest/uses-sdk-element.html#ApiLevels)
[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)
[![Firebase](https://img.shields.io/badge/Backend-Firebase-yellow.svg)](https://firebase.google.com)
[![Gemini AI](https://img.shields.io/badge/AI-Google%20Gemini-blue.svg)](https://ai.google.dev)

One-tap calorie tracking! Our AI-powered calorie tracking application automatically analyzes food images to provide nutritional information and helps users maintain healthy eating habits.
## 🌟 Features

### 🔍 AI-Powered Food Analysis
- **Google Gemini 2.5 Flash** model for automatic food recognition from photos
- AI-calculated calories, protein, carbohydrates, and fat values
- Personalized healthy eating recommendations and meal improvement suggestions

### 📊 Personalized Tracking
- BMR (Basal Metabolic Rate) calculation
- Daily calorie goals based on age, weight, height, gender, and activity level
- Customized calorie planning for weight loss, maintenance, and weight gain goals
- Comprehensive macro nutrients (protein, carbohydrates, fat) tracking

### 💧 Water Intake Monitoring
- Daily hydration goals and tracking
- Easy water consumption logging system
- Hydration reminders and progress monitoring

### 📱 Modern User Experience
- Material Design compliant interface
- Dark/Light theme support
- Multi-language support (Turkish and English)
- Intuitive navigation drawer menu
- Responsive and user-friendly design

## 🖼️ App Screenshots

### Authentication & Onboarding
- **Multi-step Registration**: Comprehensive user profile setup with personal information, physical data, and activity level
- **Secure Login**: Email/password authentication with Firebase integration

  <div align="center">

  <img src="https://github.com/user-attachments/assets/66aad144-57c9-470a-a71f-35f1242686b1" width="200"/>
  <img src="https://github.com/user-attachments/assets/427e971e-4bf6-44e7-8dcc-a48a9fd7017d" width="200"/>
  <img src="https://github.com/user-attachments/assets/228e55bb-d724-4680-9337-9212a202cdf8" width="200"/>
</div>

### Main Interface
- **Calorie Tracker**: Main dashboard displaying daily progress, remaining calories, and macro breakdown
- **Camera Integration**: Take photos or select from gallery for instant food analysis
- **Meal History**: Horizontal scrollable list of previous meals with quick access to details

<div align="center">
<img src= "https://github.com/user-attachments/assets/5fe7b853-e688-48cc-8f66-730dae3bff95" width="250"/>
<img src= "https://github.com/user-attachments/assets/bfe895c9-1d5e-4527-bc8f-75d2f477227e" width="250"/>
</div>

### User Management
- **Profile Screen**: Complete user information display with editable fields for goals and preferences
- **Settings**: Theme switching, language selection, and app preferences
- **Detailed Food View**: Comprehensive nutritional information with AI-generated recommendations

<div align="center">
<img src= "https://github.com/user-attachments/assets/29cc169d-0677-4e5c-a3e9-4a87c92727bf" width="250"/>
<img src= "https://github.com/user-attachments/assets/7a96dc75-bc7b-4519-8d13-8ec61735a26e" width="250"/>
<img src= "https://github.com/user-attachments/assets/7709a178-5b66-4746-bcfd-b769e228c73d" width="250"/>
</div>

## 🛠️ Technology Stack

### Frontend Technologies
- **Java** - Primary programming language
- **XML** - UI layout and design
- **Material Components** - Modern UI components and design system
- **AndroidX Navigation** - Fragment navigation and screen management
- **Glide** - Efficient image loading and caching

### Backend & Services
- **Firebase Authentication** - Secure user authentication and account management
- **Firebase Firestore** - NoSQL cloud database for real-time data storage
- **Cloudinary** - Cloud-based image storage and management service
- **Google Gemini API** - AI-powered food image analysis and recognition

### Architecture & Patterns
- **MVVM (Model-View-ViewModel)** - Clean architecture pattern
- **Repository Pattern** - Data management abstraction
- **Singleton Pattern** - Service management and resource optimization
- **LiveData & ViewModel** - Reactive UI updates and lifecycle management

## 📱 System Requirements

- **Minimum Android Version**: Android 5.0+ (API Level 26)
- **Target SDK**: Android 13 (API Level 35)
- **Required Permissions**: Internet, Camera, Storage Access
- **Network**: Internet connection required for AI analysis and data synchronization

## 📊 Key Features Overview

| Feature | Description |
|---------|-------------|
| **AI Food Recognition** | Instant food identification from photos using Google Gemini |
| **Calorie Calculation** | Automatic BMR calculation and personalized daily targets |
| **Macro Tracking** | Detailed protein, carbs, and fat monitoring |
| **Water Logging** | Simple hydration tracking with daily goals |
| **Multi-language** | Turkish and English language support |
| **Themes** | Dark and light mode options |
| **Meal History** | Comprehensive logging with detailed nutritional info |
| **Progress Reports** | Visual charts and statistics |

## 👥 Course Details

**Course**: Mobile Programming (BM443) - Spring 2024-2025  
**Instructor**: Assoc. Prof. Dr. Abdullah Talha KABAKUŞ

*Computer Engineering Department*

## 🚀 Installation

### Prerequisites
- Android Studio Arctic Fox (2020.3.1) or later
- JDK 8 or higher
- Android SDK API Level 21+

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/berkeyilmaz1/ai_cal_tracker_android.git
   cd ai_cal_tracker
   ```

2. **Firebase Configuration**
   - Create a new project in [Firebase Console](https://console.firebase.google.com)
   - Add Android app with package name: `com.duzceders.aicaltracker`
   - Download and add `google-services.json` to `app/` folder
   - Enable Authentication and Firestore services

3. **API Keys Setup**
   - **Google Gemini API**: Get API key from [Google AI Studio](https://makersuite.google.com/app/apikey)
   - **Cloudinary**: Create account at [Cloudinary Console](https://cloudinary.com/console)
   - Add API keys to `local.properties`

4. **Build and Run**
   ```bash
   ./gradlew clean build
   ```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


