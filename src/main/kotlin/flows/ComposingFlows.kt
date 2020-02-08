package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Join 2 flows together:

    .zip
    - matches corresponding values of two flows (e.g. first val with first val, second, etc...)

    .combine
    - combine the latest value of one flow with the latest value of the other

 */
fun main() {
    runBlocking {
//        zip()
        combine()
    }
}

suspend fun zip() {
    val english = flowOf("One", "Two", "Three")
    val french = flowOf("Un", "Deux", "Troix")

    english.zip(french) {a, b -> "$a in French is $b"}
        .collect {
            println(it)
        }
}

suspend fun combine() {
    val numbers = (1..5).asFlow()
        .onEach {
            delay(300L)
        }
    val values = flowOf("One", "Two", "Three", "Four", "Five")
        .onEach {
            delay(400L)
        }
    numbers.combine(values) {a, b ->
        "$a --> $b"
    }.collect {
        println(it)
    }
}