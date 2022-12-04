import java.io.File

fun resolveDay4() {
    val inputFile = File("src/main/resources/inputDay4.txt")

    var scoreExo1 = 0
    var scoreExo2 = 0

    inputFile.forEachLine {
        val ranges = getRanges(it)

        if (ranges.first.contains(ranges.second) || ranges.second.contains(ranges.first)) {
            scoreExo1 += 1
        }

        if (ranges.first.overlaps(ranges.second) || ranges.second.overlaps(ranges.first)) {
            scoreExo2 += 1
        }
    }

    println("Exo 1 : $scoreExo1")
    println("Exo 2 : $scoreExo2")
}

private fun getRanges(line: String): Pair<IntRange, IntRange> {
    val rangesStr = line.split(",")

    val ranges = rangesStr.map { rangeStr ->
        rangeStr.split("-").let {
            IntRange(it[0].toInt(), it[1].toInt())
        }
    }

    return Pair(ranges[0], ranges[1])
}

private fun IntRange.contains(other: IntRange) = other.first in this && other.last in this

private fun IntRange.overlaps(other: IntRange) = other.first in this || other.last in this