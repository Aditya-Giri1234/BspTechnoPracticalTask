# BspTechnoPracticalTask

## Description

The **BspTechnoPracticalTask** app is a practical mobile application that fetches book data from an API and stores it locally. If the network is unavailable, users can view previously stored book details. The app refreshes the data every 2 hours and saves the updated information locally to ensure that users always have the latest data, even when offline.

### Key Features

- **Pull to Refresh:**  
  Users can pull to refresh the data. If the data was previously fetched and less than 2 hours old, the app will display the stored local data. Otherwise, it will fetch the latest data from the network.

- **Retry Action:**  
  If the network is unavailable, users can retry the network call once the connection is restored. The app gracefully handles network errors and provides the user with a retry option.

- **Local Data Support:**  
  The app saves fetched book data locally on the first successful fetch. When the network is unavailable, the app allows users to view the stored book information.

- **Loading Animation:**  
  A loading animation is displayed while the app fetches data, providing a smooth user experience. The animation is shown both when:
  - Fetching book data from the API.
  - Loading the book cover image.

- **Cache to Reduce Network Calls:**  
  The app uses caching techniques to minimize network calls, fetching fresh data only when necessary.


### Architecture

The app follows a **Clean Architecture** and extends the **MVVM pattern** for better separation of concerns and testability. It uses **Hilt** for dependency injection.

### Key Challenges

- **Unit Testing API Calls:**  
  A key challenge during development was testing API calls. This involved researching through documentation and articles to find appropriate ways to mock network responses and ensure proper testing behavior.

## Video Demo


https://github.com/user-attachments/assets/db80c021-3981-4975-8cab-90b8d02295a3




## How to Build, Run, and Use the Application

1. **Clone the Repository:**  
   ```bash
   git clone https://github.com/yourusername/bsptechno-practical-task.git
   cd bsptechno-practical-task

2. **Build the App :**
Open the project in **Android Studio** and build the app using the following steps:
- Open Android Studio.
- Go to **File > Open** and select the project folder.
- Once the project is loaded, navigate to **Build > Rebuild Project** in the Android Studio menu.

3. **Run the App :**
You can run the app on an emulator or a physical device by clicking on the **Run** button in Android Studio.

4. **Usage :**
- **On first launch**, the app fetches book data from the API and stores it locally.
- **If the network is available**, users can refresh the data using the pull-to-refresh functionality. If the data is less than 2 hours old, the app displays stored local data; otherwise, it fetches the latest data.
- **Retry Action:** If the network is unavailable, users can retry fetching the data once the network is available again.
