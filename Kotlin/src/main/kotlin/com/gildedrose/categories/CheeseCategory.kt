package com.gildedrose.categories

import com.gildedrose.Item

data class CheeseCategory(val cheese: Item) : BaseCategory(cheese) {
    /**
     *
     */
    override fun updateQuality() {
        increaseQuality()
    }
}