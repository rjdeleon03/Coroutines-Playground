package channel

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Ticker Channel
    - periodically produces a unit after a given delay
    - optional initial delay
 */

fun main() {
    runBlocking {
        val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0)
        launch {
            val startTime = System.currentTimeMillis()
            tickerChannel.consumeEach {
                val delta = System.currentTimeMillis() - startTime
                println("Received tick after $delta")
            }
        }

        delay(1000L)
        println("Done")
        tickerChannel.cancel()
    }
}