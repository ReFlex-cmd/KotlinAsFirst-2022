package playground

import lesson8.task1.Point
import ru.spbstu.ktuples.Variant
import ru.spbstu.wheels.NullableMonad.map
import ru.spbstu.wheels.joinToString
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

//data class Point(val x: Double, val y: Double) {
//    fun distance(other: Point): Double = sqrt(sqr(x - other.x) + sqr(y - other.y))
//}

///*
//В файле с именем inputName содержатся результаты гонок Формулы-1 в формате:
//Гран-при Австралии:
//Л. Хэмилтон, Мерседес, 8
//В. Боттас, Мерседес, 6
//Л. Норрис, Макларен, 5
//Д. Риккардо, Макларен, 4
//Ш. Леклер, Феррари, 3
//С. Феттель, Феррари, 2
//М. Ферстапен, Ред Булл, 1
//
//Гран-при России:
//А. Албон, Ред Булл, 8
//Л. Хэмилтон, Мерседес, 5
//С. Феттель, Феррари, 4
//Ш. Леклер, Феррари, 2
//В. Боттас, Мерседес, 1
//
//В первой строке содержится название гран-при, далее идет список пилотов.
//Каждая строка этого списка начинается с имени и фамилии пилота, далее через
//запятую идёт название его команды и число набранных им очков.
//В команде может быть не более трёх пилотов, число Гран-при и команд - любое.
//
//"Удовлетворительно" -- определить команду-победителя и число её очков
//(чемпионат состоит из всех указанных в файле Гран-при). В примере: Мерседес, 20
//
//"Хорошо" -- отсортировать команды по набранному количеству очков,
//а при одинаковом числе очков -- по алфавиту.
//В примере: Мерседес, 20, Феррари, 11, Макларен, 9, Ред Булл, 9
//
//"Отлично" -- отсортировать команды тем же образом.
//Для каждой команды определить, сколько очков набрал каждый из её пилотов.
//В примере: Мерседес, 20 (Л. Хэмилтон 13, В. Боттас 7),
//Феррари, 11 (С. Феттель, 6, Ш. Леклер, 5), Макларен, 9 (Д. Риккардо, 9),
//Ред Булл, 9 (А. Албон, 8, М. Ферстаппен, 1),
//
//Предложить имя и тип результата функции. Кроме функции
//следует написать тесты, подтверждающие её работоспособность
// */
//
//fun f1Tournament(inputName: String): Any {
//    val reader = File(inputName).readLines()
//    val teamTable = mutableMapOf<String, Int>()
//    var team = ""
//    var score = 0
//    for (line in reader) {
//        if (Regex("""([А-Я]. [А-Яа-я]+, .*)""").matches(line)) {
//            team = Regex("""(([^А-Я.][,]) [А-Яа-я ]+)""").find(line)!!.value.substring(3)
//            score = Regex("""\d+""").find(line)!!.value.toInt()
//            if (team.isNotEmpty() && team !in teamTable.keys) {
//                teamTable[team] = 0
//            }
//            if (team in teamTable.keys) {
//                teamTable[team] = teamTable[team]!! + score
//            }
//        }
//
//    }
//    val sortedScoreTable = teamTable.toList().sortedBy { (_, value) -> value }.reversed().toMap()
//    val listTable = sortedScoreTable.toList()
//    val result = mutableListOf<Pair<String, Int>>()
//    for (index in 0 until listTable.size - 1) {
//        val team = listTable[index]
//        val secondTeam = listTable[index + 1]
//        if (team.second == secondTeam.second) {
//            if (team.first < secondTeam.first) {
//                result.add(team)
//                result.add(secondTeam)
//            } else {
//                result.add(secondTeam)
//                result.add(team)
//            }
//        }
//        if (team !in result) result.add(team)
//    }
//    if (listTable.last() !in result) {
//        result.add(listTable.last())
//    }
//    var str = ""
//    for ((first, second) in result) {
//        str += "$first, "
//        str += "$second, "
//    }
//
//    return str.substring(0, str.lastIndex - 1)
//}
//
//
///*
//В файле с менем inputName содержатся
//маршруты общественного транспорта в следующем формате:
//
//троллейбус 15 уп. Железнодорожная > ул. Садовая > ул. Пионерская > Московское ш.
//автобус 17 ул. Железнодорожная > ул. Садовая » ул. Центральная > Парк отдыха
//трамвай 3 Парк отдыха > ул. Дворцовая > Проспект мира
//автобус 4 ул. Железнодорожная > Путепровод > Аэропорт
//троллейбус 4 Путепровод > ул. Центральная > аллея Культуры > Московское ш.
//
//В каждой строчке файла указан вид транспорта (автобус, троллейбус, трамвай),
//номер маршрута и список остановок, разделённых знаком ». Считается, что кажды
//маршрут действует и в прямом, и в обратном направлении.
//
//"Удовлетворительно" - построить прямой маршрут (без пересадок) от станции sre
//до станции dst. Например: src-"Парк отдыха", dst-"ул. Дворцовая
//ответ="трамвай 3" (вернуть любой возможный вариант)
//
//При нарушении форматов входных данных следует выбрасывать
//исключение IllegalArgumentException. При невозможности
//прочитать файл выбрасывать исключение IOException.
//
//Предложить имя и тил результата функции. Кроме функции
//следует написать тесты, подтверждающие её работоспособность.
//*/
//
//fun wayAway(inputName: String, src: String, dst: String): String = TODO()
// /*   try {
//        val reader = File(inputName).readLines()
//        val paths = mutableMapOf<String, List<String>>()
//        for (line in reader) {
//            if (!Regex("""([А-я]+ \d+)(\s*([А-я]+. |[А-я])+>)+([А-я]*)\s[А-я].*""").matches(line)) throw IllegalArgumentException()
//            val nameOfRoute = Regex("""[А-я]+ \d+""").find(line)!!.value
//             val routeInStops = Regex(""" [А-я. ]+""").findAll(line)!!.map { it.value.trim() }.toMutableList()
//            paths[nameOfRoute] = routeInStops
//        }
//        for (key in paths.keys) if (src in paths[key]!! && dst in paths[key]!!) return key
//    } catch (e: FileNotFoundException) {
//        throw IOException()
//    }
//    throw IllegalArgumentException()
//}*/
//
///*
//В файле с именем inputName задано поле 8x8 с шашками двух цветов * и о
//
//Пример поля                     Пример хода (65)
//--------                        --------
//---о----                        ---о----
//--оо*---                        --оо*---
//--*оо---                        --*о^---
//---*о---                        ---*^---
//---*----                        ---*^---
//--------                        --------
//--------                        --------
//
//Здесь - пустая клетка, * черная шашка, о белая шашка
//Параметром move задана клетка, куда ставится шашка *, в виде строки "65",
//где 6 -- номер строки поля (сверху вниз, с 1), 5 -- номер столбца (слева направо, с 1).
//
//"Удовлетворительно" - определить, возможен такой ход или нет. Ход в заданную
//клетку возможен, если рядом с ней по горизонтали или вертикали расположена одна
//или несколько шашка о (без пустых клеток), а за ними -- шашка * (тоже без пустых).
//В игре "Отелло" при этом белые шашки оказываются между черными и меняют цвет.
//В примере хода выше клетка хода отмечена как Т, окруженные шашки как ^.
//Например, ход 65 возможен, так как шашки 55 и 45 -- белые, а за ними шашка 35 -- черная.
//Также возможен ход 32, так как 33 и 34 - белые, 35 -- черная,
//ход 56, так как 55 -- белая, 45 -- черная также; возможны ходы 14, 45.
//Остальные ходы в данном примере не являются возможными
//
//"Хорошо" для возможного хода вместо true вернуть список белых шашек,
//меняющих цвет, например (55, 45) для хода 65 или (55) для хода 56.
//Для невозможного хода вернуть пустой список.
//Написать универсальный код для четырех направлений (не дублировать код четыре раза).
//
//Диагональные ходы (разрешенные в настоящем Отелло) можно не рассматривать.
//При ошибке в формате поля или хода бросить IllegalArgumentException
//*/
//
//fun foo(inputName: String, move: String): Any = TODO()
//
///*
//В файле с именем inputName содержится список строк следующего вида (пример)
//    1 Первое действие
//    3 Интерлюдия
//    6 Послесловие
//Каждая строка списка начинается с положительного номера, далее через пробел
//идёт произвольная строка. Номера идут по возрастанию, но не обязательно подряд.
//В параметре changes содержится список изменений, которые следует применить
//к тексту, возможный формат изменений приведён ниже. Отредактировать текст
//в соответствии со списком изменений и вывести его в файл с именем outputName
//"Удовлетворительно" -- поддержать изменения вида "2 Следующий акт",
//"5 Вторая глава". Данные строки следует вставить в исходный список, сохранив
//правильный порядок номеров. Например, для указанных изменений:
//    1 Первое действие
//    2 Следующий акт
//    3 Интерлюдия
//    5 Вторая глава
//    6 Послесловие
//При нарушении формата входных данных следует выбрасывать
//исключение IllegalArgumentException.
//Самостоятельно предложить имя функции. Кроме функции
//следует написать тесты, подтверждающие её работоспособность.
// */
//
//fun theatre(inputName: String, outputName: String, changes: List<String>) {
//    val reader = File(inputName).readLines()
//    val writer = File(outputName).bufferedWriter()
//    for (index in 0 until reader.size - 1) {
//        val line = reader[index]
//        if (!Regex("""\d [А-я\s*]*""").matches(line)) throw IllegalArgumentException()
//        writer.write(line)
//        writer.newLine()
//        for (change in changes) {
//            if (!Regex("""\d [А-я\s*]*""").matches(change)) throw IllegalArgumentException()
//            if (line[0].toInt() < change[0].toInt() && reader[index + 1][0].toInt() > change[0].toInt()) {
//                writer.write(change)
//                writer.newLine()
//            }
//        }
//    }
//    if (!Regex("""\d [А-я\s*]*""").matches(reader.last())) throw IllegalArgumentException()
//    writer.write(reader.last())
//    writer.close()
//}
//
///* В файле с именем inputName задана таблица действительных чисел.
//Столбцы таблицы разделены запятыми и пробелами.
//Каждая строка содержит не более 26 значений. Пример:
//
//1.5, 2.67, 3.0, 1.4
//5.2, 7.1, -4.8, 0.0
//1.4, 6.0, 2.5, -1.9
//В строковом параметре range задан диапазон из двух ячеек
//этой таблицы, разделённых чёрточкой, например “A2-C4” или
//“A31-B42”
//Ячейки закодированы так: столбец задаётся заглавной буквой
//латинского алфавита (первый столбец это буква А),
//а строка - целым числом (первая строка это число 1).
//
//Необходимо посчитать среднее арифметическое значений во всех
//ячейках заданного диапазона заданной таблицы. Диапазон задаёт
//углы прямоугольника -- например “А2-С3” соответствует
//ячейкам A2, A3, B2, B3, C2, C3
//
//“Удовлетворительно” -- все строки содержат одинаковое
//количество чисел, заданный диапазон относится к одной строке,
//первая ячейка в нём обязательно находится слева,
//например, “B3-D3” (содержит B3, C3, D3)
//
//“Хорошо” -- диапазоны могут содержать ячейки из разных строк
//с произвольным положением углов, например, “B1-A2”
//соответствует ячейкам A1, A2, B1, B2
//
//“Отлично” -- строки могут содержать разное количество
//чисел. Кроме того, диапазон может включать ячейки за пределами
//входной таблицы, это не является ошибкой,
//ячейки за пределами таблицы просто не учитываются.
//Пример: диапазон “E1-B2” содержит B1, C1, D1, B2, C2, D2
//
//При нарушении форматов входных данных следует выбрасывать
//исключение IllegalArgumentException. При невозможности
//прочитать файл выбрасывать исключение IOException.
//
//Предложить самостоятельно имя функции. Кроме функции следует
//написать тесты, подтверждающие её работоспособность.
//*/
//fun averageValue(inputName: String, range: String): Double {
//
//    try {
//
//        val reader = File(inputName).readLines()
//        val table = mutableListOf<List<Double>>()
//        for (line in reader) {
//            if (!Regex("""([-]?\d+\.\d+[,]?\s*.*)""").matches(line)) throw IllegalArgumentException()
//            val t = Regex("""(\d+\.\d+|-\d+\.\d+)(,\s)*""").findAll(line)
//            val numLine = line.split(", ").map { it.toDouble() }
//            table.add(numLine)
//        }
//
//        val columns = Regex("""([A-Z])""").findAll(range)
//        val strings = Regex("""\d+""").findAll(range)
//        val numColumns = mutableListOf<Int>()
//        val numStrings = mutableListOf<Int>()
//        columns.forEach { numColumns.add(it.value.single().code - 64) }
//        strings.forEach { numStrings.add(it.value.toInt()) }
//        println("нужные строки - $numStrings")
//        println("срез в строке - $numColumns")
//        if (numColumns[0] > numColumns[1]) {
//            numColumns.sort()
//            numStrings.reverse()
//        }
//
//        val lines = table.subList(numStrings[0] - 1, numStrings[1])
//        val resultSub = mutableListOf<Double>()
//        for (line in lines) {
//            resultSub.addAll(line.subList(numColumns[0] - 1, numColumns[1]))
//        }
//        val result = resultSub.sum() / resultSub.size
//        val formatResult = (result * 1000.0).roundToInt() / 1000.0
//        return formatResult
//    } catch (e: FileNotFoundException) {throw IOException()}
//}
///*
//    try {
//        val reader = File(inputName).readText()
//        val lines = File(inputName).readLines()
//        val values = mutableListOf<List<Double>>()
//        for (line in lines) {
//            if (!Regex("""(-?\d+\.\d+(,\s)?)+""").matches(line)) throw IllegalArgumentException()
//            values.add(line.split(", ").map { it.toDouble() })
//        }
//        val columns = Regex("""[A-Z]""").findAll(range)
//        val strings = Regex("""\d+""").findAll(range)
//        val numColumns = mutableListOf<Int>()
//        val numStrings = mutableListOf<Int>()
//        columns.forEach { numColumns.add(it.value.single().code - 64) }
//        strings.forEach { numStrings.add(it.value.toInt()) }
//        if (numColumns[0] > numColumns[1]) {
//            numColumns.sort()
//            numColumns.reverse()
//        }
//
//        val line = values.subList(numStrings[0] - 1, numStrings[1])
//        val resSus = mutableListOf<Double>()
//        for (i in line) {
//            resSus.addAll(i.subList(numColumns[0] - 1, numColumns[1]))
//        }
//        val result = resSus.sum() / resSus.size
//        val formatResult = (result * 1000.0).roundToInt() / 1000.0
//        return formatResult
//    } catch (e: FileNotFoundException) {
//        throw IOException()
//    }
//    throw IllegalArgumentException()
//}
//*/
//
///*
// В файле с именем inputName заданы ежедневные сведения о
//количестве выпавших осадков (в мм) в различные месяцы года,
//всего не более чем 31 значение в каждой строке и
//не более 12 строк во всём файле, например:
//
//Март 0 1 0 3 41 2 0 0 13 16 20 8 0 4 8 1 0 0 0 7 12 0 4 9
//Апрель 0 0 0 17 0 0 11 48 42 0 0 1 7 15 18 0 0 0 0 0 8 2 17 0
//Май 10 15 48 21 0 0 17 22 30 0 0 13 0 0 2 5 7 0 0 0 1 10 3
//
//Каждая строка начинается с названия месяца, за которым
//следует последовательность целых чисел - уровень осадков в мм
//в различные дни этого месяца, начиная с 1-го. Порядок месяцев
//в файле должен соответствовать реальному (следующий месяц всегда
//ниже предыдущего).
//
//В строковом параметре days задан интервал дат
//либо в формате “Апрель 9..15” (дни в одном месяце),
//либо в формате “Март 22..Май 8” (дни в разных месяцах).
//
//Необходимо рассчитать максимальный уровень осадков за один день
//в заданном интервале дат. Например, для “Апрель 9..15” это 42,
//для “Март 22..Май 8” это 48. Отсутствующие дни игнорировать.
//
//“Удовлетворительно” -- используется только первый формат для
//параметра days - все дни в одном месяце
//
//“Хорошо” -- может использоваться как первый, так и второй
//формат для параметра days, то есть, интервал может содержать
//дни в разных месяцах
//
//“Отлично” -- результат функции должен содержать не только
//максимальный уровень осадков, но и список дней,
//в которых он был достигнут
//(42, 9 апреля или 48, 8 апреля, 3 мая для примеров выше)
//
//При нарушении форматов входных данных следует выбрасывать
//исключение IllegalArgumentException. При невозможности
//прочитать файл выбрасывать исключение IOException.
//
//Предложить имя и тип результата функции. Кроме функции
//следует написать тесты, подтверждающие её работоспособность.
//*/
//fun recipitation(inputName: String, days: String): Any {
//    try {
//        val table = mutableMapOf<String, List<Int>>()
//        val reader = File(inputName).readLines()
//        for (line in reader) {
//            if ((!Regex("""([А-я]+( \d+)+)""").matches(line)) || reader.size > 12) throw IllegalArgumentException()
//            val precipitation = line.substring(1, line.lastIndex + 1).split(" ").map { it.toInt() }
//            table[line[0].toString()] = precipitation
//        }
//        val months = Regex("""[А-я]+""").findAll(days).map { it.value }.toMutableList()
//        val day = Regex("""\d+""").findAll(days).map { it.value.toInt() }.toMutableList()
//        println("месяц - $months дни - $day")
//        val sub = mutableListOf<Int>()
//        for (month in months) {
//            val startIndex = day[0] - 1
//            val lastIndex = day[1]
//            sub.addAll(table[month]!!.subList(startIndex, lastIndex))
//        }
//        return sub.max()
//    } catch (e: FileNotFoundException) {throw IOException()}
//}
//
///*
//fun maximumPrecipitation(inputName: String, days: String): Any {
//    try {
//        val reader = File(inputName).readLines().map { it.split(" ") }
//        val table = mutableMapOf<String, List<Int>>()
//        for (line in reader) {
//            if (!Regex("""[а-яА-Я]+\s\d+(\s{1}\d+)*""").matches(line.joinToString(separator = " ")) || reader.size > 12) throw IllegalArgumentException()
//            val precipitations = line.subList(1, line.lastIndex + 1).map { it.toInt() }
//            table.put(line[0], precipitations)
//        }
//        val months = Regex("""[а-яА-я]+""").findAll(days).map { it.value.toString() }.toMutableList()
//        val day = Regex("""\d+""").findAll(days).map { it.value.toInt() }.toMutableList()
//        println("месяц - $months дни - $day")
//        val sub = mutableListOf<Int>()
//        if (months.size > 1) {
//            val tableKeys = table.keys.toMutableList()
//            val index1 = table.keys.indexOf(months[0])
//            val index2 = table.keys.indexOf(months[1])
//            val subKeys = tableKeys.subList(index1, index2 + 1)
//            for (rangeMonth in subKeys) {
//                if (rangeMonth == months[0]) {
//                    sub.addAll(table[rangeMonth]!!.subList(fromIndex = day[0] - 1, table[rangeMonth]!!.lastIndex + 1))
//                }
//                if (rangeMonth == months[1]) {
//                    sub.addAll(table[rangeMonth]!!.subList(0, day[1]))
//                }
//                else sub.addAll(table[rangeMonth]!!)
//            }
//        } else {
//            for (month in months) {
//                val startIndex = day[0] - 1
//                val lastIndex = day[1]
//                sub.addAll(table[month]!!.subList(startIndex, lastIndex))
//            }
//        }
//        val result = sub.max()
//        return result
//    } catch (e: FileNotFoundException) {throw IOException()}
//}
// */

