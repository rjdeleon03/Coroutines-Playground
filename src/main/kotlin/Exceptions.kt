import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main() {
    runBlocking {

        val handler = CoroutineExceptionHandler {_, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(handler) {
            println("Throwing exception from job!")
            throw IndexOutOfBoundsException("IndexOutOfBoundsException")
        }
        job.join() // Necessary to get the exception

        val deferred = GlobalScope.async {
            println("Throwing exception from async!")
            throw ArithmeticException("ArithmeticException")
        }
        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println("Exception handled: ${e.localizedMessage}")
        }
    }
}