package v01_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

/**
 * 코루틴 vs 스레드
 *
 * - 50,000개의 코루틴을 실행해도 oom이 발생하지 않음
 * - 반면, 50,000개의 스레드를 실행하면 oom이 발생함
 */
suspend fun main() = coroutineScope {
    repeat(50_000) {
        this.launch {
            delay(5.seconds)
            print(".")
        }
    }
}

//fun main() {
//    repeat(50_000) {
//        thread {
//            Thread.sleep(5000L)
//            print(".")
//        }
//    }
//}
