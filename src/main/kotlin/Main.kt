import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println("Hello World!")

    //measure("resolveDay1") { resolveDay1() }
    //measure("resolveDay2") { resolveDay2() }
    //measure("resolveDay3") { resolveDay3() }
    //measure("resolveDay4") { resolveDay4() }
    measure("resolveDay5") { resolveDay5() }
}

fun measure(text: String, code: () -> Unit) {
    val time = measureTimeMillis(code)
    println("execution time of ${text}: ${time}ms")
}