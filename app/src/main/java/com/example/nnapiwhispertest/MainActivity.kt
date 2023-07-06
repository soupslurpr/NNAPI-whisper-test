package com.example.nnapiwhispertest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nnapiwhispertest.ui.NnApiViewModel
import com.example.nnapiwhispertest.ui.theme.NNAPIWhisperTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NNAPIWhisperTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test(applicationContext)
                }
            }
        }
    }
}

@Composable
fun Test(applicationContext: Context, modifier: Modifier = Modifier, viewModel: NnApiViewModel = viewModel()) {
    Scaffold { innerPadding ->
        Column {
            Button(modifier = Modifier.padding(innerPadding), onClick = { viewModel.initialize(applicationContext) }) {
                Text(text = "INITIALIZE")
            }
            Button(
                onClick = {
                    viewModel.runInference()
                },
                modifier = Modifier.padding(innerPadding)
            ) {
                Text(viewModel.output + viewModel.elapsed)
            }
        }
    }
}