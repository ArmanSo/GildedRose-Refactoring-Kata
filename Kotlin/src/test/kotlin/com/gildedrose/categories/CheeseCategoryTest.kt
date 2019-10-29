package com.gildedrose.categories

import com.gildedrose.Item

import org.junit.Assert.*
import org.junit.Test

class CheeseCategoryTest {
    @Test
    fun `Cheese category, verify quality increase after update`() {
        val expectedValue = 21
        val value = 20

        val entity = CheeseCategory(Item("cheese", 100, value))
        entity.update()
        assertEquals(entity.cheese.quality, expectedValue)
    }
}
