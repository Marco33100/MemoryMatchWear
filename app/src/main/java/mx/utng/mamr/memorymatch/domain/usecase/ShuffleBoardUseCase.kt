package mx.utng.mamr.memorymatch.domain.usecase

import mx.utng.mamr.memorymatch.domain.model.Card
import mx.utng.mamr.memorymatch.domain.model.CardSymbol

class ShuffleBoardUseCase {
    /** Crea 12 tarjetas (2 de cada símbolo) mezcladas aleatoriamente. */
    operator fun invoke(): List<Card> =
        CardSymbol.values()
            .flatMap { symbol -> listOf(symbol, symbol) } // duplicar cada símbolo
            .shuffled()                                   // mezclar
            .mapIndexed { index, symbol ->                // asignar id
                Card(id = index, symbol = symbol)
            }
}
