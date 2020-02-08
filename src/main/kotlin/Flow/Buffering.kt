package Flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffering
    - In case processing a flow takes a long time
    - useful to accumulate flow values that can be processed later
 */
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generate().buffer()
                .collect {
                delay(300L)
                println(it)
            }
        }
        println("Finished in: $time ms")
    }
}

fun generate() = flow {
    for(i in 1..3) {
        delay(100L)
        emit(i)
    }
}