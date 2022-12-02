import java.io.File

fun resolveDay2() {
    val inputFile = File("src/main/resources/inputDay2.txt")

    var scoreExo1 = 0
    var scoreExo2 = 0
    inputFile.forEachLine {
        scoreExo1 += roundScoreTableExo1[it]!!
        scoreExo2 += roundScoreTableAlt[it]!!
    }

    println("Exo 1 : $scoreExo1")
    println("Exo 2 : $scoreExo2")
}

private val roundScoreTableExo1 = mapOf(
    "A X" to 4,
    "A Y" to 8,
    "A Z" to 3,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 7,
    "C Y" to 2,
    "C Z" to 6
)

private val roundScoreTableAlt = mapOf(
    "A X" to 3,
    "A Y" to 4,
    "A Z" to 8,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 2,
    "C Y" to 6,
    "C Z" to 7
)