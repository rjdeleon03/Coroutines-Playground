package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Buffered channel
    - has limited capacity
    - when capacity is reached, sender is paused
    - when capacity is available, new values can be sent
 */

fun main() {
    runBlocking {
        val channel = Channel<Int>(4)
        val sender = launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }

        repeat(10) {
            delay(1000)
            println("Received: ${channel.receive()}")
        }
        sender.cancel()
    }
}
