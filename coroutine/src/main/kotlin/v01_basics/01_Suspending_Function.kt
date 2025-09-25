package v01_basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

/**
 * runBlocking 방식 - 메인 스레드를 블로킹
 */
//fun main() = runBlocking(Dispatchers.Default) {
//    launch { greet() }
//
//    launch {
//        println("The CoroutineScope.launch() on the thread: ${Thread.currentThread().name}")
//        delay(1.seconds)
//    }
//
//    println("The runBlocking() on the thread: ${Thread.currentThread().name}")
//}

/**
 * suspend fun main() 방식 - 메인 스레드를 블로킹하지 않음 (코틀린 1.3 이상)
 *
 * - withContext(Dispatchers.Default) 사용 - 기본 스레드 풀에서 코루틴 실행
 * - 메인 스레드가 아닌 다른 스레드에서 실행됨
 */
suspend fun main() {
    withContext(Dispatchers.Default) {
        this.launch { greet() }

        this.launch {
            println("The CoroutineScope.launch() on the thread: ${Thread.currentThread().name}")
            delay(1.seconds)
        }

        println("The withContext() on the thread: ${Thread.currentThread().name}")
    }
}

suspend fun greet() {
    println("The greet() on the thread: ${Thread.currentThread().name}")
    delay(1.seconds)
}
