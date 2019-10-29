package com.gildedrose.categories

import com.gildedrose.Item

import org.junit.Assert.*
import org.junit.Test

class LegendaryCategoryTest {
    @Test
    fun `Legendary category, verify quality it's not changing`() {
        val expectedValue = 80
        val value = 80

        val entity = LegendaryCategory(Item("legendary", 100, value))
        assertEquals(entity.legendary.quality, expectedValue)
        entity.update()
        assertEquals(entity.legendary.quality, expectedValue)
    }

    @Test
    fun `Legendary category, verify quality always 80 even with wrong input`() {
        val expectedValue = 80
        val value = 100

        val entity = LegendaryCategory(Item("legendary", 100, value))
        assertEquals(entity.legendary.quality, expectedValue)
    }
}
