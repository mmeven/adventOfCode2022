import java.io.File

fun resolveDay6() {
    val input = File("src/main/resources/inputDay6.txt").readText()

    println("Exo 1 : ${resolve(input, 4)}")
    println("Exo 2 : ${resolve(input, 14)}")
}

private fun resolve(input: String, markerSize: Int): Int {
    var result = -1
    for (index in 0 .. input.length - markerSize) {
        if (input.subSequence(index, index + markerSize).toSet().size == markerSize) {
            result = index + markerSize
        }

        if (result != -1) break
    }

    return result
}