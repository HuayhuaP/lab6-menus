package com.example.lab06_menus

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab06_menus.ui.theme.Lab06MenusTheme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab06MenusTheme {
                val navController = rememberNavController()
                // Configuración de la navegación
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController = navController) // Pantalla de inicio
                    }
                    composable("profile") {
                        UserProfileScreen() // Pantalla de perfil de usuario
                    }
                    composable("build") {
                        BuildScreen() // Pantalla de construcción
                    }
                    composable("menu") {
                        MenuScreen() // Pantalla de menú
                    }
                    composable("favorite") {
                        FavoriteScreen() // Pantalla de favoritos
                    }
                    composable("delete") {
                        DeleteScreen() // Pantalla de eliminar
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var clickCount by remember { mutableStateOf(0) } // Contador de clics
    Scaffold(
        topBar = { CustomTopBar(navController = navController) }, // Barra superior con navegación
        bottomBar = { CustomBottomBar(navController) }, // Barra inferior
        floatingActionButton = { CustomFAB { clickCount++ } }, // Botón flotante
        content = { padding ->
            // Aquí puedes colocar el contenido principal de la pantalla
            CustomContent(padding = padding, clickCount = clickCount) // Contenido principal
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = {
                navController.navigate("profile") // Navegar a la pantalla de perfil
            }) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Perfil")
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil de Usuario") }
            )
        },
        content = {
            // Aquí puedes personalizar el contenido del perfil de usuario
            Text(text = "Bienvenido a la pantalla de perfil", modifier = Modifier.fillMaxSize())
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { navController.navigate("build") }) {
                Icon(Icons.Filled.Build, contentDescription = "Construcción")
            }
            IconButton(onClick = { navController.navigate("menu") }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú")
            }
            IconButton(onClick = { navController.navigate("favorite") }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favoritos")
            }
            IconButton(onClick = { navController.navigate("delete") }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }
        }
    }
}



@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() } // Llama a la función para incrementar el contador
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}



@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My app content", fontSize = 24.sp)
        Text(text = "Has presionado el botón: $clickCount veces", fontSize = 20.sp)
    }
}





// Pantalla para Construcción
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BuildScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Construcción") }
            )
        },
        content = {
            Text(text = "Esta es la pantalla de Construcción", modifier = Modifier.fillMaxSize())
        }
    )
}

// Pantalla para Menú
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú") }
            )
        },
        content = {
            Text(text = "Esta es la pantalla del Menú", modifier = Modifier.fillMaxSize())
        }
    )
}

// Pantalla para Favoritos
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favoritos") }
            )
        },
        content = {
            Text(text = "Esta es la pantalla de Favoritos", modifier = Modifier.fillMaxSize())
        }
    )
}

// Pantalla para Eliminar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Eliminar") }
            )
        },
        content = {
            Text(text = "Esta es la pantalla de Eliminar", modifier = Modifier.fillMaxSize())
        }
    )
}


