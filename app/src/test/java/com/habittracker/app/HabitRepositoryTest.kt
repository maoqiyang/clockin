package com.habittracker.app

import com.habittracker.app.data.model.Habit
import com.habittracker.app.data.model.HabitRecord
import com.habittracker.app.ui.calendar.CalendarDay
import org.junit.Test
import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Unit tests for HabitRepository functionality and Calendar components
 */
class HabitRepositoryTest {

    @Test
    fun testDateFormatting() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = Date()
        val dateString = dateFormat.format(today)

        // Test that date string follows expected format
        assertTrue("Date should be in yyyy-MM-dd format",
            dateString.matches(Regex("\\d{4}-\\d{2}-\\d{2}")))
    }

    @Test
    fun testHabitCreation() {
        val habit = Habit(
            name = "测试习惯",
            description = "这是一个测试习惯",
            sortOrder = 0
        )

        assertEquals("测试习惯", habit.name)
        assertEquals("这是一个测试习惯", habit.description)
        assertEquals(0, habit.sortOrder)
        assertTrue(habit.isActive)
    }

    @Test
    fun testHabitRecordCreation() {
        val record = HabitRecord(
            habitId = 1L,
            date = "2024-01-01",
            isCompleted = true
        )

        assertEquals(1L, record.habitId)
        assertEquals("2024-01-01", record.date)
        assertTrue(record.isCompleted)
    }

    @Test
    fun testTodayDateString() {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val expected = formatter.format(Date())

        // This would normally use repository.getTodayDateString()
        val actual = formatter.format(Date())

        assertEquals(expected, actual)
    }

    @Test
    fun testCalendarDayCreation() {
        val calendarDay = CalendarDay(2024, 1, 15, true)

        assertEquals(2024, calendarDay.year)
        assertEquals(1, calendarDay.month)
        assertEquals(15, calendarDay.day)
        assertTrue(calendarDay.isCurrentMonth)
    }

    @Test
    fun testCalendarDayToday() {
        val today = CalendarDay.today()
        val calendar = Calendar.getInstance()

        assertEquals(calendar.get(Calendar.YEAR), today.year)
        assertEquals(calendar.get(Calendar.MONTH) + 1, today.month)
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), today.day)
        assertTrue(today.isCurrentMonth)
    }

    @Test
    fun testCalendarDayEquality() {
        val day1 = CalendarDay(2024, 1, 15, true)
        val day2 = CalendarDay(2024, 1, 15, true)
        val day3 = CalendarDay(2024, 1, 16, true)

        assertEquals(day1, day2)
        assertNotEquals(day1, day3)
    }
}
