package com.habittracker.app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test for MainActivity
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNavigationDrawerOpens() {
        // Test that navigation drawer can be opened
        onView(withContentDescription("Open navigation drawer"))
            .perform(click())
        
        // Check if navigation menu items are displayed
        onView(withText(R.string.menu_home))
            .check(matches(isDisplayed()))
        onView(withText(R.string.menu_calendar))
            .check(matches(isDisplayed()))
        onView(withText(R.string.menu_settings))
            .check(matches(isDisplayed()))
        onView(withText(R.string.menu_motivation))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationToCalendar() {
        // Open navigation drawer
        onView(withContentDescription("Open navigation drawer"))
            .perform(click())
        
        // Click on calendar menu item
        onView(withText(R.string.menu_calendar))
            .perform(click())
        
        // Verify calendar fragment is displayed
        // This would need to be adjusted based on actual calendar implementation
    }

    @Test
    fun testNavigationToSettings() {
        // Open navigation drawer
        onView(withContentDescription("Open navigation drawer"))
            .perform(click())

        // Click on settings menu item
        onView(withText(R.string.menu_settings))
            .perform(click())

        // Verify settings fragment is displayed
        // This would need to be adjusted based on actual settings implementation
    }

    @Test
    fun testOptionsMenuSettings() {
        // Click on overflow menu (three dots)
        onView(withContentDescription("More options"))
            .perform(click())

        // Click on Settings option
        onView(withText(R.string.action_settings))
            .perform(click())

        // Verify that we navigated to settings
        // The title should change to settings
        // This is a basic test - in a real scenario you'd check for specific UI elements
    }

    @Test
    fun testOptionsMenuAbout() {
        // Click on overflow menu (three dots)
        onView(withContentDescription("More options"))
            .perform(click())

        // Click on About option
        onView(withText(R.string.action_about))
            .perform(click())

        // Verify that about dialog is displayed
        onView(withText("关于应用"))
            .check(matches(isDisplayed()))

        // Close the dialog
        onView(withText("确定"))
            .perform(click())
    }
}
