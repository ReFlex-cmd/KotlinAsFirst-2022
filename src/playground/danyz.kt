//package playground
//
//import ru.spbstu.wheels.NullableMonad.map
//import java.io.File
//import java.io.FileNotFoundException
//import java.io.IOException
//import java.lang.IllegalArgumentException
//import java.lang.IllegalStateException
//import java.lang.IndexOutOfBoundsException
//import java.lang.NumberFormatException
//import java.util.*
//import kotlin.math.roundToInt
//
//// Вставляете своё задание
//fun myFun(): Collection<Any> = TODO()
//
//
///* На вход подается срока 'board', в которой описано состояние шахматной доски в следующем формате:
//        --------
//        --------
//        --------
//        ------ч-
//        -------ч
//        ч-----б-
//        -------ч
//        --------
//         символ '-' пустая строка, 'б' - белая шашка, 'ч' - черная шашка. WhiteX - расположение по горизонтали белой шашки, WhiteY - по вертикали
//         нужно подсчитать количество черных шашек поблизости
// */
//fun checkers(board: String, WhiteX: Int, WhiteY: Int): Int {
//    val list = Regex("""([-бч]{8})""").findAll(board)
//    if (!Regex("""([бч-]{8}\n){7}[бч-]{8}""").matches(board)) throw IllegalArgumentException()
//    val mWhitex = WhiteX - 1 // столбец
//    val mWhitey = WhiteY - 1 // строка
//    var matrix = mutableListOf(
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>(),
//        mutableListOf<String>()
//    )
//    val listBoard = board.split('\n').map { it.trim() }.reversed()
//    println(listBoard)
//    for (index in listBoard.indices) {
//        for (char in listBoard[index]) matrix[index].add(char.toString())
//    }
//    var counter = 0
//    matrix[mWhitey - 1].subList(mWhitex - 1, mWhitex + 2).forEach { if (it == 'ч'.toString()) counter++ }
//    matrix[mWhitey + 1].subList(mWhitex - 1, mWhitex + 2).forEach { if (it == 'ч'.toString()) counter++ }
//    matrix[mWhitey].subList(mWhitex - 1, mWhitex + 2).forEach { if (it == 'ч'.toString()) counter++ }
//    return counter
//}
//
///* Кодирование длин серий - алгоритм сжатия данных, заменяющий повторяющиеся серии символов на один символ и число его повторений.
//Серией называется последовательность, состоящая из несколько одинаковых символов.
//Например, строка - aaababbcbbb он переводит в a3bab2cb3
//*/
//fun rle(str: String): String {
//    var index = 0
//    var result = ""
//    while (index <= str.length - 1) {
//        var count = 1
//        while (index < str.length - 1 && str[index] == str[index + 1]) {
//            count++
//            index++
//        }
//        result += str[index] + count.toString()
//        index++
//    }
//    result = Regex("1").replace(result, "")
//    return result
//}
///*
//* На вход подаётся изменяемый список places, содержащий информацию
//* о состояний мест в зале в следующен виде: і-ый злемент списка
//* описывает состояние мест в і-ом ряду в зале.
//* Состояние мест в ряду также представлено списком, содержащия true,.
//* если место занято, и false если свободно
//* Например:
//* I[true, false, folse, false, true, folse], [true, folse, true, folse]]
//* Также, на вход подаётся ассоциативный массив requests, содержащий
//* информацию о запросах на места. Ключ это идентификатор зрителя,
//* а значение это поро из номера пядо и количества заказанных нест
//* Например
//* {"Вася" = (0, 2), "Петя" = (1, 1))
//* В примере Вася хочет 2 места в ряди 0, а Петя одно место в ряди 1.
//* Необходико каждому зрителю найти необходиное количество мест в зале
//* и зарезервировать их. Место могут располагаться НЕ рядом.
//* Требуется вернуть для каждого зрителя список зарезервированных
//* для него мест, о также внести изменения в переданный
//* на вход список, содержащий инфорнацию о состоянии мест в зале.
//* Если какому-либо из зрителей невозможно выделить необходиное
//* количество мест требуется выбросить ILlegalStateException.
//* Для данных из примера результат работы может быть следующим:
//* Зарезервированные места:
//* {"Вася" = [1, 51, "Петя" = [31}
//* Измененный список с информацией о местах:
//[true, true, false,false, true, truel, [true, false, true, truell
//* Имя функции и тил результата функции предложить самостоятельно;
//* в заданий указан тип CollectioncAny», го есть коллекция объектов
//* произвольного типа, можно (и нужно) изменить как вид коллекции,
//* так и тип её элементов
//* Кроме функции, следует написать тесты,
//* подтверждающие ее работоспособность.
//* */
//fun buyPlace(place: List<MutableList<Boolean>>, requests: Map<String, List<Int>>): Map<String, List<Any>>{
//    val placeDict = mutableListOf<Map<Boolean, List<Int>>>()
//    for (row in place) {
//        var trueIndex = mutableListOf<Int>()
//        var falseIndex = mutableListOf<Int>()
//        for ((i, e) in row.withIndex()){
//            if (e) trueIndex.add(i)
//            else falseIndex.add(i)
//        }
//        placeDict.add(mapOf(true to trueIndex, false to falseIndex))
//    }
//    // обработка заказа
//    var buySeats = mutableMapOf<String, List<Int>>()
//    for ((name, Seats) in requests) {
//        val lotSeats = requests[name]!![1]
//        val row = requests[name]!![0]
//        val freeSeats = placeDict[row].get(false)
//        if (lotSeats < freeSeats!!.size) {
//            buySeats.put(name, freeSeats.subList(0, lotSeats))
//            for (i in freeSeats.subList(0, lotSeats)) {
//                place[row][i] = true
//            }
//        }
//        if (lotSeats == freeSeats!!.size) {
//            buySeats.put(name, freeSeats)
//            for (i in freeSeats.subList(0, lotSeats)) {
//                place[row][i] = true
//            }
//        }
//        if (lotSeats > freeSeats!!.size) throw IllegalStateException()
//    }
//    return buySeats
//}
//
///**
// * Робот Вася потерялся на поле. Поле задается в следующем формате:
// * xxxxxxOx
// * xxOxxxxx
// * xxxxxxxx
// * xxxxxxxx
// * xxxxxxxx
// * xxOxxxOx
// * xxRxxxxx
// * xxxxxOOx
// *
// * На поле отмечены состояния клеток, всего их может быть три: x — пустая
// * клетка, O — клетка с препятствием, R — клетка с роботом. Считайте что
// * на поле всегда ровно одна клетка занятая роботом.
// *
// * Роботу прислали список команд, которые он должен выполнить, чтобы добраться до
// * точки эвакуации. Состояние поля задается в файле с именем inputName, список
// * команд для робота приходит в списке commands. Вам необходимо вернуть состояние
// * поля после того как робот выполнит все команды. Если робот пытается выйти за
// * пределы поля или перейти на клетку с препятствием — бросить IllegalStateException.
// *
// * "Удовлетворительно" — Поле всегда имеет размер 8х8. У робота есть две команды:
// * ХОД — робот делает один шаг в том направлении, в которое он
// * сейчас смотрит. Изначально робот всегда смотрит на север (т.е. вверх).
// *  На Хорошо: ПОВОРОТ — робот поворачивается на 90 градусов по часовой стрелке
// * (север -> восток -> юг -> запад -> северр).
// *
// *
// * Имя и тип результата функции предложить самостоятельно. Кроме функции,
// * следует написать тесты, подтверждающие её работоспособность
// */
//
//fun roadMap(inputName: String, commands: List<String>): String {
//    val map = File(inputName).readLines().toMutableList()
//    val robot = mutableListOf<Int>()
//    for (row in map.indices) {
//        for (index in map[row].indices) {
//            if (map[row][index] == 'R') {
//                robot.add(row)
//                robot.add(index)
//            }
//        }
//    }
//    println("Первое положение ${robot}")
//    try {
//        val robotWay = Regex("""(Поворот\s)*Ход""").findAll(commands.joinToString(separator = " ")).toMutableList()
//        val countTurn = robotWay.map { it.value.split(" ").size - 1}
//        for (command in commands.indices) {
//            val row = robot[0]
//            val index = robot[1]
//            println(countTurn)
//            for (turn in countTurn) {
//                println(turn)
//                if (map[row - 1][index] == 'x' && turn == 0) {
//                    val robotRow = map[row].toMutableList()
//                    val robotNextRow = map[row - 1].toMutableList()
//                    robotRow[index] = 'x'
//                    map[row] = robotRow.joinToString(separator = "")
//                    robotNextRow[index] = 'R'
//                    map[row - 1] = robotNextRow.joinToString(separator = "")
//                    robot[0] = row - 1
//                    println("поворот вверх ${robot}")}
//                // поворот направо
//                if (map[row][index + 1] == 'x' && turn == 1) {
//                    val robotRow = map[row].toMutableList()
//                    Collections.swap(robotRow, index, index + 1)
//                    map[row] = robotRow.joinToString(separator = "")
//                    println("поворот направо ${robot}")
//                }
//                // поворот вниз
//                if (map[row + 1][index] == 'x' && turn == 2) {
//                    val robotRow = map[row].toMutableList()
//                    val robotNextRow = map[row + 1].toMutableList()
//                    robotRow[index] = 'x'
//                    map[row] = robotRow.joinToString(separator = "")
//                    robotNextRow[index] = 'R'
//                    map[row + 1] = robotNextRow.joinToString(separator = "")
//                    println("поворот вниз ${robot}")
//                }
//                if (commands[command] == "Ход" && map[row - 1][index] == 'O') throw IllegalStateException()
//            }
//        }
//    } catch (e: IndexOutOfBoundsException) {throw IllegalStateException()}
//    return map.joinToString(separator = "\n")
//}
//
///*
//БИЛЕТ 12
//* В файле с именем inputName содержится список дел, например:
//*
//* Вымыть пол -- важность 2, 45 минут
//* Сходить в магазин -- важность 2, 75 минут
//* Приготовить еду -- важность 3, 30 минут
//* Написать программу -- важность 1, 45 минут
//*
//* Для каждого дела через чёрточку указана его важность и занимаемое время
//* Отдельным параметром limit зада лимит времени в минутах, например 90 мин.
//*
//* Найти два дела, суммарное время выполнения которых умещается в заданный лимит,
//* и при этом имеют максимально возможную суммарную важность. Для примера это
//* Вымыть пол и приготовить еду, сумма важности 5, сумма времени 75 мин.
//* Бросить IllegalArgumentException, если двух таких дел нет.
// */
//
//fun foo(inputName: String, limit: Int): Any {
//    var m = File(inputName).readLines().toMutableList()
//    val importance = mutableMapOf<String, Int>()
//    val time = mutableMapOf<String, Int>()
//    for (i in m) {
//        val name = i.split("--")
//        val numRegex = Regex("""\d+""").findAll(name[1])
//        val num = mutableListOf<Int>()
//        numRegex.forEach { num.add(it.value.toInt()) }
//        importance.put(name[0], num[0])
//        time.put(name[0], num[1])
//    }
//    val sortedImportance = importance.toList().sortedBy { (key, value) -> value }.reversed().toMap() // сортирую словарь по ключам
//    for (i in 0 until sortedImportance.keys.size - 1) {
//        for (j in i + 1 until sortedImportance.keys.size) {
//            val time1 = time[sortedImportance.keys.toMutableList()[i]]
//            val time2 = time[sortedImportance.keys.toMutableList()[j]]
//            println("time1 - $time1, time2 - $time2")
//            if (time1!! + time2!! <= limit) {
//                val importance1 = sortedImportance[sortedImportance.keys.toMutableList()[i]]!!
//                val importance2 = sortedImportance[sortedImportance.keys.toMutableList()[j]]!!
//                val result = listOf(importance1 + importance2, time1 + time2)
//                return result
//            }
//        }
//    }
//    throw IllegalArgumentException()
//}
///* В файле с именем іnputName задана таблица результатов чемпионата по
//футболу:
//O W W D - Зенит
//L O W D - Спартак
//L L O W - ЦСКА
//D D L O - Локомотив
//Каждая строка соответствует результатам одной из команд (имя команды задается в конце строки через дефис),
//в примере первая строка соответствует результатам Зенита, вторая - Спартака и т.д.
//Ячейка таблицы (і, j) соответствует тому как команда і сыграла с командой j.
//Результат может быть трех видов: W - победа, 'D'- ничья, 'L' - поражение. Значение ячейки (і, j) коррелирует с результатом
//ячейки (i, j). Если (i, j) == W, mo (j, i) == L' и т.д. Также, главная диагональ матрицы всегда заполнена 0,
//т.к. команда не может сыграть сама с собой. За победу команда получает 3 очка, за ничью - 1 очко, за поражение - 0 очков.
//При нарушении формата исходной или обнаружении несоответствия в исходных данных бросить IllegalStateException.
//Число команд, присутствующее в таблице, не ограничивается.
//• Удовлетворительно - команды, набравшей наибольшее количество очков. Если таких команд несколько - вернуть имя одной из этих команд.
//• Хорошо - вернуть список команд чемпионата, упорядоченный в соответствии с позициями в чемпионате.
//При равенстве очков у двух команд их порядок может быть произвольным.
//• Отлично - вернуть список команд чемпионата, упорядоченный в соответствии их позициями в чемпионате. Команды упорядочиваются по количеству набранных
//очков. Если у двух команд одинаковое количество очков, то команда, победившая в личной встрече занимает более высокую позицию.
//Если личная встреча этих команд закончилась ничьей, то упорядочить их в алфавитном порядке.
//В первой строке задаются номера команд в таблице. Каждая следующая строка содержит результаты одной из команд. Вернуть список команд чемпионата.
//Упорядоченный в соответствии с их позициями в чемпионате.
// */
//fun footballTable(inputName: String): List<String> {
//    val table = File(inputName).readLines()
//    val scoreTable = mutableMapOf<String, Int>()
//    for (line in table) {
//        if (!Regex("""([OLWD ])+ - ([а-яА-Я])+""").matches(line)) throw IllegalStateException()
//        val line1 = Regex("""W""").replace(line, "3")
//        val line2 = Regex("""D""").replace(line1, "1")
//        val line3 = Regex("""[LO]""").replace(line2, "0")
//        val s = line3.split(" - ")
//        val score = s[0].split(" ").map { it.toInt() }.sum()
//        scoreTable.put(s[1], score)
//    }
//    val sortedScoreTable = scoreTable.toList().sortedBy { (key, value) -> value }.reversed().toMap()
//    println(sortedScoreTable)
//    val bestTeam = sortedScoreTable.keys.toMutableList()
//    return bestTeam
//}
///*
//* В файле с именем inputName задан текст, содержащий в себе элементы
//* разметки adoc (см. ниже). Преобразовать текст в соответствии с разметкой
//* в формат HTML и вывести его в файл с именем outputName.
//* Соблюсти следующие правила:
//*
//* “Удовлетворительно” — обернуть весь текст тегами <html><body>...</body></html>.
//* Поддержать adoc заголовки (строки, начинающиеся с =, ==, ===)
//* = Заголовок 1 adoc (заменить на) <h1>Заголовок 1 adoc</h1>
//* == Заголовок 2 adoc (заменить на) <h2>Заголовок 2 adoc</h2>
//* === Заголовок 3 adoc (заменить на) <h3>Заголовок 3 adoc</h3>
//*
//* “Хорошо” — кроме этого, поддержать параграфы и переводы строк.
//* Границами параграфов adoc являются заголовки (=, ==, ===) и пустые строки.
//* В HTML параграфы обернуть в <p>...</p>.
//* Перевод строки в adoc кодируется символом +, в HTML он заменяется тегом <br>.
//*
//* При нарушении формата входных данных следует выбрасывать
//* исключение IllegalArgumentException. При невозможности
//* прочитать файл выбрасывать исключение IOException.
//*
//* Кроме функции следует написать тесты, подтверждающие её работоспособность.
//
//*/
//
//fun adocTohtml(inputName: String, outputName: String) {
//    val reader = File(inputName).readLines()
//    val writer = File(outputName).bufferedWriter()
//    var result = ""
//    for (index in reader.indices) {
//        val line = reader[index]
//        if (!Regex("""([=]|[+])+ .*""").matches(line)) throw IllegalArgumentException()
//        when {
//            line.substring(0, 3) == "===" -> result += "<h3>${line.substring(4)}</h3>"
//            line.substring(0, 2) == "==" -> result += "<h2>${line.substring(3)}</h2>"
//            line.substring(0, 1) == "=" -> result += "<h1>${line.substring(2)}</h1>"
//            line.substring(0, 1) == "+" -> result += "<br>${line.substring(2)}</br>"
//        }
//    }
//    result = "<html><body>${result}</body></html>"
//    writer.write(result)
//    writer.close()
//}
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
//fun complementText(inputName: String, outputName: String, changes: List<String>) {
//    val reader = File(inputName).readLines()
//    val writer = File(outputName).bufferedWriter()
//    for (index in 0 until reader.size - 1) {
//        if (!Regex("""\d+ [а-яА-я ]*""").matches(reader[index])) throw IllegalArgumentException()
//        writer.write(reader[index])
//        writer.newLine()
//        for (change in changes) {
//            if (!Regex("""\d+ [а-яА-я ]*""").matches(change)) throw IllegalArgumentException()
//            if (reader[index][0].toInt() < change[0].toInt() && change[0].toInt() < reader[index + 1][0].toInt()) {
//                writer.write(change)
//                writer.newLine()
//            }
//        }
//    }
//    if (!Regex("""\d+ [а-яА-я ]*""").matches(reader.last())) throw IllegalArgumentException()
//    writer.write(reader.last())
//    writer.close()
//}
///*
//* В файле с именем inputName задана таблица действительных чисел.
// * Столбцы таблицы разделены запятыми и пробелами.
// * Каждая строка содержит не более 26 значений. Пример:
// *
// * 1.5, 2.67, 3.0, 1.4
// * 5.2, 7.1, -4.8, 0.0
// * 1.4, 6.0, 2.5, -1.9
// * В строковом параметре range задан диапазон из двух ячеек
// * этой таблицы, разделённых чёрточкой, например “A2-C4” или
// * “A31-B42”
// * Ячейки закодированы так: столбец задаётся заглавной буквой
// * латинского алфавита (первый столбец это буква А),
// * а строка - целым числом (первая строка это число 1).
// *
// * Необходимо посчитать среднее арифметическое значений во всех
// * ячейках заданного диапазона заданной таблицы. Диапазон задаёт
// * углы прямоугольника -- например “А2-С3” соответствует
// * ячейкам A2, A3, B2, B3, C2, C3
// *
// * “Удовлетворительно” -- все строки содержат одинаковое
// * количество чисел, заданный диапазон относится к одной строке,
// * первая ячейка в нём обязательно находится слева,
// * например, “B3-D3” (содержит B3, C3, D3)
// *
// * “Хорошо” -- диапазоны могут содержать ячейки из разных строк
// * с произвольным положением углов, например, “B1-A2”
// * соответствует ячейкам A1, A2, B1, B2
// *
// * “Отлично” -- строки могут содержать разное количество
// * чисел. Кроме того, диапазон может включать ячейки за пределами
// * входной таблицы, это не является ошибкой,
// * ячейки за пределами таблицы просто не учитываются.
// * Пример: диапазон “E1-B2” содержит B1, C1, D1, B2, C2, D2
// *
// * При нарушении форматов входных данных следует выбрасывать
// * исключение IllegalArgumentException. При невозможности
// * прочитать файл выбрасывать исключение IOException.
// *
// * Предложить самостоятельно имя функции. Кроме функции следует
// * написать тесты, подтверждающие её работоспособность.
// */
//fun medianValue(inputName: String, range: String): Double {
//    try {
//
//        val reader = File(inputName).readLines()
//        val table = mutableListOf<List<Double>>()
//        for (line in reader) {
//            if (!Regex("""([-]?\d+\.\d+[,]?\s*.*)""").matches(line)) throw IllegalArgumentException()
//            table.add(line.split(", ").map { it.toDouble() })
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
//* В файле с именем inputName заданы ежедневные сведения о
// * количестве выпавших осадков (в мм) в различные месяцы года,
// * всего не более чем 31 значение в каждой строке и
// * не более 12 строк во всём файле, например:
// *
// * Март 0 1 0 3 41 2 0 0 13 16 20 8 0 4 8 1 0 0 0 7 12 0 4 9
// * Апрель 0 0 0 17 0 0 11 48 42 0 0 1 7 15 18 0 0 0 0 0 8 2 17 0
// * Май 10 15 48 21 0 0 17 22 30 0 0 13 0 0 2 5 7 0 0 0 1 10 3
// *
// * Каждая строка начинается с названия месяца, за которым
// * следует последовательность целых чисел - уровень осадков в мм
// * в различные дни этого месяца, начиная с 1-го. Порядок месяцев
// * в файле должен соответствовать реальному (следующий месяц всегда
// * ниже предыдущего).
// *
// * В строковом параметре days задан интервал дат
// * либо в формате “Апрель 9..15”  (дни в одном месяце),
// * либо в формате “Март 22..Май 8” (дни в разных месяцах).
// *
// * Необходимо рассчитать максимальный уровень осадков за один день
// * в заданном интервале дат. Например, для “Апрель 9..15” это 42,
// * для “Март 22..Май 8” это 48. Отсутствующие дни игнорировать.
// *
// * “Удовлетворительно” -- используется только первый формат для
// * параметра days - все дни в одном месяце
// *
// * “Хорошо” -- может использоваться как первый, так и второй
// * формат для параметра days, то есть, интервал может содержать
// * дни в разных месяцах
// *
// * “Отлично” -- результат функции должен содержать не только
// * максимальный уровень осадков, но и список дней,
// * в которых он был достигнут
// * (42, 9 апреля или 48, 8 апреля, 3 мая для примеров выше)
// *
// * При нарушении форматов входных данных следует выбрасывать
// * исключение IllegalArgumentException. При невозможности
// * прочитать файл выбрасывать исключение IOException.
// *
// * Предложить имя и тип результата функции. Кроме функции
// * следует написать тесты, подтверждающие её работоспособность.
// */
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
//    } catch (e: FileNotFoundException) {throw IOException()}}
//
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
//fun f1dan(inputName: String):Any {
//    val reader = File(inputName).readLines()
//    val teamTable = mutableMapOf<String, Int>()
//    var team = ""
//    var score = 0
//    for (line in reader) {
//        if (Regex("""([А-Я]. [А-Яа-я]+, .*)""").matches(line)) {
//            team = Regex("""(([^А-Я.][,]) [А-Яа-я ]+)""").find(line)!!.value.toString().substring(3)
//            score = Regex("""\d+""").find(line)!!.value.toInt()
//            if (team.isNotEmpty() && team !in teamTable.keys) {
//                teamTable.put(team, 0)
//            }
//            if (team in teamTable.keys) {
//                teamTable[team] = teamTable[team]!! + score
//            }
//        }
//
//    }
//    val sortedScoreTable = teamTable.toList().sortedBy { (key, value) -> value }.reversed().toMap()
//    val listTable = sortedScoreTable.toList()
//    val result = mutableListOf<Pair<String, Int>>()
//    for (index in 0 until listTable.size - 1) {
//        val team = listTable[index]
//        val secondteam = listTable[index + 1]
//        if (team.second == secondteam.second) {
//            if (team.first < secondteam.first) {
//                result.add(team)
//                result.add(secondteam)
//            } else {
//                result.add(secondteam)
//                result.add(team)
//            }
//        }
//        if (team !in result) {result.add(team)}
//    }
//    if (listTable.last() !in result) {
//        result.add(listTable.last())
//    }
//    var str =""
//    for ((first, second) in result) {
//        str += "$first, "
//        str += "$second, "
//    }
//
//    return str.substring(0, str.lastIndex - 1)
//}
//
///*
//* В файле с менем inputName содержатся
//маршруты общественного транспорта в следующем формате:
//*
//троллейбус 15 ул. Железнодорожная > ул. Садовая > ул. Пионерская > Московское ш.
//автобус 17 ул. Железнодорожная > ул. Садовая » ул. Центральная > Парк отдыха
//трамвай 3 Парк отдыха > ул. Деорцовая > Проспект мира
//автобус 4 ул. Железнодорожная > Путепровод > Аэропорт
//троллейбус 4 Путепровод > ул. Центральная > аллея Культуры > Московское ш.
//*
//В каждой строчке файла указан вид транспорта (автобус, троллейбус, трамвай),
//номер маршрута и список остановок, разделённых знаком >. Считается, что каждый
//маршрут действует и в прямом, и в обратном направлении.
//"Удовлетворительно" - построить прямой маршрут (без пересадок) от станции sre
//до станции dst. Например: src-"Парк отдыха", dst-"ул. Дворцовая
//ответ="трамвай 3" (вернуть любой возможный вариант)
//
//При нарушении форматов входных данных следует выбрасывать
//исключение EllegalArgumentException. При невозможности
//прочитать файл выбрасывать исключение IOException.
//Предложить имя и тил результата функции. Кроме функции
//следует написать тесты, подтверждающие её работоспособность.
// */
//fun way(inputame: String, sre: String, dst: String): String {
//    try {
//        val reader = File(inputame).readLines()
//        val paths = mutableMapOf<String, List<String>>()
//
//        for (line in reader) {
//            if (!Regex("""([А-я]+ \d+)(\s*([А-я]+. |[А-я])+>)+([А-я]*)\s[А-я].*""").matches(line)) throw IllegalArgumentException()
//            val name = Regex("""[а-я ]+\d+""").find(line)!!.value
//            val path = Regex(""" [А-я. ]+""").findAll(line).map { it.value.trim() }.toMutableList()
//            paths.put(name, path)
//
//        }
//        for (key in paths.keys) {
//            if (sre in paths[key]!! && dst in paths[key]!!) {
//                return key
//            }
//        }
//    } catch (e:FileNotFoundException) {throw IOException()}
//    throw IllegalArgumentException()
//}
//
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
////
//fun wayAway(inputName: String, src: String, dst: String): String {
//    try {
//        val reader = File(inputName).readLines()
//        val paths = mutableMapOf<String, List<String>>()
//        for (line in reader) {
//            if (!Regex("""([А-я]+ \d+)(\s*([А-я]+. |[А-я])+>)+([А-я]*)\s[А-я].*""").matches(line)) throw IllegalArgumentException()
//            val nameOfRoute = Regex("""[А-я]+ \d+""").find(line)!!.value
//            val routeInStops = Regex(""" [А-я. ]+""").findAll(line)!!.map { it.value.trim() }.toMutableList()
//            paths[nameOfRoute] = routeInStops
//        }
//        for (key in paths.keys) if (src in paths[key]!! && dst in paths[key]!!) return key
//    } catch (e: FileNotFoundException) {
//        throw IOException()
//    }
//    throw IllegalArgumentException()
//}
//
//
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
////