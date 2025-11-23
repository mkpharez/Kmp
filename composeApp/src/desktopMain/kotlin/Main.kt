import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mkpharez.kmp.MainApp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP Desktop App",
    ) {
        MainApp()
    }
}
