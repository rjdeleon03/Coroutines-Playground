package channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/*
    Channel Producer
    - Allows a data source to create and return a channel
    - Needs a coroutine scope
 */

fun main() {
    runBlocking {
//        val channel = produce {
////            for(x in 1..5) {
////                send(x * x)
////            }
////        }
////
////        for (y in channel) {
////            println(y)
////        }
        produceSquares().consumeEach {
            println(it)
        }
    }
}

fun CoroutineScope.produceSquares() = produce {
    for(x in 1..5) {
        send(x * x)
    }
}

