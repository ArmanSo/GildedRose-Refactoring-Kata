package com.gildedrose.categories

import com.gildedrose.Item

import org.junit.Assert.*
import org.junit.Test

class ConjuredCategoryTest {
    @Test
    fun `Conjured category, verify quality decrease double than normal update`() {
        val expectedValue = 18
        val value = 20

        val entity = ConjuredCategory(Item("conjured", 100, value))
        entity.update()
        assertEquals(entity.conjured.quality, expectedValue)
    }
}
