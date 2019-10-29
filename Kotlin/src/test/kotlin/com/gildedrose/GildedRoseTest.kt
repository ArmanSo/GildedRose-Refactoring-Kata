package com.gildedrose

import com.gildedrose.categories.*
import io.mockk.*
import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {

    private val cheeseItem = Item(GildedRose.AGED_BRIE, 0, 0)
    private val backstagePassItem = Item(GildedRose.TAFKAL80ETC_CONCERT, 0, 0)
    private val conjuredItem = Item(GildedRose.MANA_CAKE, 0, 0)
    private val legendaryItem = Item(GildedRose.SULFURAS, 0, 0)
    private val unknownItem = Item("something", 0, 0)

    @Test
    fun `verify item Item type works correctly`() {
        val cheeseCategory = GildedRose.getTypedItem(cheeseItem)
        val backstagePassCategory = GildedRose.getTypedItem(backstagePassItem)
        val conjuredCategory = GildedRose.getTypedItem(conjuredItem)
        val legendaryCategory = GildedRose.getTypedItem(legendaryItem)
        val unknownCategory = GildedRose.getTypedItem(unknownItem)

        assertTrue(cheeseCategory is CheeseCategory)
        assertTrue(backstagePassCategory is BackstagePassCategory)
        assertTrue(conjuredCategory is ConjuredCategory)
        assertTrue(legendaryCategory is LegendaryCategory)
        assertTrue(unknownCategory is BaseCategory)
    }

    @Test
    fun `verify update quality works and items`() {
        val items = arrayOf(cheeseItem)
        val spyBaseCategory = spyk(BaseCategory(cheeseItem))

        mockkObject(GildedRose)
        every { GildedRose.getTypedItem(any()) } returns spyBaseCategory

        GildedRose(items).updateQuality()

        verify(exactly = 1) { spyBaseCategory.update() }
    }
}


