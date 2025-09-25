package v01_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

suspend fun main() {
    // coroutineScope: 자신의 모든 자식 코루틴이 완료될 때까지 대기
    coroutineScope {
        // launch: 자식 코루틴이 완료될 때까지 대기하지 않음
        this.launch {
            this.launch {
                delay(2.seconds)
                println("Child of the enclosing coroutine completed")
            }
            println("Child coroutine 1 completed")
        }
        this.launch {
            delay(1.seconds)
            println("Child coroutine 2 completed")
        }
    }

    println("Coroutine scope completed")
}
