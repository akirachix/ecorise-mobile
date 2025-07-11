package com.ecorise.ecorise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay

@Composable
fun AuthNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthNavRoutes.SPLASH
    ) {
        composable(AuthNavRoutes.SPLASH) {
            EcoRiseSplashScreen()
            LaunchedEffect(Unit) {
                    delay(2000)
                     navController.navigate(AuthNavRoutes.TEASER) { popUpTo(AuthNavRoutes.SPLASH) { inclusive = true } }

        }}
        composable(AuthNavRoutes.TEASER) {
            TeaserScreen(
                onGetStarted = { navController.navigate(AuthNavRoutes.TEASER_TWO) }
            )
        }
        composable(AuthNavRoutes.TEASER_TWO) {
            TeaserTwoScreen(
                onTeaserTwo = { navController.navigate(AuthNavRoutes.CREATE_ACCOUNT) }
            )
        }
        composable(AuthNavRoutes.CREATE_ACCOUNT) {
            CreateAccountScreen(
                onSubmit = { navController.navigate(AuthNavRoutes.TEASER) },
                onLoginClick = { navController.navigate(AuthNavRoutes.LOGIN) }
            )
        }
        composable(AuthNavRoutes.LOGIN) {
            LoginScreen(
                onLoginClick = { navController.navigate(AuthNavRoutes.TEASER) },
                onSignUpClick = { navController.navigate(AuthNavRoutes.CREATE_ACCOUNT) },
                onForgotPasswordClick = { navController.navigate(AuthNavRoutes.FORGOT_PASSWORD) }
            )

        }
        composable(AuthNavRoutes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(
                onBackToLogin = { navController.popBackStack() },
                onSend = { navController.navigate(AuthNavRoutes.PASSWORD) }
            )
        }
        composable(AuthNavRoutes.PASSWORD) {
            PasswordScreen(
                onSubmit = { navController.navigate(AuthNavRoutes.OTP) }
            )
        }
        composable(AuthNavRoutes.OTP) {
            OtpScreen(
                onSubmit = { navController.navigate(AuthNavRoutes.LOGIN) }
            )
        }
    }}

