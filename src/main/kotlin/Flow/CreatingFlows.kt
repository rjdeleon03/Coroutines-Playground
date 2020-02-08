package Flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbersFromFlow().collect {
            println("Received $it")
        }
    }
}

fun sendNumbers() = flow {
    for (i in 1 .. 10) {
        emit(i)
    }
}

fun sendNumbersFromList() = listOf(1, 2, 3, 4, 5).asFlow()

fun sendNumbersFromFlow() = flowOf(1, 2, 3, 4, 5)