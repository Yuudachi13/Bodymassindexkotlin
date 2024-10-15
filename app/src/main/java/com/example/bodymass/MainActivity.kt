package com.example.bodymass

import BmiViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bodymass.ui.theme.BodymassTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiCalculatorScreen()
        }
    }
}
@SuppressLint("DefaultLocale")
@Composable
fun BmiCalculatorScreen(bmiViewModel: BmiViewModel = viewModel()) {
    Column(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Body mass index",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(

            value = bmiViewModel.height,
            onValueChange = {
                bmiViewModel.height = it
                bmiViewModel.calculateBmi()
            },
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bmiViewModel.weight,
            onValueChange = {
                bmiViewModel.weight = it
                bmiViewModel.calculateBmi()
            },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Body mass index is ${String.format("%.2f", bmiViewModel.bmi)}",
        )
    }
}