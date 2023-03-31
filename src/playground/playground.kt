package playground

import java.io.File
import java.io.IOException

fun otelloGame(inputName: String, move: String): List<String> {
    val lines: List<String>
    try {
        lines = File(inputName).readLines().toMutableList()
    } catch (e: IOException) {
        throw IOException("Impossible to read file $inputName")
    }

    if (!move.matches(Regex("""\d\d""")))
        throw IllegalArgumentException("Wrong format of move $move")

    var field = arrayOf<Array<Char>>()
    val allowedSymbols = listOf('-', '*', 'o')
    for (line in lines) {
        var row = arrayOf<Char>()
        for (symbol in line) {
            if (symbol in allowedSymbols) row += symbol
            else throw IllegalArgumentException("Not allowed symbol $symbol on a field")
        }
        field += row
    }


    val coordY = move[0].toString().toInt() - 1
    val coordX = move[1].toString().toInt() - 1
    if (coordY > 7 || coordX > 7)
        throw IllegalArgumentException("Coordinates are out of field: $coordX $coordY")

    if (field[coordY][coordX] != '-')
        throw IllegalArgumentException("Cell with coords $coordY $coordX is not free")
    val height = 8
    val width = 8
    return possibleSteps(field, coordX, coordY, height, width)
}

fun possibleSteps(field: Array<Array<Char>>, coordX: Int, coordY: Int, height: Int, width: Int): List<String> {
    val moveColumn = mutableListOf<Char>()
    for (line in field) {
        moveColumn.add(line[coordX])
    }
    val moveRow = field[coordY]
    val res = mutableListOf<String>()
    res.addAll(getResult(moveColumn.toCharArray(), 0, coordY, Regex("(-*)(\\*)+o+"), coordX))
    res.addAll(getResult(moveColumn.toCharArray(), coordY + 1, moveColumn.size, Regex("o+(\\*)+(-*)"), coordX))
    res.addAll(getResult(moveRow.toCharArray(), 0, coordX, Regex("(-*)(\\*)+o+"), null, coordY))
    res.addAll(getResult(moveRow.toCharArray(), coordX + 1, moveRow.size, Regex("o+(\\*)+(-*)"), null, coordY))

    return res.toList()
}


fun getResult(
    moveData: CharArray,
    sliceStart: Int,
    sliceEnd: Int,
    regex: Regex,
    coordX: Int? = null,
    coordY: Int? = null
): List<String> {
    val res = mutableListOf<String>()
    val slice = moveData.slice(sliceStart until sliceEnd)
    if (slice.joinToString(separator = "").matches(regex)) {
        (sliceStart until sliceEnd).forEach { i ->
            if (moveData[i] == 'o') {
                when {
                    coordX != null -> res.add("${i + 1}${coordX + 1}")
                    else -> res.add("${coordY!! + 1}${i + 1}")
                }
            }
        }
    }
    return res.toList()
}