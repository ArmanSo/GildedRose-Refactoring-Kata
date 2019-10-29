package com.gildedrose.categories

import com.gildedrose.Item

open class BaseCategory(val item: Item) {
    /**
     * Allow to be able to override max limit of quality value.
     * Since we have seen that some products can have different value rather than default one.
     */
    open fun qualityMaxLimit() = 50

    /**
     * The quality of an item can not be more that [qualityMaxLimit]
     */
    fun increaseQuality(value: Int = 1) {
        val valueChange = getValueRelatedToSellIn(value)

        // when quality of item need one more point to reach quality's max limit, we need to limit that value to 1
        // to prevent overflow of quality
        item.quality = when {
            item.quality + valueChange > qualityMaxLimit() -> qualityMaxLimit()
            else -> item.quality + valueChange
        }
    }

    /**
     * Make item expired when it needed.
     * According to docs, when [item] quality is zero it mean expired
     */
    fun itemExpired() {
        item.quality = 0
    }

    /**
     * The quality of an item is never negative
     */
    fun decreaseQuality(value: Int = 1) {
        val valueChange = getValueRelatedToSellIn(value)

        // if quality of item is 1 but amount that we want to decrease is more than one
        // can cause minus quality that not allowed
        item.quality = when {
            item.quality == 1 -> item.quality.dec()
            item.quality > 1 -> item.quality.minus(valueChange)
            else -> 0
        }
    }

    /**
     * Default behavior is decrease one time of [item] sellIn
     */
    open fun updateSellIn() {
        item.sellIn = item.sellIn.dec()
    }

    /**
     * Default behavior is decrease one time of [item] quality
     */
    open fun updateQuality() {
        decreaseQuality()
    }

    /**
     * Update [item]'s props
     */
    fun update() {
        updateSellIn()
        updateQuality()
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast.
     */
    private fun getValueRelatedToSellIn(value: Int) = when {
        item.sellIn < 0 -> 2 * value
        else -> value
    }
}