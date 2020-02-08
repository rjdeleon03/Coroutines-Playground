package Flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Operators
    - take an input flow, transform it and return an output flow
    - cold
    - returning flow is synchronous

    .map
    - takes the input params from flow, and maps them for transformation

    .filter
    - filters the values we get based on some predicate

    .transform
    - transforms the values to anything we want
 */

fun main() {
    runBlocking {
//        mapOperator()
//        filterOperator()
        transformOperator()
    }
}

suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }
        .collect {
            println(it)
        }
}

suspend fun filterOperator() {
    (1..10).asFlow()
        .filter {
            it % 2 != 0
        }
        .collect {
            println(it)
        }
}

suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting string value: $it")
            emit(it)
        }
        .collect {
            println(it)
        }
}