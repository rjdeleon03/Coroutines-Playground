package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Channel
    - queue of data
    - a coroutine can asynchronously put elements [.send(data)]
    - another can blockingly get elements [.receive(data)]
 */

fun main() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            for(x in 1..5)
                channel.send(x*x)
            channel.close()
        }

//        for(i in 1..5) {
//            println(channel.receive())
//        }

        // Only if channel is already closed
        for (i in channel) {
            println(i)
        }
    }
}

