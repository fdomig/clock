package at.seric.example.clock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.time.LocalTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WordClockTest {

    private val clock = WordClock()

    @Test
    internal fun `test hour`() {
        assertEquals("It is six o'clock", clock.get(LocalTime.of(18, 0)))
        assertEquals("It is five o'clock", clock.get(LocalTime.of(17, 0, 59)))
        assertEquals("It is two o'clock", clock.get(LocalTime.of(2, 0, 30)))
        assertEquals("It is twelve o'clock", clock.get(LocalTime.of(0, 0)))
        assertEquals("It is twelve o'clock", clock.get(LocalTime.of(12, 0)))
        assertEquals("It is seven o'clock", clock.get(LocalTime.of(18, 57, 30)))
        assertEquals("It is three o'clock", clock.get(LocalTime.of(14, 59, 59)))
        assertEquals("It is three o'clock", clock.get(LocalTime.of(3, 2, 29)))
    }

    @Test
    internal fun `test five minutes past`() {
        assertEquals("It is five minutes past three", clock.get(LocalTime.of(3, 2, 30)))
        assertEquals("It is five minutes past twelve", clock.get(LocalTime.of(0, 7, 29)))
    }

    @Test
    internal fun `test ten minutes past`() {
        assertEquals("It is ten minutes past one", clock.get(LocalTime.of(1, 7, 30)))
        assertEquals("It is ten minutes past five", clock.get(LocalTime.of(5, 12, 29)))
    }

    @Test
    internal fun `test quarter past`() {
        assertEquals("It is quarter past five", clock.get(LocalTime.of(5, 12, 30)))
        assertEquals("It is quarter past eight", clock.get(LocalTime.of(8, 17, 29)))
    }

    @Test
    internal fun `test twenty minutes past`() {
        assertEquals("It is twenty minutes past eight", clock.get(LocalTime.of(8, 17, 30)))
        assertEquals("It is twenty minutes past two", clock.get(LocalTime.of(2, 22, 29)))
    }

    @Test
    internal fun `test twenty five minutes past`() {
        assertEquals("It is twenty five minutes past two", clock.get(LocalTime.of(2, 22, 30)))
        assertEquals("It is twenty five minutes past two", clock.get(LocalTime.of(2, 27, 29)))
    }

    @Test
    internal fun `test half past`() {
        assertEquals("It is half past two", clock.get(LocalTime.of(2, 27, 30)))
        assertEquals("It is half past two", clock.get(LocalTime.of(2, 32, 29)))
    }

    @Test
    internal fun `test twenty five minutes to`() {
        assertEquals("It is twenty five minutes to three", clock.get(LocalTime.of(2, 32, 30)))
        assertEquals("It is twenty five minutes to twelve", clock.get(LocalTime.of(11, 37, 29)))
    }

    @Test
    internal fun `test twenty minutes to`() {
        assertEquals("It is twenty minutes to twelve", clock.get(LocalTime.of(11, 37, 30)))
        assertEquals("It is twenty minutes to twelve", clock.get(LocalTime.of(11, 42, 29)))
    }

    @Test
    internal fun `test quarter to`() {
        assertEquals("It is quarter to one", clock.get(LocalTime.of(12, 42, 30)))
        assertEquals("It is quarter to one", clock.get(LocalTime.of(12, 47, 29)))
    }

    @Test
    internal fun `test ten minutes to`() {
        assertEquals("It is ten minutes to seven", clock.get(LocalTime.of(18, 47, 30)))
        assertEquals("It is ten minutes to seven", clock.get(LocalTime.of(18, 52, 29)))
    }

    @Test
    internal fun `test five minutes to`() {
        assertEquals("It is five minutes to seven", clock.get(LocalTime.of(18, 52, 30)))
        assertEquals("It is five minutes to seven", clock.get(LocalTime.of(18, 57, 29)))
    }

}
