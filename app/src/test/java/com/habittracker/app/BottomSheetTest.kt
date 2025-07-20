package com.habittracker.app

import com.habittracker.app.ui.calendar.CalendarDay
import com.habittracker.app.ui.calendar.CalendarViewModel
import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for Bottom Sheet functionality
 */
class BottomSheetTest {

    @Test
    fun testDayDetailItemCreation() {
        val dayDetailItem = CalendarViewModel.DayDetailItem(
            habitName = "测试习惯",
            isCompleted = true,
            description = "测试描述"
        )
        
        assertEquals("测试习惯", dayDetailItem.habitName)
        assertTrue(dayDetailItem.isCompleted)
        assertEquals("测试描述", dayDetailItem.description)
    }

    @Test
    fun testDayDetailItemCompletion() {
        val completedItem = CalendarViewModel.DayDetailItem(
            habitName = "已完成习惯",
            isCompleted = true,
            description = ""
        )
        
        val incompleteItem = CalendarViewModel.DayDetailItem(
            habitName = "未完成习惯",
            isCompleted = false,
            description = ""
        )
        
        assertTrue(completedItem.isCompleted)
        assertFalse(incompleteItem.isCompleted)
        assertNotEquals(completedItem.isCompleted, incompleteItem.isCompleted)
    }

    @Test
    fun testCalendarDaySelection() {
        val selectedDay = CalendarDay(2024, 1, 15, true)
        
        // 验证选中的日期是有效的
        assertTrue(selectedDay.isCurrentMonth)
        assertTrue(selectedDay.day > 0)
        assertTrue(selectedDay.month > 0)
        assertTrue(selectedDay.year > 0)
        
        // 验证日期范围
        assertTrue(selectedDay.day <= 31)
        assertTrue(selectedDay.month <= 12)
        assertTrue(selectedDay.year >= 2020)
    }

    @Test
    fun testEmptyDayDetails() {
        val emptyDetails = emptyList<CalendarViewModel.DayDetailItem>()
        
        assertTrue(emptyDetails.isEmpty())
        assertEquals(0, emptyDetails.size)
    }

    @Test
    fun testMultipleDayDetails() {
        val details = listOf(
            CalendarViewModel.DayDetailItem("习惯1", true, "描述1"),
            CalendarViewModel.DayDetailItem("习惯2", false, "描述2"),
            CalendarViewModel.DayDetailItem("习惯3", true, "")
        )
        
        assertEquals(3, details.size)
        
        val completedCount = details.count { it.isCompleted }
        val incompleteCount = details.count { !it.isCompleted }
        
        assertEquals(2, completedCount)
        assertEquals(1, incompleteCount)
    }
}
