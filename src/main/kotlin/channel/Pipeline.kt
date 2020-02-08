package channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/*
    Pipeline
    - development pattern
    - where one channel output is used as input to another channel
    - chaining
 */

fun main() {
    runBlocking {
        val numbers = produceNumbers()
        val squares = square(numbers)
        for(i in 1..5) {
            println(squares.receive())
        }
        println("Done")
        coroutineContext.cancelChildren()
    }
}

fun CoroutineScope.produceNumbers() = produce {
    var x = 1
    while(true)
        send(x++)
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
    for (x in numbers)
        send(x * x)
}