package de.syntax_institut.lernkarten.team.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.lernkarten.team.ui.components.NavBarBackButton
import de.syntax_institut.lernkarten.team.ui.components.NavBarTitle
import de.syntax_institut.lernkarten.team.ui.screens.Library
import de.syntax_institut.lernkarten.team.ui.screens.Setting
import de.syntax_institut.lernkarten.team.ui.screens.Home
import de.syntax_institut.lernkarten.team.ui.screens.NewDeck

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigator() {

    val navController = rememberNavController()
    var selectedTabItem by rememberSaveable { mutableStateOf(TabItem.HOME) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route?.substringBefore("/")

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    when( currentRoute ) {

                        HomeRoute::class.qualifiedName -> NavBarTitle("Home")
                        LibraryRoute::class.qualifiedName -> NavBarTitle("Library")
                        SettingsRoute::class.qualifiedName -> NavBarTitle("Settings")
                        NewDeckRoute::class.qualifiedName -> NavBarTitle("New Deck")
                    }
                },
                navigationIcon = {

                    when( currentRoute ) {

                        NewDeckRoute::class.qualifiedName -> NavBarBackButton(navController)
                    }
                }
            )
        },
        floatingActionButton = {
            if( currentRoute == HomeRoute::class.qualifiedName) {

                FloatingActionButton(
                    onClick = { navController.navigate(NewDeckRoute) },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(Icons.Default.Home, contentDescription = "Neues Deck")
                }
            }
        },
        bottomBar = {
            NavigationBar(

                modifier = Modifier.background(Color.Transparent)
            ) {
                TabItem.entries.forEach { tabItem ->

                    NavigationBarItem(
                        selected = selectedTabItem == tabItem,
                        onClick = { selectedTabItem = tabItem },
                        icon = {
                            Icon(
                                imageVector = tabItem.tabIcon,
                                contentDescription = tabItem.tabTitle
                            )
                        },
                        label = {
                            Text(tabItem.tabTitle)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(

            navController = navController,
            startDestination = selectedTabItem.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<HomeRoute> { Home() }

            composable<LibraryRoute> { Library() }

            composable<SettingsRoute> { Setting() }

            composable<NewDeckRoute> { NewDeck() }
        }
    }
}