package com.habittracker.app

import com.habittracker.app.ui.calendar.CalendarDay
import org.junit.Test
import org.junit.Assert.*
import java.util.*

/**
 * Unit tests for Calendar functionality
 */
class CalendarTest {

    @Test
    fun testCalendarDayGeneration() {
        // Test calendar day generation logic similar to SimpleCalendarView
        val calendar = Calendar.getInstance()
        calendar.set(2024, Calendar.JANUARY, 1) // January 2024
        
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        
        // January 2024 should have 31 days
        assertEquals(31, daysInMonth)
        assertEquals(2024, year)
        assertEquals(1, month)
    }

    @Test
    fun testFirstDayOfWeekCalculation() {
        val calendar = Calendar.getInstance()
        calendar.set(2024, Calendar.JANUARY, 1) // January 1, 2024
        calendar.firstDayOfWeek = Calendar.SUNDAY
        
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
        
        // January 1, 2024 is a Monday, so it should be 1 (Monday = 2, 2-1 = 1)
        assertEquals(1, firstDayOfWeek)
    }

    @Test
    fun testCalendarGridGeneration() {
        // Simulate the calendar grid generation for January 2024
        val calendar = Calendar.getInstance()
        calendar.set(2024, Calendar.JANUARY, 1)
        calendar.firstDayOfWeek = Calendar.SUNDAY
        
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        
        val days = mutableListOf<CalendarDay>()
        
        // Add empty days for previous month
        repeat(firstDayOfWeek) {
            days.add(CalendarDay(0, 0, 0, false))
        }
        
        // Add days of current month
        for (day in 1..daysInMonth) {
            days.add(CalendarDay(year, month, day, true))
        }
        
        // Add empty days to complete the grid (6 rows * 7 days = 42 total)
        val totalCells = 42
        val remainingCells = totalCells - days.size
        repeat(remainingCells) {
            days.add(CalendarDay(0, 0, 0, false))
        }
        
        // Verify the grid
        assertEquals(42, days.size) // Should always be 42 cells (6 rows * 7 days)
        
        // Count actual month days
        val actualMonthDays = days.count { it.isCurrentMonth && it.day > 0 }
        assertEquals(31, actualMonthDays) // January has 31 days
        
        // Verify first actual day
        val firstActualDay = days.first { it.isCurrentMonth && it.day > 0 }
        assertEquals(1, firstActualDay.day)
        assertEquals(1, firstActualDay.month)
        assertEquals(2024, firstActualDay.year)
        
        // Verify last actual day
        val lastActualDay = days.last { it.isCurrentMonth && it.day > 0 }
        assertEquals(31, lastActualDay.day)
        assertEquals(1, lastActualDay.month)
        assertEquals(2024, lastActualDay.year)
    }

    @Test
    fun testCalendarDayComparison() {
        val day1 = CalendarDay(2024, 1, 15, true)
        val day2 = CalendarDay(2024, 1, 15, true)
        val day3 = CalendarDay(2024, 1, 16, true)
        val emptyDay1 = CalendarDay(0, 0, 0, false)
        val emptyDay2 = CalendarDay(0, 0, 0, false)
        
        // Same days should be equal
        assertEquals(day1, day2)
        
        // Different days should not be equal
        assertNotEquals(day1, day3)
        
        // Empty days should be equal
        assertEquals(emptyDay1, emptyDay2)
        
        // Empty day should not equal actual day
        assertNotEquals(day1, emptyDay1)
    }

    @Test
    fun testTodayFunction() {
        val today = CalendarDay.today()
        val calendar = Calendar.getInstance()
        
        assertEquals(calendar.get(Calendar.YEAR), today.year)
        assertEquals(calendar.get(Calendar.MONTH) + 1, today.month)
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), today.day)
        assertTrue(today.isCurrentMonth)
        assertTrue(today.day > 0)
    }
}
