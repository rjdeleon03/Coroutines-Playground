package flows

import kotlinx.coroutines.Dispatchers
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

    .take
    - use only certain number of values, disregard the rest

    terminal flow (collect, toList, toSet, reduce)
    - convert the flow into a collection
    - reduce: perform operation with an accumulator

    .flowOn
    - switch the context on which the flow is emitted
 */

fun main() {
    runBlocking {
//        mapOperator()
//        filterOperator()
//        transformOperator()
//        takeOperator()
//        reduceOperator()
        flowOnOperator()
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

suspend fun reduceOperator() {
    val size = 10
    val factorial = (1..size).asFlow()
        .reduce { accumulator, value ->
            println("A: $accumulator --- V: $value")
            accumulator * value
        }
    println(factorial)

}

suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}