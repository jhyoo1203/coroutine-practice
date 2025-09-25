package v01_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

/**
 * launch: return 값이 없는 job 개념
 */
suspend fun main() = coroutineScope {
    this.launch {
        delay(100.milliseconds)
        println("Sending notification in background")
    }

    println("Scope continues")
}
