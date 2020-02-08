package Flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
    Three ways:
    - try/catch
    - .catch() operator [catches all exceptions before it]
    - onCompletion [finally block]
 */

fun main() {
    runBlocking {
//        tryCatch()
//        catch()
        onCompletion()
    }
}

suspend fun tryCatch() {
    try {
        (1..3).asFlow()
            .onEach { check(it != 2) }
            .collect { println(it) }
    } catch (e: Exception) {
        println("Caught exception: $e")
    }
}

suspend fun catch() {
    (1..3).asFlow()
        .onEach { check(it != 2) }
        .catch { e -> println("Caught exception: $e") }
        .collect {
            println(it)
        }
}

suspend fun onCompletion() {

    (1..3).asFlow()
        .onEach { check(it != 2) }
        .onCompletion { cause ->
            cause?.let {
                println("Completed but exception occurred: $cause")
                return@onCompletion
            }
            println("Completed!")
        }
        .catch { e -> println("Caught exception: $e") }
        .collect {
            println(it)
        }
}