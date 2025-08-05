package ir.kidzyland.mysample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.kidzyland.mysample.ui.screens.ChatScreen
import ir.kidzyland.mysample.ui.theme.ChatterBoxTheme
import ir.kidzyland.mysample.viewmodels.ChatViewModel
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ChatViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatterBoxTheme {
                ChatScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatterBoxTheme {
//        ChatScreen(viewModel = viewModel)
    }
}