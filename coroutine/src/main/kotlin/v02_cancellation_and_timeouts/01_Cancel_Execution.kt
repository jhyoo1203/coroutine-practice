package v02_cancellation_and_timeouts

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        job.join() // waits for job's completion
        println("main: Now I can quit.")
    }
}
