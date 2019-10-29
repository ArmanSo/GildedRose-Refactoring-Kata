package com.gildedrose

import com.gildedrose.categories.*

class GildedRose(var items: Array<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val MANA_CAKE = "Conjured Mana Cake"

        fun getTypedItem(item: Item): BaseCategory {
            return when (item.name) {
                AGED_BRIE -> CheeseCategory(item)
                TAFKAL80ETC_CONCERT -> BackstagePassCategory(item)
                SULFURAS -> LegendaryCategory(item)
                MANA_CAKE -> ConjuredCategory(item)
                else -> BaseCategory(item)
            }
        }
    }

    fun updateQuality() {
        items.forEach { getTypedItem(it).update() }
    }
}

