import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf(0.0)

    fun calculateBmi() {
        val heightValue = height.toDoubleOrNull() ?: 0.0
        val weightValue = weight.toDoubleOrNull() ?: 0.0
        if (heightValue > 0 && weightValue > 0) {
            bmi = weightValue / (heightValue * heightValue)
        } else {
            bmi = 0.0
        }
    }
}