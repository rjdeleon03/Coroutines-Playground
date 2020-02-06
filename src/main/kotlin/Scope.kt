import kotlinx.coroutines.*

suspend fun main() {
    println("BLOCKING...")
    runBlocking {
        launch {
            delay(1000)
            println("Task from runBlocking!")
        }
    }

    GlobalScope.launch {
        delay(500)
        println("Task from GlobalScope!")
    }

    coroutineScope {
        launch {
            delay(1500L)
            println("Task from coroutineScope")
        }
    }
    println("CONTINUING...")
}