fun niggersFaggots(inputName: String): String {
    val reader = File(inputName).readLines()
//    val readerOfNames = reader.map { it.split() }
    mutableListOf<String>()
    val table = mutableMapOf<String, Int>()
    for (line in reader) {
        if (!Regex("""[А-я|\w+]+: [\d+(h|m)\:?]+, \d+""").matches(line)) throw IllegalArgumentException()
        val views = Regex("""\d{2,}([^hm])""").find(line).map { it.value }!!.toInt()
        val hours = Regex("""\d+h""").find(line).map { it.value }!!.replace("h", "")
        val hoursToMinutes = hours.toInt() * 60
        val minutes = Regex("""\d+m""").find(line).map { it.value }!!.replace("m", "")
        val minutesToInt = minutes.toInt()
        val fullTime = hoursToMinutes + minutesToInt
        val fullTimeToMinutes = fullTime.toDouble() / 60
        val fullOfViews = (views * fullTimeToMinutes).toInt()
        val namesOfFaggots = Regex("""([А-я]+|\w+): """).find(line).map { it.value }!!.replace(": ", "")
        if (namesOfFaggots !in table) {
            table.put(namesOfFaggots, fullOfViews)
        } else {
            val previous = table[namesOfFaggots]
            table.put(namesOfFaggots, fullOfViews + previous!!)
        }
    }
//    var gg = table.mapToArray { Pair(it.key, it.value) }.maxByOrNull { it.second }!!
//    return return table.toString()
    var maxOfViews = 0
    var name = ""
    for (i in table.keys) {
        if (table[i]!! > maxOfViews) {
            maxOfViews = table[i]!!
            name = i
        }
    }
    return "$name--$maxOfViews"
}

