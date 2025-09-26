package v02_cancellation_and_timeouts

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

suspend fun main() {
    coroutineScope {
        val result = withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
            "Done" // will get cancelled before it produces this result
        }
        println("Result is $result")
    }
}
