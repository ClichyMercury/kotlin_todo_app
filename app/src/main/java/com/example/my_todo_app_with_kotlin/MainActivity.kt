package com.example.my_todo_app_with_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.my_todo_app_with_kotlin.data.Task
import com.example.my_todo_app_with_kotlin.data.TaskDatabase
import com.example.my_todo_app_with_kotlin.ui.theme.My_todo_app_with_kotlinTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation de la base de données
        val db = TaskDatabase.getDatabase(applicationContext)
        val taskDao = db.taskDao()

        setContent {
            // Liste mutable pour les tâches, alimentée par Room
            val tasks = remember { mutableStateListOf<Task>() }

            // Charger les tâches au démarrage
            LaunchedEffect(Unit) {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val loadedTasks = taskDao.getAllTasks()
                        tasks.addAll(loadedTasks)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            My_todo_app_with_kotlinTheme {
                ToDoListScreen(
                    tasks = tasks,
                    onAddTask = { taskName ->
                        val newTask = Task(name = taskName)
                        tasks.add(newTask) // Ajouter localement

                        // Insérer dans Room
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                taskDao.insertTask(newTask)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    },
                    onRemoveTask = { taskToRemove ->
                        tasks.remove(taskToRemove) // Supprimer localement

                        // Supprimer de Room
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                taskDao.deleteTask(taskToRemove)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ToDoListScreen(tasks: List<Task>, onAddTask: (String) -> Unit, onRemoveTask: (Task) -> Unit) {
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Zone de saisie pour ajouter une tâche
        TextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("Nouvelle tâche") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Bouton pour ajouter une nouvelle tâche
        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    onAddTask(newTask)
                    newTask = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ajouter")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Liste des tâches
        LazyColumn {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(task.name, style = MaterialTheme.typography.bodyMedium)
                    Button(onClick = { onRemoveTask(task) }) {
                        Text("Supprimer")
                    }
                }
            }
        }
    }
}
