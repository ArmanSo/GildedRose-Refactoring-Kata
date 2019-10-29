package com.gildedrose.categories

import com.gildedrose.Item


import org.junit.Assert.*
import org.junit.Test

class BackstagePassCategoryTest {
    @Test
    fun `verify quality increase just one with sellIn more than 10`() {
        val expectedValue = 21
        val value = 20

        val entity = BackstagePassCategory(Item("backstage_pass", 12, value))
        assertEquals(entity.backstagePass.quality, value)
        entity.update()
        assertEquals(entity.backstagePass.quality, expectedValue)
    }

    @Test
    fun `verify quality increase just one with sellIn equal to 10`() {
        val expectedValue = 22
        val value = 20

        val entity = BackstagePassCategory(Item("backstage_pass", 10, value))
        assertEquals(entity.backstagePass.quality, value)
        entity.update()
        assertEquals(entity.backstagePass.quality, expectedValue)
    }

    @Test
    fun `verify quality increase just one with sellIn less than 5`() {
        val expectedValue = 23
        val value = 20

        val entity = BackstagePassCategory(Item("backstage_pass", 4, value))
        assertEquals(entity.backstagePass.quality, value)
        entity.update()
        assertEquals(entity.backstagePass.quality, expectedValue)
    }

    @Test
    fun `verify quality become zero when concert finished`() {
        val expectedValue = 0
        val value = 20

        val entity = BackstagePassCategory(Item("backstage_pass", 0, value))
        assertEquals(entity.backstagePass.quality, value)
        entity.update()
        assertEquals(entity.backstagePass.quality, expectedValue)
    }
}