/*
В файле с именем inputName содержатся результаты гонок Формулы-1 в формате:
Гран-при Австралии:
Л. Хэмилтон, Мерседес, 8
В. Боттас, Мерседес, 6
Л. Норрис, Макларен, 5
Д. Риккардо, Макларен, 4
Ш. Леклер, Феррари, 3
С. Феттель, Феррари, 2
М. Ферстапен, Ред Булл, 1

Гран-при России:
А. Албон, Ред Булл, 8
Л. Хэмилтон, Мерседес, 5
С. Феттель, Феррари, 4
Ш. Леклер, Феррари, 2
В. Боттас, Мерседес, 1

В первой строке содержится название гран-при, далее идет список пилотов.
Каждая строка этого списка начинается с имени и фамилии пилота, далее через
запятую идёт название его команды и число набранных им очков.
В команде может быть не более трёх пилотов, число Гран-при и команд - любое.

"Удовлетворительно" -- определить команду-победителя и число её очков
(чемпионат состоит из всех указанных в файле Гран-при). В примере: Мерседес, 20

"Хорошо" -- отсортировать команды по набранному количеству очков,
а при одинаковом числе очков -- по алфавиту.
В примере: Мерседес, 20, Феррари, 11, Макларен, 9, Ред Булл, 9

"Отлично" -- отсортировать команды тем же образом.
Для каждой команды определить, сколько очков набрал каждый из её пилотов.
В примере: Мерседес, 20 (Л. Хэмилтон 13, В. Боттас 7),
Феррари, 11 (С. Феттель, 6, Ш. Леклер, 5), Макларен, 9 (Д. Риккардо, 9),
Ред Булл, 9 (А. Албон, 8, М. Ферстаппен, 1),

Предложить имя и тип результата функции. Кроме функции
следует написать тесты, подтверждающие её работоспособность
 */

fun f1Tournament(inputName: String): Any {
    val reader = File(inputName).readLines()
    val teams = mutableMapOf<String, MutableList<Pair<String, Int>>>()
    for (line in reader) {
        if (Regex("""[А-Я.]+ [А-я,]+ ([А-я\,?]|[ А-я,])+ \d""").matches(line)) {
            val team = Regex("""(([^А-Я.][,]) [А-Яа-я ]+)""").find(line)!!.value.substring(3)
            val name = Regex("""[А-Я.]+ [А-я]+""").find(line)!!.value
            val score = Regex("""\d+""").find(line)!!.value.toInt()
            if (teams.containsKey(team)) {
                teams.get(team)!!.add(Pair(name, score))
            } else {
                teams.put(team, mutableListOf(Pair(name, score)))
            }
        }
    }
    val comand = mutableMapOf<String, Int>()
    for (i in teams.keys) {
        comand[i] = 0
        for (j in teams[i]!!) {
            comand[i] = comand[i]!! + j.second
        }
    }
    var score = 0
    var name = ""
    for (i in comand.keys) {
        if (comand[i]!! > score) {
            score = comand[i]!!
            name = i
        }
    }
    val gg = comand.toList().sortedBy { it.first }.sortedByDescending { it.second }
//    println("$name, $score")
//    println(gg.joinToString { "${it.first}, ${it.second}" })
//    println(comand)
//    println(teams)
    var closet = ""
    for (i in gg.indices) {
        closet += gg[i].first + ", " + gg[i].second + " ("
        closet += teams[gg.get(i).first]!!.joinToString { "${it.first}, ${it.second}" }
        closet += ") "
    }
    val drivers = mutableMapOf<String, Int>()
//    for ((key, value) in teams) {
//        var car = mutableSetOf<String>()
//        for (pair in value) {
//            if (pair !in car)
//        }
//    }
    println(closet)
    return gg.joinToString { "${it.first}, ${it.second}" }
}

