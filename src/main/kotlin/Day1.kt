import java.io.File

fun resolveDay1() {
    val counts = getInput()

    val exo1 = counts.max()
    val exo2 = counts.sortedDescending().subList(0, 3).reduce { acc, i -> acc + i }

    println("Exo 1 : $exo1")
    println("Exo 2 : $exo2")
}

private fun getInput(): List<Int> {
    val inputFile = File("src/main/resources/inputDay1.txt")

    val counts = mutableListOf(0)
    var index = 0

    inputFile.forEachLine {
        if (it.isBlank()) {
            index++
            counts.add(0)
        } else {
            counts[index] += it.toInt()
        }
    }

    return counts
}