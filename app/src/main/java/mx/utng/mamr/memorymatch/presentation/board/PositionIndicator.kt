package mx.utng.mamr.memorymatch.presentation.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PositionIndicator(stepCount: Int, currentStep: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(stepCount) { index ->
            val color = if (index < currentStep) Color(0xFF4CAF50) else Color.Gray.copy(alpha = 0.4f)
            Box(modifier = Modifier.padding(2.dp).size(6.dp).clip(CircleShape).background(color))
        }
    }
}