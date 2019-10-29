package com.gildedrose.categories

import com.gildedrose.Item


data class LegendaryCategory(val legendary: Item) : BaseCategory(legendary) {

    /**
     * Legendary item quality is 80 and it never alters
     * Legendary can not be sold
     */
    init {
        legendary.quality = qualityMaxLimit()
    }

    override fun qualityMaxLimit() = 80
    override fun updateSellIn() = Unit
    override fun updateQuality() = Unit
}