/*В файле с именем inputName заданы ежедневные сведения о
количестве выпавших осадков (в мм) в различные месяцы года,
всего не более чем 31 значение в каждой строке и
не более 12 строк во всём файле, например:

Март 0 1 0 3 41 2 0 0 13 16 20 8 0 4 8 1 0 0 0 7 12 0 4 9
Апрель 0 0 0 17 0 0 11 48 42 0 0 1 7 15 18 0 0 0 0 0 8 2 17 0
Май 10 15 48 21 0 0 17 22 30 0 0 13 0 0 2 5 7 0 0 0 1 10 3

Каждая строка начинается с названия месяца, за которым
следует последовательность целых чисел - уровень осадков в мм
в различные дни этого месяца, начиная с 1-го. Порядок месяцев
в файле должен соответствовать реальному (следующий месяц всегда
ниже предыдущего).

В строковом параметре days задан интервал дат
либо в формате “Апрель 9..15” (дни в одном месяце),
либо в формате “Март 22..Май 8” (дни в разных месяцах).

Необходимо рассчитать максимальный уровень осадков за один день
в заданном интервале дат. Например, для “Апрель 9..15” это 42,
для “Март 22..Май 8” это 48. Отсутствующие дни игнорировать.

“Удовлетворительно” -- используется только первый формат для
параметра days - все дни в одном месяце

“Хорошо” -- может использоваться как первый, так и второй
формат для параметра days, то есть, интервал может содержать
дни в разных месяцах

“Отлично” -- результат функции должен содержать не только
максимальный уровень осадков, но и список дней,
в которых он был достигнут
(42, 9 апреля или 48, 8 апреля, 3 мая для примеров выше)

При нарушении форматов входных данных следует выбрасывать
исключение IllegalArgumentException. При невозможности
прочитать файл выбрасывать исключение IOException.

Предложить имя и тип результата функции. Кроме функции
следует написать тесты, подтверждающие её работоспособность.*/
fun fallout(inputName: String, days: String): Any {
    val reader = File(inputName).readLines()
    val prescription = mutableMapOf<String, List<Int>>()
    val prescriptionToPair = mutableListOf<Pair<String, List<Int>>>()
//    val monthToDec = mutableMapOf<String, Int>(
//        "Январь" to 0,
//        "Февраль" to 1,
//        "Март" to 2,
//        "Апрель" to 3,
//        "Май" to 4,
//        "Июнь" to 5,
//        "Июль" to 6,
//        "Август" to 7,
//        "Сентябрь" to 8,
//        "Октябрь" to 9,
//        "Ноябрь" to 10,
//        "Декабрь" to 11
//    )
//    val ddays = days.split(" ", "..")
//    val firstMonth = monthToDec[ddays[0]]!!
//    val firstDay = ddays[1].toInt()
//    val lastMonth = monthToDec[ddays[2]]!!
//    val lastDay = ddays[2].toInt()
//    println(lastDay)4
    for (line in reader) {
        val month = Regex("""[А-я]+""").find(line)
        val afternoons = Regex("""\d+""").findAll(line)
        val data = mutableListOf<Int>()
        val data1 = month!!.value
        for (res in afternoons) {
            data.add(res.value.toInt())
        }
        prescription.put(data1, data)
    }
    val ddays = days.split(" ", "..")
    var month = ""
    var secondMonth = ""
    var firstDay = 0
    var lastDay = 0
    if (ddays.size == 3) {
        month = ddays[0]
        secondMonth = ddays[0]
        firstDay = ddays[1].toInt()
        lastDay = ddays[2].toInt()
    } else {
        month = ddays[0]
        secondMonth = ddays[2]
        firstDay = ddays[1].toInt()
        lastDay = ddays[3].toInt()
    }
    for ((first, second) in prescription) {
        prescriptionToPair.add(Pair(first, second))
    }
    var maxx = 0
    for (mmm in prescriptionToPair) {
        if (month == mmm.first) {
            if (secondMonth == month) {
                return mmm.second.subList(firstDay - 1, lastDay).max()
            } else {
                maxx = mmm.second.subList(firstDay - 1, mmm.second.lastIndex + 1).max()
                for (sss in prescriptionToPair) {
                    if (secondMonth != sss.first) {
                        var maxs = sss.second.max()
                        if (maxs > maxx) maxx = maxs
                    } else {
                        var maxs = sss.second.subList(0, lastDay).max()
                        if (maxs > maxx) maxx = maxs
                    }
                }
            }
        }
    }
    return maxx
}


/*
В файле с именем inputName содержится список строк следующего вида (пример)
    1 Первое действие
    3 Интерлюдия
    6 Послесловие
Каждая строка списка начинается с положительного номера, далее через пробел
идёт произвольная строка. Номера идут по возрастанию, но не обязательно подряд.
В параметре changes содержится список изменений, которые следует применить
к тексту, возможный формат изменений приведён ниже. Отредактировать текст
в соответствии со списком изменений и вывести его в файл с именем outputName
"Удовлетворительно" -- поддержать изменения вида "2 Следующий акт",
"5 Вторая глава". Данные строки следует вставить в исходный список, сохранив
правильный порядок номеров. Например, для указанных изменений:
    1 Первое действие
    2 Следующий акт
    3 Интерлюдия
    5 Вторая глава
    6 Послесловие
При нарушении формата входных данных следует выбрасывать
исключение IllegalArgumentException.
Самостоятельно предложить имя функции. Кроме функции
следует написать тесты, подтверждающие её работоспособность.
*/

//fun theatre1(inputName: String, outputName: String, changes: List<String>): Any {
//    val reader = File(inputName).readLines()
//    val writer = File(outputName).bufferedWriter()
//    for ()
//}

/*
Задание: в файле задаётся список команд и их результаты по итогам турнира
(результат пишется через дефис, где первое значение - результат самой команды).
2 соответствует победе, 1 - ничьей и 0 - поражения.

На удовлетворительно - вывести название команды, набравшей максимальное кол-во очков по итогам турнира,
если таких команд несколько, вывести любую из них.

На хорошо - вывести отсортированный список команд.
Сортировка делается по принципу: сначала сортируется по кол-ву очков,
если кол-во одинаковое - отсортировать по кол-ву побед,
если и кол-во побед одинаковое, отсортировать по названию команды в алфавитном порядке.

Не забываем выбрасывать исключение,
если данные записаны неправильно и если ячейка таблицы (i,j) не коррелирует с ячейкой таблицы (j,i)
*/
fun doka2(inputName: String): String {
    val reader = File(inputName).readLines()
    val teamsToMap = mutableMapOf<String, List<Int>>()

    for (lines in reader) {
        if (!Regex("""[A-z ]+([A-z])+\s+(\|\d-\d)+""").matches(lines)) throw IllegalArgumentException()
        val teams = lines.replace("|", "")
        val teamsR = Regex("""[A-z]+( [A-z]+)?""").find(teams)
        val score = Regex("""\d""").findAll(teams)
        val scoreR = mutableListOf<Int>()
        for (ints in score) {
            scoreR.add(ints.value.toInt())
        }
        teamsToMap.put(teamsR!!.value, scoreR)
    }
    var teamsSum = ""
    var sumOfScores = 0
    for (i in teamsToMap.keys) {
        if (sumOfScores < teamsToMap[i]!!.sum()) {
            sumOfScores = teamsToMap[i]!!.sum()
            teamsSum = i
        }
    }
    println(teamsToMap.toList().sortedBy { it.first }.sortedByDescending { it.second.count { it == 2 } }
        .sortedByDescending { it.second.sum() })
    return teamsSum
}

/*
В файле с менем inputName содержатся
маршруты общественного транспорта в следующем формате:

троллейбус 15 уп. Железнодорожная > ул. Садовая > ул. Пионерская > Московское ш.
автобус 17 ул. Железнодорожная > ул. Садовая » ул. Центральная > Парк отдыха
трамвай 3 Парк отдыха > ул. Дворцовая > Проспект мира
автобус 4 ул. Железнодорожная > Путепровод > Аэропорт
троллейбус 4 Путепровод > ул. Центральная > аллея Культуры > Московское ш.

В каждой строчке файла указан вид транспорта (автобус, троллейбус, трамвай),
номер маршрута и список остановок, разделённых знаком ». Считается, что кажды
маршрут действует и в прямом, и в обратном направлении.

"Удовлетворительно" - построить прямой маршрут (без пересадок) от станции src
до станции dst. Например: src-"Парк отдыха", dst-"ул. Дворцовая
ответ="трамвай 3" (вернуть любой возможный вариант)

При нарушении форматов входных данных следует выбрасывать
исключение IllegalArgumentException. При невозможности
прочитать файл выбрасывать исключение IOException.

Предложить имя и тил результата функции. Кроме функции
следует написать тесты, подтверждающие её работоспособность.
*/

fun wayAway(inputName: String, src: String, dst: String): String {
    try {
        val reader = File(inputName).readLines()
        val paths = mutableMapOf<String, List<String>>()
        for (line in reader) {
            if (!Regex("""([А-я]+ \d+)(\s*([А-я]+. |[А-я])+>)+([А-я]*)\s[А-я].*""").matches(line)) throw IllegalArgumentException()
            var trans = Regex("""[А-я]+ \d+""").find(line)!!.value
            var routes = Regex(""" [А-я .]+""").findAll(line)
            val routesTol = mutableListOf<String>()
            for (rr in routes) {
                routesTol.add(rr.value.trim())
            }
            paths[trans] = routesTol
        }
        println(paths)
        for (line in paths.keys) if (src in paths[line]!! && dst in paths[line]!!) {
            println(line); return line
        }
    } catch (e: FileNotFoundException) {
        throw IOException()
    }
    throw IllegalArgumentException()
}

fun streamers(inputName: String): String {
    val reader = File(inputName).readLines()
    val mapOfStreamers = mutableMapOf<String, Double>()
    val listOfViews = mutableListOf<Double>()
    for (line in reader) {
        if (!Regex("""[А-я|\w+]+: [\d+(h|m)\:?]+,( \d+\,?)+""").matches(line)) throw IllegalArgumentException()
        val name = Regex("""[А-я|\w+]+: """).find(line)!!.value.replace(": ", "")
        val hours = Regex("""\d+h""").find(line)!!.value.replace("h", "").toInt()
        val minutes = Regex("""\d+m""").find(line)!!.value.replace("m", "").toInt()
        val views = Regex(""", \d+""").findAll(line)
        for (i in views) listOfViews.add(i.value.replace(", ", "").toDouble())
        if (minutes != 0) listOfViews[listOfViews.lastIndex] *= (minutes / 60.0)
        if (!mapOfStreamers.containsKey(name)) mapOfStreamers[name] = listOfViews.sum()
        else mapOfStreamers[name] = mapOfStreamers[name]!! + listOfViews.sum()
        listOfViews.clear()
    }
    val sorted = mapOfStreamers.toList().sortedByDescending { it.second }
    val result = buildString { for ((i, j) in sorted) append(" $i--${j.roundToInt()}") }
    println(result)
    return result
}

