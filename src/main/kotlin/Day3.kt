import java.io.File

fun resolveDay3() {
    val inputFile = File("src/main/resources/inputDay3.txt")

    resolveExo1(inputFile)
    resolveExo2(inputFile)
}

private fun resolveExo1(inputFile: File) {
    var score = 0

    inputFile.forEachLine {
        val firstCompartment = it.subSequence(0, it.length / 2).toString()
        val secondCompartment = it.subSequence(it.length / 2, it.length).toString()

        val firstCounts = getItemCount(firstCompartment)
        val secondCounts = getItemCount(secondCompartment)

        firstCounts.forEach { (priority, _) ->
            if (secondCounts.containsKey(priority)) {
                score += priority
            }
        }
    }

    println("Exo 1 : $score")
}

private fun resolveExo2(inputFile: File) {
    var score = 0

    var groupIndex = 0
    val elvesItems = arrayOf(mapOf<Int, Int>(), mapOf(), mapOf())

    inputFile.forEachLine { sack ->
        elvesItems[groupIndex] = getItemCount(sack)

        groupIndex = (groupIndex + 1) % 3

        if (groupIndex == 0) {
            elvesItems[0].keys.firstOrNull { elvesItems[1].containsKey(it) && elvesItems[2].containsKey(it) }?.let { priority ->
                score += priority
            }
        }
    }

    println("Exo 2 : $score")
}

private fun getItemCount(compartment: String): Map<Int, Int> {
    val result = mutableMapOf<Int, Int>()

    compartment.forEach { item ->
        result.putIfAbsent(item.toPriority(), 1)?.let {
            result[item.toPriority()] = it + 1
        }
    }

    return result
}

private fun Char.toPriority(): Int {
    return this.code - if (this.isUpperCase()) {
        38
    } else {
        96
    }
}