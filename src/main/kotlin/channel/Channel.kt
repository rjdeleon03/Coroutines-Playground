package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