fun streamers2(inputName: String): String {
    val reader = File(inputName).readLines()
    val mapOfStreamers = mutableMapOf<String, Int>()
    for (line in reader) {
        if (!Regex("""[А-я|\w+]+: [\d+(h|m)\:?]+,( \d+\,?)+""").matches(line)) throw IllegalArgumentException()
        val name = Regex("""[А-я|\w+]+: """).find(line)!!.value.replace(": ", "")
        val hoursToMinutes = (Regex("""\d+h""").find(line)!!.value.replace("h", "").toInt()) * 60
        val minutes = Regex("""\d+m""").find(line)!!.value.replace("m", "").toInt()
        if (minutes in 59..0) throw IllegalArgumentException()
        val views = Regex(""", \d+""").find(line)!!.value.replace(", ", "").toInt()
        if (views < 0) throw IllegalArgumentException()
        val timeInMinutes = (hoursToMinutes.toDouble() + minutes.toDouble()) / 60
        val totalViews = (timeInMinutes * views).roundToInt()
        if (name !in mapOfStreamers) {
            mapOfStreamers.put(name, totalViews)
        } else {
            val previous = mapOfStreamers[name]
            mapOfStreamers.put(name, totalViews + previous!!)
        }
    }
    val maxViews = mapOfStreamers.values.max()
    var nameOfMax = ""
    for (i in mapOfStreamers.keys) {
        if (mapOfStreamers[i] == maxViews) nameOfMax = i
    }
    val sortedMapOfStreamers = mapOfStreamers.toList().sortedByDescending { it.second }
    val sortedString = buildString { for ((i, j) in sortedMapOfStreamers) append("$i--$j ") }
    println(sortedString.trim())
    return "$nameOfMax--$maxViews"
}

/* В файле с именем inputName задана таблица действительных чисел.
Столбцы таблицы разделены запятыми и пробелами.
Каждая строка содержит не более 26 значений. Пример:

1.5, 2.67, 3.0, 1.4
5.2, 7.1, -4.8, 0.0
1.4, 6.0, 2.5, -1.9
В строковом параметре range задан диапазон из двух ячеек
этой таблицы, разделённых чёрточкой, например “A2-C4” или
“A31-B42”
Ячейки закодированы так: столбец задаётся заглавной буквой
латинского алфавита (первый столбец это буква А),
а строка - целым числом (первая строка это число 1).

Необходимо посчитать среднее арифметическое значений во всех
ячейках заданного диапазона заданной таблицы. Диапазон задаёт
углы прямоугольника -- например “А2-С3” соответствует
ячейкам A2, A3, B2, B3, C2, C3

“Удовлетворительно” -- все строки содержат одинаковое
количество чисел, заданный диапазон относится к одной строке,
первая ячейка в нём обязательно находится слева,
например, “B3-D3” (содержит B3, C3, D3)

“Хорошо” -- диапазоны могут содержать ячейки из разных строк
с произвольным положением углов, например, “B1-A2”
соответствует ячейкам A1, A2, B1, B2

“Отлично” -- строки могут содержать разное количество
чисел. Кроме того, диапазон может включать ячейки за пределами
входной таблицы, это не является ошибкой,
ячейки за пределами таблицы просто не учитываются.
Пример: диапазон “E1-B2” содержит B1, C1, D1, B2, C2, D2

При нарушении форматов входных данных следует выбрасывать
исключение IllegalArgumentException. При невозможности
прочитать файл выбрасывать исключение IOException.

Предложить самостоятельно имя функции. Кроме функции следует
написать тесты, подтверждающие её работоспособность.
*/
fun averageValue(inputName: String, range: String): Double {
    val reader = File(inputName).readLines()
    val listOfLists = mutableListOf<List<Double>>()
    for (line in reader) {
        if (!Regex("""([-]?\d+\.\d+[,]?\s*.*)""").matches(line)) throw IllegalArgumentException()
        val numbers = line.split(", ")
        val listOfNumbers = mutableListOf<Double>()
        for (i in 0..numbers.lastIndex) listOfNumbers.add(numbers[i].toDouble())
        listOfLists.add(listOfNumbers)
    }
    val range1 = range.substringBefore("-")
    val range2 = range.substringAfter("-")
    val indexOfColumn1 = range1[0].code - 65
    val indexOfColumn2 = range2[0].code - 65
    val indexOfColumn3 = if (indexOfColumn1 > indexOfColumn2) indexOfColumn2 else indexOfColumn1
    val indexOfColumn4 = if (indexOfColumn1 > indexOfColumn2) indexOfColumn1 else indexOfColumn2
    val indexOfRow1 = range1.substring(1).toInt() - 1
    val indexOfRow2 = range2.substring(1).toInt() - 1
    val indexOfRow3 = if (indexOfRow1 > indexOfRow2) indexOfRow2 else indexOfRow1
    val indexOfRow4 = if (indexOfRow1 > indexOfRow2) indexOfRow1 else indexOfRow2
    var sumOf = 0.0
    var countOf = 0
    for (i in indexOfColumn3..indexOfColumn4) {
        for (j in indexOfRow3..indexOfRow4) {
            if (j in listOfLists.indices && i in listOfLists[j].indices) {
                sumOf += listOfLists[j][i]
                countOf += 1
            }
        }
    }
    return ((sumOf / countOf) * 1000.0).roundToInt() / 1000.0
}

/*
В файле с именем inputName содержатся результаты гонок Формулы-1 в формате:
Гран-при Австралии:
Л. Хэмилтон, Мерседес, 8
В. Боттас, Мерседес, 6
Л. Норрис, Макларен, 5
Д. Риккардо, Макларен, 4
Ш. Леклер, Феррари, 3
С. Феттель, Феррари, 2
М. Ферстапен, Ред Булл, 1

Гран-при России:
А. Албон, Ред Булл, 8
Л. Хэмилтон, Мерседес, 5
С. Феттель, Феррари, 4
Ш. Леклер, Феррари, 2
В. Боттас, Мерседес, 1

В первой строке содержится название гран-при, далее идет список пилотов.
Каждая строка этого списка начинается с имени и фамилии пилота, далее через
запятую идёт название его команды и число набранных им очков.
В команде может быть не более трёх пилотов, число Гран-при и команд - любое.

"Удовлетворительно" -- определить команду-победителя и число её очков
(чемпионат состоит из всех указанных в файле Гран-при). В примере: Мерседес, 20

"Хорошо" -- отсортировать команды по набранному количеству очков,
а при одинаковом числе очков -- по алфавиту.
В примере: Мерседес, 20, Феррари, 11, Макларен, 9, Ред Булл, 9

"Отлично" -- отсортировать команды тем же образом.
Для каждой команды определить, сколько очков набрал каждый из её пилотов.
В примере: Мерседес, 20 (Л. Хэмилтон 13, В. Боттас 7),
Феррари, 11 (С. Феттель, 6, Ш. Леклер, 5), Макларен, 9 (Д. Риккардо, 9),
Ред Булл, 9 (А. Албон, 8, М. Ферстаппен, 1),

Предложить имя и тип результата функции. Кроме функции
следует написать тесты, подтверждающие её работоспособность
 */

fun f1(inputName: String): Any {
    val reader = File(inputName).readLines()
    val teams = mutableMapOf<String, MutableList<Pair<String, Int>>>()
    for (line in reader) {
        if (Regex("""[А-Я.]+ [А-я,]+ ([А-я\,?]|[ А-я,])+ \d""").matches(line)) {
            val team = Regex(""", ([А-я]+\s?[А-я]+)""").find(line)!!.value.substring(2)
            val name = Regex("""[А-Я]. [А-я]+""").find(line)!!.value
            val score = Regex("""\d""").find(line)!!.value.toInt()
            if (teams.containsKey(team)) {
                teams[team]!!.add(Pair(name, score))
            } else {
                teams[team] = mutableListOf(Pair(name, score))
            }
        }
    }
    val result4 = mutableMapOf<String, Int>()
    for (i in teams.keys) {
        result4[i] = 0
        for (j in teams[i]!!) {
            result4[i] = result4[i]!! + j.second
        }
    }
    val rr = result4.toList().sortedBy { it.first }.sortedByDescending { it.second }
    var closet = ""
    for (i in rr.indices) {
        closet += rr[i].first + ", " + rr[i].second + " ("
        closet += teams[rr.get(i).first]!!.joinToString { "${it.first}, ${it.second}" }
        closet += ") "
    }
    println(rr[0].toString().trim('(', ')'))
    println(rr.joinToString { "${it.first}, ${it.second}" })
    println(closet)
    return rr.joinToString { "${it.first}, ${it.second}" }
}

