package com.example.fortesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fortesting.screens.DetailScreen
import com.example.fortesting.screens.MainScreen
import com.example.fortesting.screens.WelcomeScreen
import com.example.fortesting.ui.theme.ForTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForTestingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p7,
                        R.drawable.p8,
                        R.drawable.p9,
                        R.drawable.p10
                    )
                    val names = arrayOf(
                        "Rihhana",
                        "Gigi Hadid",
                        "Kristien Stewart",
                        "Emma Watson",
                        "Jackie Chan",
                        "Mr Bean",
                        "Angelina Jolie",
                        "Charlie Chaplin",
                        "Mr Robot",
                        "Tom Hardy"
                    )
                    val ingredients = arrayOf(
                        "it’s hard to believe that rihanna is only 37 years old. yet within the 10 years since the start of her musical career, she’s become the youngest solo artist to score 14 no",
                        "born April 23, 1995) is an American fashion model and television personality.",
                        "(born April 9, 1990) is an American actress and director.",
                        "(born 15 April 1990) is an English actress.",
                        "(born Chan Kong-sang;[b] 7 April 1954), known professionally as Jackie Chan,[c] is a Hong Kong martial artist, actor and filmmaker, known for his slapstick, acrobatic fighting style, comic timing, and innovative stunts",
                        "Mr. Bean, the title character and protagonist, is a childish buffoon who brings various unusual schemes and contrivances to everyday tasks.",
                        "born Angelina Jolie Voight, /ˈvɔɪt/, June 4, 1975) is an American actress, filmmaker, and humanitarian. The recipient of numerous accolades, including an Academy Award, a Tony Award and three Golden Globe Awards, she has been named Hollywood's highest-paid actress multiple times.",
                        "(1889–1977) was an English internationally renowned Academy Award-winning comic actor, filmmaker, and composer who was best known for his career in Hollywood motion pictures from his debut in 1914 until 1952, he however subsequently appeared in two films in his native England.",
                        "Mr. Robot is an American psychological techno-thriller television series created by Sam Esmail for USA Network. It stars Rami Malek as Elliot Alderson, a cybersecurity engineer and hacker with social anxiety disorder, clinical depression, and dissociative identity disorder. Elliot is recruited by an insurrectionary anarchist known as \"Mr. Robot\", played by Christian Slater, to join a group of hacktivists called \"fsociety\".",
                        "(born 15 September 1977) is an English actor. After studying acting at the Drama Centre London he made his film debut in Ridley Scott's Black Hawk Down in 2001.",
                    )
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "WelcomeScreen") {
                        composable("WelcomeScreen") {
                            WelcomeScreen(navController = navController)
                        }
                        composable("MainScreen") {
                            MainScreen(imageId, names, ingredients, navController)
                        }
                        composable(
                            "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument("index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index ->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                ingredients = ingredients,
                                itemIndex = index.arguments?.getInt("index"),
                            )

                        }

                    }

                }


            }


        }
    }


}