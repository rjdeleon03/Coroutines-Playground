package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbersFlow = sendNewNumbers()
        println("Flow hasn't started yet...")
//        numbersFlow.collect {
//            println("Received $it")
//        }

        // Cancel flows via coroutine cancellation
        withTimeoutOrNull(1000L) {
            numbersFlow.collect { println(it) }
        }
    }
}

//fun sendNewNumbers() = listOf(1, 2, 3).asFlow()

fun sendNewNumbers() = flow {
    listOf(1, 2, 3).forEach {
        delay(400L)
        emit(it)
    }
}