/*
Задание: в файле задаётся список команд и их результаты по итогам турнира
(результат пишется через дефис, где первое значение - результат самой команды).
2 соответствует победе, 1 - ничьей и 0 - поражения.

На удовлетворительно - вывести название команды, набравшей максимальное кол-во очков по итогам турнира,
если таких команд несколько, вывести любую из них.

На хорошо - вывести отсортированный список команд.
Сортировка делается по принципу: сначала сортируется по кол-ву очков,
если кол-во одинаковое - отсортировать по кол-ву побед,
если и кол-во побед одинаковое, отсортировать по названию команды в алфавитном порядке.

Не забываем выбрасывать исключение,
если данные записаны неправильно и если ячейка таблицы (i,j) не коррелирует с ячейкой таблицы (j,i)
*/
fun dota2(inputName: String): String {
    val reader = File(inputName).readLines()
    val results3 = mutableMapOf<String, Int>()
    val results4 = mutableMapOf<String, List<Int>>()
    for (line in reader) {
        if (!Regex("""([A-z]+\s?[A-z]+)\s+(\|\d-\d)+""").matches(line)) throw IllegalArgumentException()
        val team = Regex("""[A-z]+\s?[A-z]+""").find(line)!!.value
        val score = Regex("""\d-""").findAll(line)
        val forkSum = mutableListOf<Int>()
        for (i in score) forkSum += i.value.replace("-", "").toInt()
        results3[team] = forkSum.sum()
        results4[team] = forkSum
    }
    val rr = results3.toList().sortedBy { it.first }.sortedByDescending { it.second }
    /*
        выводы на тройку
        println(rr[0].first)
        println(results.maxBy { it.value }.key)
    */
    val gg = results4.toList().sortedBy { it.first }.sortedByDescending { it -> it.second.count { it == 2 } }
        .sortedByDescending { it.second.sum() }
    /*
        выводы на четверку
        var wewe = mutableListOf<String>()
        gg.forEach { wewe.add(it.first) }
        println(wewe.joinToString())
        println(gg.toMap().keys.toString().trim('[', ']'))
        println(gg.joinToString { "${it.first}" })
    */
    return "0"
}

fun gaysex(inputName: String): String {
    val reader = File(inputName).readLines()
    val result = mutableMapOf<String, Int>()
    for (line in reader) {
        if (!Regex("""([A-z]+|[А-я]+):\s(\d+h:\d+m,)\s\d+""").matches(line)) throw IllegalArgumentException()
        val nicks = Regex("""([A-z]+|[А-я]+):\s""").find(line)!!.value.replace(": ", "")
        val hours = Regex("""\d+h""").find(line)!!.value.replace("h", "").toInt() * 60
        val minutes = Regex("""\d+m""").find(line)!!.value.replace("m", "").toInt()
        if (minutes > 59) throw IllegalArgumentException()
        val fullTime = (hours + minutes) / 60.0
        val views = (Regex(""",\s\d+""").find(line)!!.value.replace(", ", "").toDouble() * fullTime).roundToInt()
        if (nicks !in result) {
            result[nicks] = views
        } else {
            val previous = result[nicks]
            result[nicks] = views + previous!!
        }
    }
    val sorted = result.toList().sortedByDescending { it.second }
//    println(sorted)
    println("${sorted[0].first}--${sorted[0].second}")
    sorted.joinToString { println(("${it.first}--${it.second}").toString()).toString() }
    val final = buildString { for ((i, j) in sorted) append(" $i--$j,") }
    println(final.trim(',', ' '))
    var soso = ""
    for ((i, j) in sorted) soso += "$i--$j "
    println(soso)
    return sorted.joinToString { ("${it.first}--${it.second}").toString() }
}

//fun matrix(matrix1: List<List<Int>>, matrix2: List<List<Int>>): List<List<Int>> = TODO()
/*{
    val matrix1 = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    val matrix2 = listOf(listOf(10, 11, 12), listOf(13, 14, 15), listOf(16, 17, 18))
    val high1 = matrix1.size
    val high2 = matrix2.size
    val sumOfMatrix = mutableListOf<List<Int>>()
    if (high1 != matrix1[0].size || high1 != matrix1[1].size || high1 != matrix1[2].size) throw IllegalArgumentException()
    if (high2 != matrix2[0].size || high2 != matrix2[1].size || high2 != matrix2[2].size) throw IllegalArgumentException()
    if (high1 != high2 || matrix1[0].size != matrix2[0].size) throw IllegalArgumentException()
    for (i in 0 until high1) {
        if (matrix1[i][0] == matrix1[i][1] || matrix1[i][1] == matrix1[i][2] || matrix1[i][0] == matrix1[i][2]) throw IllegalArgumentException()
    }
    for (i in 0 until high2) {
        if (matrix2[i][0] == matrix2[i][1] || matrix2[i][1] == matrix2[i][2] || matrix2[i][0] == matrix2[i][2]) throw IllegalArgumentException()
    }
    for (i in 0 until matrix1[])
    return listOf(listOf(1))
}*/

/**
 * В файле с именем inputName содержится
 * список треугольников в следующем формате:
 *
 * ABC 0.0 0.0 3.0 0.0 0.0 4.0
 * DEF 1.0 2.0 8.0 2.0 4.0 4.0
 * XYZ -2.0 0.0 1.0 0.0 0.0 1.5
 *
 * Каждая строчка начинается с имени треугольника,
 * состоящего из трёх латинских букв, далее через пробел
 * следуют координаты X и Y трёх его точек на плоскости
 * (6 вещественных чисел)
 *
 * Найти в данном списке треугольник наименьшего периметра
 * (в данном случае -- XYZ)
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun triangle(inputName: String): String {
    val reader = File(inputName).readLines()
    val triangles = mutableMapOf<String, List<Double>>()
    for (i in reader) {
        if (!Regex("""[A-Z]+(\s\-?\d\.\d)+""").matches(i)) throw IllegalArgumentException()
        val nameOfTriangle = Regex("""[A-Z]+""").find(i)!!.value
        val coordinates = Regex("""\-?\d\.\d""").findAll(i)
        val coordinatesToList = mutableListOf<Double>()
        for (i in coordinates) coordinatesToList += i.value.toDouble()
        triangles[nameOfTriangle] = coordinatesToList
    }
    val trianglesPerimeters = mutableMapOf<String, Int>()
    for ((key, value) in triangles) {
        val point1 = Point(value[0], value[1])
        val point2 = Point(value[2], value[3])
        val point3 = Point(value[4], value[5])
        val perimeter = (point1.distance(point2) + point2.distance(point3) + point3.distance(point1)).roundToInt()
        trianglesPerimeters[key] = perimeter
    }
    val sorted = trianglesPerimeters.toList().sortedBy { it.second }
    return "${sorted[0].first}"
}

/** На вход функции подается 2 матрицы чисел в виде списка списков

 * Сначала необходимо проверить корректность матрицы:

 * 1. Факт того, что она квадратная.
 *2. факт того, что в каждом столбце и каждой строке все числа уникальны
 * * 3. Факт того, что размеры матриц одинаковы
 * Если матрица некорректна, то выбросить IllegalArgumentException

 * В случае корректности матриц необходимо вернуть их сумму

> Предложить имя и тип результата функции. Кроме функции * следует написать тесты, подтверждающие её работоспособность. */

fun matrix(matrix1: List<List<Int>>, matrix2: List<List<Int>>): Any {
    if (matrix1.size == matrix2.size) {
        for (i in matrix1.indices) if (matrix1[i].size != matrix2.size || matrix2[i].size != matrix1.size) throw IllegalArgumentException()
    } else throw IllegalArgumentException()
    for (i in matrix1.indices) {
        if (matrix1[i].size != matrix1[i].toSet().size || matrix2[i].size != matrix2[i].toSet().size) throw IllegalArgumentException()
        val set1 = mutableSetOf<Int>()
        val set2 = mutableSetOf<Int>()
        for (j in matrix1[i].indices) {
            set1.add(matrix1[j][i])
            set2.add(matrix2[j][i])
        }
        if (set1.size != matrix1.size || set2.size != matrix2.size) throw IllegalArgumentException()
    }
    val set1 = mutableSetOf<Int>()
    val set2 = mutableSetOf<Int>()
    for (i in matrix1.indices) {
        set1.add(matrix1[i][i])
        set2.add(matrix2[i][i])
    }
    if (set1.size != matrix1.size || set2.size != matrix2.size) throw IllegalArgumentException()
    var j = matrix1.size - 1
    val rat1 = mutableSetOf<Int>()
    val rat2 = mutableSetOf<Int>()
    for (i in matrix1.indices) {
        rat1.add(matrix1[i][j])
        rat2.add(matrix2[i][j])
        j--
    }
    if (rat1.size != matrix1.size || rat2.size != matrix2.size) throw IllegalArgumentException()
    val matrix3 = mutableListOf<MutableList<Int>>()
    for (i in matrix1.indices) {
        matrix3.add(mutableListOf())
        for (j in matrix1.indices) {
            matrix3[i].add(matrix1[i][j] + matrix2[i][j])
        }
    }
    return matrix3
}

/**
 * В файле с именем inputName содержится
 * список точек на плоскости.
 * В каждой строчке перечисляются имя точки
 * (из одного латинского символа) и её координаты X и Y,
 * например:
 *
 * A 10.0 8.0
 * B 4.0 1.0
 * C 1.0 5.0
 * D 1.0 1.0
 * E 12.0 4.0
 *
 * Найти в данном списке три точки, образующие треугольник
 * наименьшего периметра.
 * В примере это точки B, C и D с периметром 12.0.
 * Формула расстояния между точками: sqrt((x2-x1)2+(y2-y1)2)
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */

data class Points(val name: String, val x: Double, val y: Double)

fun distance1(p1: Points, p2: Points): Double = sqrt((p2.x - p1.x).pow(2) + (p2.y - p1.y).pow(2))

