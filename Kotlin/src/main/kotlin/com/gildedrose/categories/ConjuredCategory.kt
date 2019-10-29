package com.gildedrose.categories

import com.gildedrose.Item

data class ConjuredCategory(val conjured: Item) : BaseCategory(conjured) {
    /**
     * Conjured degrade in quality twice as fast as normal items
     */
    override fun updateQuality() {
        decreaseQuality(2)
    }
}
