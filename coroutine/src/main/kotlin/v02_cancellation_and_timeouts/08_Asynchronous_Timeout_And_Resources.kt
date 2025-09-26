package v02_cancellation_and_timeouts

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

var acquired = 0

class Resource {
    init { acquired++ } // 리소스를 획득한다.
    fun close() { acquired-- } // 리소스를 해제한다.
}

fun main() {
    runBlocking {
        repeat(10_000) { // 1만개의 Coroutine을 실행한다.
            launch {
                val resource = withTimeout(60) { // Timeout 기준시간을 60ms로 설정한다.
                    delay(50) // 50ms 동안 delay한다.
                    Resource() // 리소스를 획득하고 withTimeout 블록의 return 값으로 리소스를 반환한다.
                }
                resource.close() // 리소스를 해제한다.
            }
        }
    }
    // runBlocking 바깥은 모든 Coroutine 들이 완료된 다음 실행횐다.
    println(acquired) // 획득되고 해제되지 않은 리소스들의 개수를 출력한다.
}
