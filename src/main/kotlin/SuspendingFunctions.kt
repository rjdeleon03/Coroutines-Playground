import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls = 0

fun main() {
    GlobalScope.launch {
        completeMessage()
    }

    GlobalScope.launch {
        improveMessage()
    }

    print("Hello, ")
    Thread.sleep(2000L)
    print("functionCalls: $functionCalls")
}

suspend fun completeMessage() {
    delay(500L)
    println("World!")
    functionCalls++
}

suspend fun improveMessage() {
    delay(1000L)
    println("Suspending functions are cool!")
    functionCalls++
}