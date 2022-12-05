import java.io.File

private val COUNT = 0
private val START = 1
private val END = 2

fun resolveDay5() {
    val inputFile = File("src/main/resources/inputDay5.txt")

    val hangar = mutableListOf(
        "", // flemme de faire -1 partout
        "RNPG",
        "TJBLCSVH",
        "TDBMNL",
        "RVPSB",
        "GCQSWMVH",
        "WQSCDBJ",
        "FQL",
        "WMHTDLFV",
        "LPBVMJF"
    )

    println("Exo 1 : ${resolve(hangar.map { it }.toMutableList(), inputFile, false)}")
    println("Exo 2 : ${resolve(hangar.map { it }.toMutableList(), inputFile, true)}")
}

private fun resolve(hangar: MutableList<String>, inputFile: File, keepOrder: Boolean): String {
    inputFile.forEachLine {
        val move = extractInts(it)

        val startStack = hangar[move[START]]
        val tmp = startStack.subSequence(startStack.length - move[COUNT], startStack.length).toString()
        hangar[move[START]] = startStack.subSequence(0, startStack.length-move[COUNT]).toString()
        hangar[move[END]] += if (keepOrder) tmp else tmp.reversed()
    }

    return hangar.filter { it.isNotBlank() }.joinToString(separator = "") { it.last().toString() }
}

private fun extractInts(input: String): List<Int> {
    return input.replace("[^0-9]".toRegex(), " ")
        .replace(" +".toRegex(), " ")
        .trim()
        .split(" ")
        .map { it.toInt() }
}