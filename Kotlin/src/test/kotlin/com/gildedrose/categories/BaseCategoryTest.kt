package com.gildedrose.categories

import com.gildedrose.Item

import org.junit.Assert.*
import org.junit.Test

class BaseCategoryTest {
    @Test
    fun `verify itemExpired works`() {
        val expectedValue = 0
        val value = 20

        val entity = BaseCategory(Item("base", 100, value))
        assertEquals(entity.item.quality, value)
        entity.itemExpired()
        assertEquals(entity.item.quality, expectedValue)
    }

    @Test
    fun `verify increaseQuality works with time to sell`() {
        val expectedValueFirst = 21
        val expectedValueSecond = 23
        val value = 20

        val entity = BaseCategory(Item("base", 100, value))
        entity.increaseQuality()
        assertEquals(entity.item.quality, expectedValueFirst)
        entity.increaseQuality(2)
        assertEquals(entity.item.quality, expectedValueSecond)
    }

    @Test
    fun `verify increaseQuality works without have time for sell`() {
        val expectedValueFirst = 22
        val expectedValueSecond = 26
        val value = 20

        val entity = BaseCategory(Item("base", -1, value))
        entity.increaseQuality()
        assertEquals(entity.item.quality, expectedValueFirst)
        entity.increaseQuality(2)
        assertEquals(entity.item.quality, expectedValueSecond)
    }

    @Test
    fun `verify decreaseQuality works with time to sell`() {
        val expectedValueFirst = 19
        val expectedValueSecond = 17
        val value = 20

        val entity = BaseCategory(Item("base", 100, value))
        entity.decreaseQuality()
        assertEquals(entity.item.quality, expectedValueFirst)
        entity.decreaseQuality(2)
        assertEquals(entity.item.quality, expectedValueSecond)
    }

    @Test
    fun `verify decreaseQuality works without have time for sell`() {
        val expectedValueFirst = 18
        val expectedValueSecond = 14
        val value = 20

        val entity = BaseCategory(Item("base", -1, value))
        entity.decreaseQuality()
        assertEquals(entity.item.quality, expectedValueFirst)
        entity.decreaseQuality(2)
        assertEquals(entity.item.quality, expectedValueSecond)
    }

    @Test
    fun `verify updateQuality follows default behavior and reduce amount of quality`() {
        val expectedValue = 19
        val value = 20

        val entity = BaseCategory(Item("base", 10, value))
        assertEquals(entity.item.quality, value)
        entity.updateQuality()
        assertEquals(entity.item.quality, expectedValue)
    }

    @Test
    fun `verify updateSellIn follows default behavior and reduce amount of sellIn`() {
        val expectedValue = 19
        val value = 20

        val entity = BaseCategory(Item("base", value, 10))
        assertEquals(entity.item.sellIn, value)
        entity.updateSellIn()
        assertEquals(entity.item.sellIn, expectedValue)
    }
}
