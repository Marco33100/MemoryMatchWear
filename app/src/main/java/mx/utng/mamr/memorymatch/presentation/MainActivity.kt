package mx.utng.mamr.memorymatch.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material3.MaterialTheme
import mx.utng.mamr.memorymatch.data.datasource.BestTimeDataSource
import mx.utng.mamr.memorymatch.data.repository.BestTimeRepositoryImpl
import mx.utng.mamr.memorymatch.domain.usecase.*
import mx.utng.mamr.memorymatch.presentation.board.BoardScreen
import mx.utng.mamr.memorymatch.presentation.board.MemoryViewModel
import mx.utng.mamr.memorymatch.presentation.theme.MemoryMatchWearTheme

// Fábrica para crear el ViewModel con todas sus dependencias
class MemoryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource  = BestTimeDataSource(context)
        val repository  = BestTimeRepositoryImpl(dataSource)
        return MemoryViewModel(
            shuffleBoard = ShuffleBoardUseCase(),
            flipCard     = FlipCardUseCase(),
            checkMatch   = CheckMatchUseCase(),
            saveBestTime = SaveBestTimeUseCase(repository),
            getBestTime  = GetBestTimeUseCase(repository),
        ) as T
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usamos la fábrica para obtener el ViewModel
            val vm: MemoryViewModel = viewModel(
                factory = MemoryViewModelFactory(applicationContext)
            )

            // Aplicamos tu tema y lanzamos el tablero del juego
            MemoryMatchWearTheme {
                BoardScreen(viewModel = vm)
            }
        }
    }
}