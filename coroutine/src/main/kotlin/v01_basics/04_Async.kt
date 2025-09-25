package v01_basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

/**
 * async, await
 *
 * - async: return 값이 있는 deferred 개념
 * - await(): 비동기 작업의 결과를 기다림
 */
suspend fun main() = withContext(Dispatchers.Default) { // this: CoroutineScope
    val firstPage = this.async {
        delay(50.milliseconds)
        "First page"
    }

    val secondPage = this.async {
        delay(100.milliseconds)
        "Second page"
    }

    val pagesAreEqual = firstPage.await() == secondPage.await()
    println("Pages are equal: $pagesAreEqual")
}
