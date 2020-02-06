import kotlinx.coroutines.*

fun main() {
     runBlocking {
//         launch(Dispatchers.Main) {
//            println("Main dispatcher -- Thread: ${Thread.currentThread().name}")
//         }

         launch(Dispatchers.Unconfined) {
             println("Unconfined dispatcher (1) -- Thread: ${Thread.currentThread().name}")
             delay(100L) // Thread switches when resumed
             println("Unconfined dispatcher (2) -- Thread: ${Thread.currentThread().name}")
         }

         launch(Dispatchers.IO) {
             println("IO dispatcher -- Thread: ${Thread.currentThread().name}")
         }

         launch(Dispatchers.Default) {
             println("Default dispatcher -- Thread: ${Thread.currentThread().name}")
         }

         launch(newSingleThreadContext("myThread")) {
             println("newSingleThreadContext -- Thread: ${Thread.currentThread().name}")
         }
     }
}