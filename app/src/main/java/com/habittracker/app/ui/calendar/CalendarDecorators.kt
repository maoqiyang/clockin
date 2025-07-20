package com.habittracker.app.ui.calendar

class CompleteDayDecorator(private val dates: Collection<CalendarDay>) : CalendarDecorator {

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return dates.contains(day)
    }

    override fun getBackgroundColor(): Int {
        return 0xFF4CAF50.toInt() // Green
    }
}

class PartialDayDecorator(private val dates: Collection<CalendarDay>) : CalendarDecorator {

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return dates.contains(day)
    }

    override fun getBackgroundColor(): Int {
        return 0xFFFFC107.toInt() // Yellow
    }
}

class IncompleteDayDecorator(private val dates: Collection<CalendarDay>) : CalendarDecorator {

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return dates.contains(day)
    }

    override fun getBackgroundColor(): Int {
        return 0xFFE0E0E0.toInt() // Gray
    }
}

class TodayDecorator : CalendarDecorator {

    private val today = CalendarDay.today()

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day.year == today.year && day.month == today.month && day.day == today.day
    }

    override fun getBackgroundColor(): Int {
        return 0xFF2196F3.toInt() // Blue
    }
}
