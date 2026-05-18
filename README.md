# 🚌 Vidya-Vahini — Student Commute Buddy

![Platform](https://img.shields.io/badge/Platform-Android-brightgreen)
![Language](https://img.shields.io/badge/Language-Java-orange)
![Firebase](https://img.shields.io/badge/Backend-Firebase-yellow)
![Min SDK](https://img.shields.io/badge/Min%20SDK-API%2021-blue)
![Internship](https://img.shields.io/badge/Program-MindMatrix-purple)

> **"Waze for Rural Students"** — A crowdsourced, real-time bus tracker for rural college students in India.

---

## 📖 About

**Vidya-Vahini** (Kannada: *"Knowledge Vehicle"*) solves a critical problem faced by thousands of rural students — unpredictable bus schedules that cause missed exams, unsafe waiting, and school dropouts.

When **one student spots the bus**, they tap **PING** — and **every student on that route** instantly gets an updated ETA.

---

## 😟 Problem Statement

Rural students rely on government buses with no real-time tracking. When buses are delayed or cancelled:

- 📚 Students miss exams and lab sessions
- 👧 Girls wait alone at isolated, unsafe bus stops
- 👨‍👩‍👧 Parents have no visibility into their child's commute
- ❌ No student-focused transport tracking exists for rural routes

---

## ✨ Features

| Feature | Description | Priority |
|---|---|---|
| 🗺️ **Route Selection** | Choose your college route from a pre-loaded list | P1 |
| 📍 **Bus Ping** | One tap: *"Bus just crossed [Landmark]"* — shared instantly with all | P1 |
| ⏱️ **Live ETA** | Calculates expected arrival at your stop based on pings | P1 |
| 📊 **Route Line View** | Visual showing bus's last known position along the route | P1 |
| ⚠️ **Breakdown Report** | Alert all route users to find alternative transport | P1 |
| ✅ **Safe-Reach Alert** | Notify parent/guardian when you arrive safely | P2 |
| 👤 **Reporter Name** | *"Reported by [Name]"* adds trust and accountability to pings | P2 |
| 📵 **Offline Fallback** | Shows cached last-known status when internet is unavailable | P3 |

---

## 🏗️ Project Structure
VidyaVahini/
├── app/src/main/
│   ├── java/com/vidyavahini/
│   │   ├── ui/
│   │   │   ├── MainActivity.java          # Home screen — ETA + Ping button
│   │   │   └── RouteSelectActivity.java   # First-launch route selection
│   │   ├── model/
│   │   │   ├── BusPing.java               # Ping data model
│   │   │   └── Route.java                 # Route data model
│   │   ├── repository/
│   │   │   └── FirebaseRepository.java    # All Firebase operations
│   │   └── utils/
│   │       ├── EtaCalculator.java         # Simulated ETA logic
│   │       └── PrefsHelper.java           # SharedPreferences wrapper
│   ├── res/
│   │   ├── layout/activity_main.xml
│   │   └── values/strings.xml, colors.xml
│   └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
└── README.md

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Platform | Android (Java) |
| Minimum SDK | API 21 — Android 5.0 (supports low-end devices) |
| Real-time Database | Firebase Realtime Database |
| Push Notifications | Firebase Cloud Messaging (FCM) |
| Local Cache | SharedPreferences + Room Database |
| Build System | Gradle |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (Hedgehog or later)
- Java 11+
- A Firebase account (free tier is enough)

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/ishx2k3/VIDYA-VAHINI.git
cd VIDYA-VAHINI
```

**2. Set up Firebase**
- Go to [Firebase Console](https://console.firebase.google.com)
- Create a new project → Add Android App
- Package name: `com.vidyavahini`
- Download `google-services.json` → place it inside the `app/` folder
- Enable **Realtime Database** (test mode)
- Enable **Cloud Messaging**

**3. Open in Android Studio**
- File → Open → Select the project folder
- Wait for Gradle sync to complete
- Run on emulator or real device (Android 5.0+)

---

## 📡 Firebase Data Structure

```json
{
  "routes": {
    "route_belgaum_pesce": {
      "name": "Doddaballapur → PESCE College",
      "stops": ["Doddaballapur Bus Stand", "Madhure Cross", "Nelamangala", "PESCE Gate"],
      "avgTimeBetweenStops": [12, 18, 8],
      "lastPing": {
        "stop": "Nelamangala",
        "reporter": "Ishwarappa",
        "timestamp": 1716000000000
      }
    }
  }
}
```

---

## 📱 How It Works

Open app → Your default route loads automatically
View ETA  → "Bus arrives at your stop in ~12 mins"
Spot bus  → Tap PING → Select landmark → Submit
Firebase  → All users on route see updated ETA instantly
Arrive    → Tap SAFE-REACH → Parent gets notification


---

## ✅ Acceptance Tests

| Test | Pass Condition |
|---|---|
| Ping updates all users | Updated ETA visible to all route users within **2 seconds** |
| Breakdown alert works | Push notification sent to all users within **5 seconds** |
| Runs on low-end devices | Works on 2GB RAM, Android 5.0 · APK size **≤ 15 MB** |

---

## 👨‍💻 Developer

| Name | USN | Email |
|---|---|---|
| Ishwarappa | 1VA23CS400 | ishwarkhwast@gmail.com |

---

## 🏢 Program

Developed as **Project 101** under the **MindMatrix Internship Program**
by **CL Infotech Pvt. Ltd.**

> All intellectual property belongs to CL Infotech Pvt. Ltd.
> This repository is shared for academic and internship purposes only.

---

*"When one student sees the bus — all students know."* 🚌