fun triangles2(inputName: String): String {
    val reader = File(inputName).readLines()
    val mapOfDoubles = mutableMapOf<String, List<Double>>()
    val points = mutableListOf<Points>()
    for (line in reader) {
        if (!Regex("[A-Z](\\s\\d+\\.\\d+)+").matches(line)) throw IllegalArgumentException()
        val nameOfPoint = Regex("[A-Z]").find(line)!!.value
        val coordinates = Regex("\\s\\d+\\.\\d+").findAll(line)
        val coordinatesToList = mutableListOf<Double>()
        for (i in coordinates) coordinatesToList += i.value.toDouble()
        mapOfDoubles[nameOfPoint] = coordinatesToList
        points.add(Points(nameOfPoint, coordinatesToList[0], coordinatesToList[1]))
    }
    var smallestPerimeter = Double.MAX_VALUE
    var smallestPerimeterTriangle = listOf<Points>()
    for (i in 0 until points.size - 2) {
        for (j in i + 1 until points.size - 1) {
            for (k in j + 1 until points.size) {
                val p1 = points[i]
                val p2 = points[j]
                val p3 = points[k]
                val perimeter = distance1(p1, p2) + distance1(p1, p3) + distance1(p2, p3)
                if (perimeter < smallestPerimeter) {
                    smallestPerimeter = perimeter
                    smallestPerimeterTriangle = listOf(p1, p2, p3)
                }
            }
        }
    }
    var result = ""
    for (i in smallestPerimeterTriangle) {
        result += "${i.name}, "
    }
    return result.removeRange(result.lastIndex - 1, result.lastIndex).trim()
}

