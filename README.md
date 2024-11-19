## **To-Do App with Kotlin and Jetpack Compose**

A minimalist **To-Do List** application built with **Kotlin**, **Jetpack Compose**, and **Room Database**. This app allows users to add, display, and delete tasks, while ensuring persistent data storage.

---

### **Features**

- 🌟 **Add Tasks**: Quickly add new tasks to your list.
- ✅ **Delete Tasks**: Swipe or tap a button to remove tasks.
- 💾 **Persistent Storage**: All tasks are saved using **Room Database**, so you don’t lose them after closing the app.
- 🎨 **Material Design**: A clean and user-friendly interface with **Material3** components.
- ⚡ **Reactive UI**: Automatically updates when tasks are added or removed.

---

### **Tech Stack**

- **Kotlin**: Modern, concise, and expressive programming language.
- **Jetpack Compose**: A declarative UI toolkit for building responsive and dynamic layouts.
- **Room Database**: Local storage for saving tasks persistently.
- **Material3**: For a clean and consistent UI based on Google's Material Design.

---

### **Installation**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ClichyMercury/kotlin_todo_app
   ```
2. **Open the project in Android Studio**:
   - Use the latest version of **Android Studio Flamingo or higher**.
3. **Build the project**:
   - Navigate to `Build > Clean Project` and then `Build > Rebuild Project`.
4. **Run the app**:
   - Select a device/emulator and click the **Run** button.

---

### **Usage**

1. Open the app on your device.
2. Add a task using the input field and "Add" button.
3. View your tasks in the list.
4. Delete tasks by tapping the "Delete" button next to them.
5. Tasks are automatically saved and will reappear after restarting the app.

---

### **Folder Structure**

```
app/
└── src/
    └── main/
        └── java/
            └── com.example.my_todo_app_with_kotlin/
                ├── data/           # Room database classes
                │   ├── Task.kt
                │   ├── TaskDao.kt
                │   └── TaskDatabase.kt
                ├── ui.theme/      # Material theme customizations
                └── MainActivity.kt # Entry point of the app
```

---

### **Roadmap**

- [ ] Add **task editing** functionality.
- [ ] Implement **categories** for better task organization.
- [ ] Integrate **animations** for a smoother user experience.
- [ ] Add **dark mode** support.
- [ ] Enable **export/import of tasks**.

---

### **Contributing**

Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your message"
   ```
4. Push the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

---

### **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### **Contact**

- **Author**: [Gael SASSAN](https://github.com/ClichyMercury)
- **Email**: gaelescientifico@outlook.com.com
- **GitHub**: [Gael SASSAN](https://github.com/ClichyMercury)


