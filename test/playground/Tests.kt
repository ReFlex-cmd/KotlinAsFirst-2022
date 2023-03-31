package playground

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import java.io.IOException
import java.lang.IllegalStateException


class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

//    @Test
//    fun penis() {
//        assertEquals(
//            "трамвай 3", playground.wayAway("input/ways.txt", "Парк отдыха", "ул. Дворцовая")
//        )
//        assertThrows(java.lang.IllegalArgumentException::class.java) {
//            playground.wayAway("input/ways2.txt", "Парк отдыха", "ул. Дворцовая")
//        }
//        assertThrows(
//            IOException::class.java
//        ) {
//            playground.wayAway("input/ways3.txt", "Парк отдыха", "ул. Дворцовая")
//        }
//    }
//
//    @Test
//    fun veshalka() {
//        playground.theatre("input/theatre.txt", "temp.txt", listOf("2 Следующий акт", "5 Вторая глава"))
//        assertFileContent(
//            "temp.txt",
//            """
//            1 Первое действие
//            2 Следующий акт
//            3 Интерлюдия
//            5 Вторая глава
//            6 Послесловие
//            """.trimIndent()
//        )
//        File("temp.txt").delete()
//        assertThrows(
//            java.lang.IllegalArgumentException::class.java
//        ) {
//            playground.theatre("input/ways2.txt", "temp.txt", listOf("II Путин против Зеленского", "V против Z"))
//        }
//    }
//
//    @Test
//    fun medianValue() {
//        assertEquals(
//            2.775,
//            playground.averageValue("input/AverageValues.txt", "A2-D4")
//        )
//        assertEquals(
//            5.65,
//            playground.averageValue("input/AverageValues.txt", "C4-B3")
//        )
//        assertThrows(
//            java.lang.IllegalArgumentException::class.java
//        ) {
//            playground.averageValue("input/f1.txt", "A2-B4")
//        }
//    }
//
//    @Test
//    fun maxPrecipitation() {
//        assertEquals(
//            42,
//            playground.recipitation("input/precipitation.txt", "Апрель 9..15")
//        )
//        assertThrows(
//            java.lang.IllegalStateException::class.java
//        ) {
//            playground.recipitation("input/ways2.txt", "Март 10..15")
//        }
//        assertThrows(IOException::class.java) {
//            playground.recipitation("input/ways3.txt", "Март 10..15")
//        }
//    }

    @Test
    fun faggotsNiggers() {
        assertEquals(
            "Buster--144000",
            playground.streamers("input/nword.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.streamers("input/ways2.txt")
        }
    }

    @Test
    fun faggotsNiggers2() {
        assertEquals(
            "Buster--144000",
            playground.streamers2("input/nword2.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.streamers2("input/ways2.txt")
        }
    }

    @Test
    fun f1Tour() {
        assertEquals(
            "Мерседес, 20, Феррари, 11, Макларен, 9, Ред Булл, 9",
            playground.f1Tournament("input/f1.txt")
        )
//        assertThrows(
//            java.lang.IllegalArgumentException::class.java
//        ) {
//            playground.f1Tournament("input/ways2.txt")
//        }
    }

    @Test
    fun maxPrecipitation() {
        assertEquals(
            48,
            playground.fallout("input/precipitation.txt", "Март 22..Май 8")
        )
//        assertThrows(
//            java.lang.IllegalArgumentException::class.java
//        ) {
//            playground.fallout("input/ways2.txt", "Март 10..15")
//        }
//        assertThrows(IOException::class.java) {
//            playground.fallout("input/ways3.txt", "Март 10..15")
//        }
    }

    @Test
    fun gamers() {
        assertEquals(
            "Team Concert",
            playground.doka2("input/doka2.txt")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.doka2("input/ways2.txt")
        }
    }

    @Test
    fun penis() {
        assertEquals(
            "трамвай 3", playground.wayAway("input/ways.txt", "Парк отдыха", "ул. Дворцовая")
        )
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            playground.wayAway("input/ways2.txt", "Парк отдыха", "ул. Дворцовая")
        }
        assertThrows(
            IOException::class.java
        ) {
            playground.wayAway("input/ways3.txt", "Парк отдыха", "ул. Дворцовая")
        }
    }

    @Test
    fun medianValue() {
        assertEquals(
            2.775,
            playground.averageValue("input/AverageValues.txt", "A2-D4")
        )
        assertEquals(
            5.65,
            playground.averageValue("input/AverageValues.txt", "C4-B3")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.averageValue("input/f1.txt", "A2-B4")
        }
    }

    @Test
    fun f1() {
        assertEquals(
            "Мерседес, 20, Феррари, 11, Макларен, 9, Ред Булл, 9",
            playground.f1("input/f1.txt")
        )
//        assertThrows(
//            java.lang.IllegalArgumentException::class.java
//        ) {
//            playground.f1("input/ways2.txt")
//        }
    }

    @Test
    fun gays() {
        assertEquals(
            "Team Concert",
            playground.dota2("input/doka2.txt")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.dota2("input/ways2.txt")
        }
    }
    @Test
    fun faggotsNiggers3() {
        assertEquals(
            "Buster--144000",
            playground.gaysex("input/nword2.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.gaysex("input/ways2.txt")
        }
    }
    @Test
    fun triangle() {
        assertEquals(
            "XYZ",
            playground.triangle("input/triangle.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.triangle("input/ways2.txt")
        }
    }

    @Test
    fun matrix() {
        assertEquals(
            listOf(listOf(11, 13, 15), listOf(17, 19, 21), listOf(23, 25, 27)),
            playground.matrix(
                listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)),
                listOf(listOf(10, 11, 12), listOf(13, 14, 15), listOf(16, 17, 18))
            )
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.matrix(
                listOf(listOf(1), listOf(5, 9, 7)),
                listOf(listOf(4444, 852, 8), listOf(4), listOf(88, 985, 84, 71))
            )
        }
    }

    @Test
    fun triangles2() {
        assertEquals(
            "B, C, D",
            playground.triangles2("input/triangles2.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.triangles2("input/ways2.txt")
        }
    }

    @Test
    fun parents() {
        assertEquals(
            Pair("Mike", "Derek"),
            playground.parents("input/parents.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.parents("input/ways2.txt")
        }
    }

    @Test
    fun rectangles() {
        assertEquals(
            Pair("GREEN", "BLUE"),
            playground.rectangles("input/rectangles.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.rectangles("input/ways2.txt")
        }
    }

    @Test
    fun massCenter() {
        assertEquals(
            "0.5 -3.3 M 0.15",
            playground.massCenter("input/massCenter.txt")
        )
        assertThrows (
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.massCenter("input/ways2.txt")
        }
    }

    @Test
    fun dates() {
        assertEquals(
            "29 апреля, 5 мая, между ними 6 дней",
            playground.dates("input/dates.txt")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.dates("input/ways2.txt")
        }
    }

    @Test
    fun flats3() {
        assertEquals(
            "Школьная 12-14, Садовая 19-1-55",
            playground.flats3("input/flats.txt", "кухня 8")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.flats3("input/ways2.txt", " ")
        }
        assertThrows(
            IOException::class.java
        ) {
            playground.flats3("input/ways3.txt", "кухня 8")
        }
    }

    @Test
    fun flats4() {
        assertEquals(
            "Школьная 12-14, Садовая 19-1-55",
            playground.flats4("input/flats.txt", "кухня 8; комната 15")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.flats4("input/ways2.txt", " ")
        }
        assertThrows(
            IOException::class.java
        ) {
            playground.flats4("input/ways3.txt", "кухня 8")
        }
    }

    @Test
    fun football() {
        assertEquals(
            "bruh",
            playground.football("input/football.txt")
        )
        assertThrows(
            java.lang.IllegalArgumentException::class.java
        ) {
            playground.football("input/ways2.txt")
        }
        assertThrows(
            IOException::class.java
        ) {
            playground.football("input/ways3.txt")
        }
    }
}