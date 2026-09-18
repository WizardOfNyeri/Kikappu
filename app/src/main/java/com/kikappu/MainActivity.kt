package com.kikappu


 import android.annotation.SuppressLint
 import android.os.Bundle
 import androidx.activity.ComponentActivity
 import androidx.activity.compose.setContent
 import androidx.compose.foundation.Image
 import androidx.compose.foundation.background
 import androidx.compose.foundation.clickable
 import androidx.compose.foundation.layout.Arrangement
 import androidx.compose.foundation.layout.Box
 import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.fillMaxSize
 import androidx.compose.foundation.layout.offset
 import androidx.compose.material3.Button
 import androidx.compose.material3.Text
 import androidx.compose.runtime.Composable
 import androidx.compose.ui.Alignment
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.draw.scale
 import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.unit.dp
 import androidx.navigation.NavHostController
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.compose.rememberNavController
 import androidx.wear.compose.material.ExperimentalWearMaterialApi
 import com.kikappu.ui.theme.KikappuTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KikappuTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "HomeScreen") {
                    composable("HomeScreen") {
                        HomeScreen(navController) {
                            // When the user clicks the button on the home screen, this will be triggered.
                            navController.navigate("Im_Hungry")
                        }
                    }

                    composable("ImHungryScreen") {
                        ImHungryScreen() {
                            // When the user clicks the button on the profile screen, this will be triggered.
                            navController.navigate("OrderScreen")
                        }

                    }

                    composable("OrderScreen") {
                        OrderScreen() {
                            // When the user clicks the button on the profile screen, this will be triggered.
                            navController.navigate("DeliveryScreen")
                        }

                    }

                    composable("DeliveryScreen") {
                        DeliveryScreen() {
                            // When the user clicks the button on the profile screen, this will be triggered.
                            navController.navigate("HomeScreen")
                        }

                    }

                    composable("UploadMealScreen") {
                        UploadMealScreen()  {
                            // When the user clicks the button on the profile screen, this will be triggered.
                            //navController.navigate("HomeScreen")
                        }

                    }

                }
            }
        }
    }

    @Composable
    fun HomeScreen(navController: NavHostController, onClick: () -> Unit) {

        val homeScreenBackground = painterResource(R.drawable.homescreenbackground)
        val imHungryButton = painterResource(id = R.drawable.imhungrybutton)
        val cookedExtraButton =  painterResource(id = R.drawable.cookedextrabutton)

        Box(modifier = Modifier){
                Image(
                    painter = homeScreenBackground,
                    contentDescription = "Hello Rafiki, welcome to Kikapp, are you hungry (centre button) or have you cooked extra? (top Button)",
                    modifier = Modifier.fillMaxSize()
                )



            Image(
                painter = cookedExtraButton,
                contentDescription = "Cooked something extra to sell or give away",
                modifier = Modifier
                    .offset(x = 150.dp, y = 210.dp)
                    .scale(1.5F)
                    .clickable {
                        // This safely opens the URL in the system browser
                        navController.navigate("UploadMealScreen")
                    }
            )

            Image(
                painter = imHungryButton,
                contentDescription = "Order a quick home made meal",
                modifier = Modifier
                    .offset(x = 150.dp, y = 480.dp)
                    .scale(1.5F)
                    .clickable {
                        // This safely opens the URL in the system browser
                        navController.navigate("ImHungryScreen")
                    }
            )

        }


    }

    @OptIn(ExperimentalWearMaterialApi::class)
    @Composable
    fun ImHungryScreen(onClick: () -> Unit) {

        val imageRoll = painterResource(R.drawable.test_image)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDDFC1)),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {


            //Slide Button Start


            //End

            Image(
                painter = imageRoll,
                contentDescription = "Order a quick home made meal",
                modifier = Modifier
                    .scale(1.5F)

            )


            Button(onClick = { onClick() }) {
                Text("Order Now")
            }


        }
    }

    @Composable
    fun OrderScreen(onClick: () -> Unit) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDDFC1)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = "Order Screen!")
            Button(onClick = { onClick() }) {
                Text("Order Now!")
            }
        }
    }


    @Composable
    fun DeliveryScreen(onClick: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDDFC1)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = "Delivery Screen!")
            Button(onClick = { onClick() }) {
                Text("Go to Home")
            }
        }
    }

    @Composable
    fun UploadMealScreen(onClick: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDDFC1)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = "Vendor Registration Coming Soon!")
            Button(onClick = { onClick() }) {
                Text("Go to Home")
            }
        }
    }


}
