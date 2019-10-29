package com.gildedrose.categories

import com.gildedrose.Item

data class BackstagePassCategory(val backstagePass: Item) : BaseCategory(backstagePass) {

    /**
     * Quality increases by 2 when there are 10 days or less in sell in
     * Quality increases by 3 when there are 5 days or less in sell in
     * Quality drops to 0 when sell in is 0
     */
    override fun updateQuality() {
        when {
            backstagePass.sellIn in 0..4 -> increaseQuality(3)
            backstagePass.sellIn in 5..9 -> increaseQuality(2)
            backstagePass.sellIn >= 10 -> increaseQuality(1)
            backstagePass.sellIn < 0 -> itemExpired()
        }
    }
}