/**
 * В файле с именем inputName содержится
 * список отцов и детей в формате “Name1 is a father of Name2”,
 * например:
 *
 * Mike is a father of John
 * Mike is a father of Jack
 * John is a father of Derek
 *
 * Найти в данном списке хотя бы одну пару (дед, внук),
 * в данном примере это (Mike, Derek)
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun parents(inputName: String): Pair<String, String> {
    val reader = File(inputName).readLines()
    val parents = mutableListOf<Pair<String, String>>()
    for (line in reader) {
        if (!Regex("[A-Z]\\w+( is a father of )[A-Z]\\w+").matches(line)) throw IllegalArgumentException()
        val father = Regex("[A-Z]\\w+\\s(is)").find(line)!!.value.replace(" is", "")
        val son = Regex("(of )[A-Z]\\w+").find(line)!!.value.replace("of ", "")
        parents.add(Pair(father, son))
    }
    for (i in 0 until parents.size - 1) {
        for (j in i until parents.size) {
            if (parents[i].second == parents[j].first) return Pair(parents[i].first, parents[j].second)
        }
    }
    return Pair("popa", "pisa")
}

/**
 * В файле с именем inputName содержится
 * список прямоугольников.
 * В каждой строке указан цвет прямоугольника,
 * координаты (x, y) левого нижнего и правого верхнего угла.
 * Все цвета должны быть уникальными.
 * Стороны прямоугольников считать параллельными осям координат.
 *
 * RED 0 0 5 10
 * GREEN 10 10 20 15
 * BLUE 5 5 12 15
 *
 * Написать функцию,
 * которая найдёт хотя бы одну пару пересекающихся прямоугольников -
 * для приведённого примера это пара (GREEN, BLUE).
 * Прямоугольники, касающиеся друг друга,
 * но имеющие площадь пересечения, равную 0
 *(как RED-BLUE в примере), не считать пересекающимися.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun rectangles(inputName: String): Pair<String, String> {
    val reader = File(inputName).readLines()
    val rectangles = mutableMapOf<String, List<Int>>()
    for (line in reader) {
        if (!Regex("[A-Z]+(\\s\\d+)+").matches(line)) throw IllegalArgumentException()
        val color = Regex("[A-Z]+").find(line)!!.value
        val coordinates = Regex("\\d+").findAll(line)
        val coordinatesToList = mutableListOf<Int>()
        for (i in coordinates) coordinatesToList += i.value.toInt()
        rectangles[color] = coordinatesToList
    }
    for ((color1, coords1) in rectangles) {
        for ((color2, coords2) in rectangles) {
            if (color1 != color2) {
                val (x1_1, y1_1, x2_1, y2_1) = coords1 // координаты этих углов
                val (x1_2, y1_2, x2_2, y2_2) = coords2
                if (x1_1 < x2_2 && x2_1 > x1_2 && y1_1 < y2_2 && y2_1 > y1_2) {
                    return Pair(color1, color2)
                }
            }
        }
    }
    return Pair("pisa", "popa")
}

/**
 * В файле с именем inputName содержится
 * список материальных точек на плоскости,
 * с указанием координат (x, y) и массы для каждой точки.
 * Масса указывается после символа
 *
 * 1.0 2.0 M 0.15
 * 4.0 9.5 M 0.3
 * -5.2 4.7 M 0.6
 * 0.5 -3.3 M 0.15
 *
 * Написать функцию, которая найдёт точку в данном списке,
 * максимально удалённую от центра масс.
 * Координаты центра масс считаются как
 * X = Sum(Xi*Mi)/Sum(Mi), Y = Sum(Yi*Mi)/Sum(Mi).
 * Для примера центр масс находится в (-1.4125, 4.5625),
 * а максимально удалённая от него точка (0.5, -3.3, M=0.15).
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun massCenter(inputName: String): String {
    val reader = File(inputName).readLines()
    var sumM = 0.0
    var sumXM = 0.0
    var sumYM = 0.0
    var listOfPoints = mutableListOf<String>()
    for (line in reader) {
        if (!Regex("(-?\\d+.\\d+ )+M\\s\\d.\\d+").matches(line)) throw IllegalArgumentException()
        val mass = Regex("M\\s\\d.\\d+").find(line)!!.value.replace("M ", "").toDouble()
        sumM += mass
        val x = Regex("-?\\d+.\\d+").find(line)!!.value.toDouble()
        val y = Regex(" -?\\d+.\\d+ ").find(line)!!.value.replace(" ", "").toDouble()
        val xM = x * mass
        sumXM += xM
        val yM = y * mass
        sumYM += yM
        listOfPoints.add(line)
    }
    val centerX = (((sumXM / sumM) * 10000).roundToInt()).toDouble() / 10000
    val centerY = (((sumYM / sumM) * 10000).roundToInt()).toDouble() / 10000
    val pointOfCenter = Point(centerX, centerY)
    val listOfDistances = mutableListOf<Double>()
    for (i in listOfPoints.indices) {
        val point = Point(
            Regex("-?\\d+.\\d+").find(listOfPoints[i])!!.value.toDouble(),
            Regex(" -?\\d+.\\d+ ").find(listOfPoints[i])!!.value.replace(" ", "").toDouble()
        )
        val distance = point.distance(pointOfCenter)
        listOfDistances.add(distance)
    }
    return listOfPoints[listOfDistances.indexOf(listOfDistances.max())]
}

/**
 * В файле с именем inputName содержится
 * список дат в формате “число месяца”, каждая с новой строки,
 * например:
 *
 * 9 июня
 * 29 апреля
 * 32 июля
 * 1 декабря
 * 5 мая
 * 25 марта
 *
 * Найти в данном списке две ближайшие даты, то есть, такие,
 * количество дней между которыми минимально
 * (в примере, это 29 апреля и 5 мая, между ними 6 дней).
 * Некорректные даты (как 32 июля) не учитывать.
 * Считать, что в феврале 28 дней.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun dates(inputName: String): Any {
    val reader = File(inputName).readLines()
    val lineFiltered = mutableListOf<String>()
    val listOfOrderlyMonth = listOf(
        "января",
        "февраля",
        "марта",
        "апреля",
        "мая",
        "июня",
        "июля",
        "августа",
        "сентября",
        "октября",
        "ноября",
        "декабря"
    )
    for (i in reader) {
        val line = i.split(" ")
        if (line[0].toInt() < 31 && (line[1] == "апреля" || line[1] == "июня" || line[1] == "сентября" || line[1] == "ноября") ||
            line[0].toInt() < 32 && (line[1] == "января" || line[1] == "марта" || line[1] == "мая" || line[1] == "июля" || line[1] == "августа" || line[1] == "октября" || line[1] == "декабря") ||
            line[0].toInt() < 29 && (line[1] == "февраля" ||
                    reader.size <= 12)
        ) {
            lineFiltered.add(i)
        }
    }
    val lineSplit = mutableListOf<List<String>>()
    for (i in lineFiltered) {
        val line = i.split(" ")
        lineSplit.add(line)
    }
    val lineOrdered = lineSplit.sortedBy { listOfOrderlyMonth.indexOf(it[1]) }
    val listOfDatesInNum = mutableListOf<Int>()
    for (i in lineOrdered) {
        when {
            i[1] == "января" -> listOfDatesInNum.add(i[0].toInt())
            i[1] == "февраля" -> listOfDatesInNum.add(i[0].toInt() + 31)
            i[1] == "марта" -> listOfDatesInNum.add(i[0].toInt() + 59)
            i[1] == "апреля" -> listOfDatesInNum.add(i[0].toInt() + 90)
            i[1] == "мая" -> listOfDatesInNum.add(i[0].toInt() + 120)
            i[1] == "июня" -> listOfDatesInNum.add(i[0].toInt() + 151)
            i[1] == "июля" -> listOfDatesInNum.add(i[0].toInt() + 181)
            i[1] == "августа" -> listOfDatesInNum.add(i[0].toInt() + 212)
            i[1] == "сентября" -> listOfDatesInNum.add(i[0].toInt() + 243)
            i[1] == "октября" -> listOfDatesInNum.add(i[0].toInt() + 273)
            i[1] == "ноября" -> listOfDatesInNum.add(i[0].toInt() + 304)
            i[1] == "декабря" -> listOfDatesInNum.add(i[0].toInt() + 334)
        }
    }
    var counter = Int.MAX_VALUE
    var result = ""
    for (i in 0 until listOfDatesInNum.size - 1) {
        val difference = listOfDatesInNum[i + 1] - listOfDatesInNum[i]
        if (difference < counter) {
            counter = difference
            result = ("${lineOrdered[i][0]} ${lineOrdered[i][1]}, ${lineOrdered[i + 1][0]} ${lineOrdered[i + 1][1]}")
        }
    }
    return "$result, между ними $counter дней"
}

/**
 * В файле с именем inputName заданы описания квартир,
 * предлагающихся для продажи, в следующем формате:
 *
 * Пионерская 9-17: комната 18, комната 14, кухня 7, коридор 4
 * Школьная 12-14: комната 19, кухня 8, коридор 3
 * Садовая 19-1-55: комната 12, комната 19, кухня 9, коридор 5
 * Железнодорожная 3-6: комната 21, кухня 6, коридор 4
 *
 * Строчка начинается с адреса квартиры, после двоеточия
 * перечисляются помещения квартиры через запятую, с указанием
 * их площади.
 *
 * Параметр query содержит запрос, начинающийся с названия
 * помещения, за которым следует его минимальная площадь,
 * например, “кухня 8”. Через точку с запятой могут следовать
 * другие ограничения, например “кухня 8; коридор 4”
 * Функция должна найти все квартиры в списке,
 * удовлетворяющие запросу (площадь кухни больше или равна 8,
 * площадь коридора больше или равна 4)
 *
 * “Удовлетворительно” -- в запросе может присутствовать только
 * одно помещение, например, “кухня 8”
 *
 * “Хорошо” -- в запросе может присутствовать несколько помещений,
 * например, “кухня 8; комната 15”
 *
 * “Отлично” -- в запросе может присутствовать два и более
 * однотипных помещения, например, “комната 19; комната 12” --
 * двухкомнатная квартира,
 * одна комната не менее 19, другая не менее 12
 *
 * При нарушении форматов входных данных следует выбрасывать
 * исключение IllegalArgumentException, при невозможности
 * прочитать файл выбрасывать исключение IOException.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun flats3(inputName: String, query: String): String {
    try {
        val reader = File(inputName).readLines()
        val querySplit = query.split(" ")
        val mapOfFlats = mutableMapOf<String, List<List<String>>>()
        for (line in reader) {
            if (!Regex("[А-я]+ \\d+(-\\d+)+:( [а-я]+ \\d+,?)+").matches(line)) throw IllegalArgumentException()
            val address = Regex("[А-я]+ \\d+(-\\d+)+:").find(line)!!.value.replace(":", "")
            val rooms = Regex(" [а-я]+ \\d+").findAll(line)
            val listOfRooms = mutableListOf<String>()
            for (i in rooms) listOfRooms.add(i.value.trim())
            val listOfRoomsSplit = mutableListOf<List<String>>()
            for (i in listOfRooms) listOfRoomsSplit.add(i.split(" "))
            mapOfFlats[address] = listOfRoomsSplit
        }
        val result = mutableListOf<String>()
        for ((key, value) in mapOfFlats) {
            for (room in value) {
                if (querySplit[0] == room[0] && querySplit[1].toInt() <= room[1].toInt()) result += key
            }
        }
        return result.joinToString()
    } catch (e: FileNotFoundException) {
        throw IOException()
    }
}

fun flats4(inputName: String, query: String): String {
    try {
        val reader = File(inputName).readLines()
        val querySplit = query.split("; ")
        val querySpliterator = mutableListOf<List<String>>()
        for (i in querySplit) querySpliterator.add(i.split(" "))
        val mapOfFlats = mutableMapOf<String, List<List<String>>>()
        for (line in reader) {
            if (!Regex("[А-я]+ \\d+(-\\d+)+:( [а-я]+ \\d+,?)+").matches(line)) throw IllegalArgumentException()
            val address = Regex("[А-я]+ \\d+(-\\d+)+:").find(line)!!.value.replace(":", "")
            val rooms = Regex(" [а-я]+ \\d+").findAll(line)
            val listOfRooms = mutableListOf<String>()
            for (i in rooms) listOfRooms.add(i.value.trim())
            val listOfRoomsSplit = mutableListOf<List<String>>()
            for (i in listOfRooms) listOfRoomsSplit.add(i.split(" "))
            mapOfFlats[address] = listOfRoomsSplit
        }
        val result = mutableListOf<String>()
        for ((key, value) in mapOfFlats) {
            for (room in value) {
                for (i in querySpliterator.indices){
                    if (querySpliterator[i][0] == room[0] && querySpliterator[i][1].toInt() <= room[1].toInt()) result.add(key)
                }
            }
        }
        val resultRR = result.groupingBy { it }.eachCount().filter { it.value == querySpliterator.size }.keys.toList()
        return resultRR.joinToString()
    } catch (e: FileNotFoundException) {
        throw IOException()
    }
}

/**
 * В файле с именем inputName заданы результаты игр однокругового
 * футбольного турнира в виде таблицы в следующем формате:
 *
 * Арсенал   0  4  1  1
 * Бавария   1  0  2  3
 * Интер     1  2  0  0
 * Барселона 3  8  0  0
 *
 * Элемент таблицы чисел из i-й строки и j-го столбца содержит
 * число голов, забитое командой i в ворота команды j.
 * Например (см. выделенные элементы) команда 2 (Бавария) и
 * команда 4 (Барселона) сыграли со счетом 3:8.
 * Диагональные элементы (i=j) всегда равны 0.
 * Названия команд не могут содержать пробелы.
 * Соседние столбцы разделены как минимум двумя пробелами.
 *
 * За победу в матче (большее количество мячей) команде даётся 3
 * очка, за ничью (одинаковое количество мячей) - 1 очко.
 *
 * Необходимо посчитать статистику каждой команды по итогам
 * чемпионата и вернуть её как результат функции.
 *
 * “Удовлетворительно” -- достаточно рассчитать суммарное
 * количество мячей, забитых и пропущенных каждой командой
 *
 * “Хорошо” -- для каждой команды рассчитать количество очков,
 * побед, ничьих, поражений,
 * суммарное количество забитых и пропущенных мячей
 *
 * “Отлично” -- также необходимо определить занятые командами
 * места по количеству набранных ими очков, а при равенстве очков
 * -- по разности забитых и пропущенных мячей.
 *
 * При нарушении форматов входных данных следует выбрасывать
 * исключение IllegalArgumentException, при невозможности
 * прочитать файл выбрасывать исключение IOException.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun football(inputName: String): Collection<Any> {
    try {
        val reader = File(inputName).readLines()
        val teamsAndScoresToMap = mutableMapOf<String, List<Int>>()
        val listOfScores = mutableListOf<List<Int>>()
        val listOfTeams = mutableListOf<String>()
        for (line in reader) {
            if (!Regex("[А-я]+\\s+(\\d+(\\s{2})?)+").matches(line)) throw IllegalArgumentException()
            val team = Regex("[А-я]+").find(line)!!.value
            val score = Regex("\\d+").findAll(line)
            val scoreToList = mutableListOf<Int>()
            for (i in score) scoreToList.add(i.value.toInt())
            teamsAndScoresToMap[team] = scoreToList
            listOfScores.add(scoreToList)
            listOfTeams.add(team)
        }
//        println(teamsAndScoresToMap)
//        println(listOfTeams)
        val result3Out = mutableMapOf<String, Int>()
        for ((team, score) in teamsAndScoresToMap) {
            val sumOfGoals = score.sum()
            result3Out[team] = sumOfGoals
//            println("$team, $sumOfGoals - сумма голов, которые $team забила")
        }
        val result3In = mutableMapOf<String, Int>()
        for (i in 0 until teamsAndScoresToMap.values.size) {
            var colSum = 0
            for (scores in teamsAndScoresToMap.values) colSum += scores[i]
            result3In[teamsAndScoresToMap.keys.toList()[i]] = colSum
//            println("${teamsAndScoresToMap.keys.toList()[i]}, $colSum - сумма голов, которые были забиты в ворота ${teamsAndScoresToMap.keys.toList()[i]}")
        }
        println(result3Out)
        println(result3In)
        val result3 = mutableMapOf<String, List<Int>>()
        for ((k, v) in result3Out) {
            result3[k] = listOf(v, result3In[k]) as List<Int>
        }
        println(result3)
        return listOf("bruh")
    }
    catch (e: FileNotFoundException) {
        throw IOException()
    }
}
