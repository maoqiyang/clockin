package com.habittracker.app

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for Menu functionality
 */
class MenuTest {

    @Test
    fun testMenuItemIds() {
        // 验证菜单项ID的存在性（这些会在编译时检查）
        val settingsId = R.id.action_settings
        val aboutId = R.id.action_about
        
        // 确保ID不为0（表示资源存在）
        assertTrue("Settings menu item should exist", settingsId != 0)
        assertTrue("About menu item should exist", aboutId != 0)
        
        // 确保ID不相同
        assertNotEquals("Menu items should have different IDs", settingsId, aboutId)
    }

    @Test
    fun testStringResources() {
        // 这个测试主要是为了确保字符串资源存在
        // 在实际的Android测试中，这些会通过Context来验证
        val actionSettings = R.string.action_settings
        val actionAbout = R.string.action_about
        val menuSettings = R.string.menu_settings
        
        assertTrue("action_settings string should exist", actionSettings != 0)
        assertTrue("action_about string should exist", actionAbout != 0)
        assertTrue("menu_settings string should exist", menuSettings != 0)
    }

    @Test
    fun testNavigationMenuItems() {
        // 验证导航菜单项ID
        val navHome = R.id.nav_home
        val navCalendar = R.id.nav_calendar
        val navSettings = R.id.nav_settings
        val navMotivation = R.id.nav_motivation
        
        // 确保所有导航项都存在且不同
        val navIds = setOf(navHome, navCalendar, navSettings, navMotivation)
        assertEquals("All navigation items should be unique", 4, navIds.size)
        
        // 确保没有ID为0
        navIds.forEach { id ->
            assertTrue("Navigation item ID should not be 0", id != 0)
        }
    }

    @Test
    fun testMenuResourceConsistency() {
        // 验证菜单相关的资源一致性
        val mainMenuId = R.menu.main
        val drawerMenuId = R.menu.activity_main_drawer
        
        assertTrue("Main menu should exist", mainMenuId != 0)
        assertTrue("Drawer menu should exist", drawerMenuId != 0)
        assertNotEquals("Menu resources should be different", mainMenuId, drawerMenuId)
    }
}
