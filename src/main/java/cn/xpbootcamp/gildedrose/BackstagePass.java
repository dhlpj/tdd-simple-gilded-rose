package cn.xpbootcamp.gildedrose;

public class BackstagePass extends Product {

    public static final int SELL_IN_GREATER_THAN_TEN_QUALITY_INCREMENT = 1;
    public static final int SELL_IN_GREATER_THAN_FIVE_QUALITY_INCREMENT = 2;
    public static final int SELL_IN_GREATER_THAN_ZERO_QUALITY_INCREMENT = 3;

    public BackstagePass(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateProductQualityAndSellIn() {
        if (this.getQuality() < GildedRose.MAX_PRODUCT_QUALITY) {
            updateBackstagePassQuality();
        }
        this.sellIn = this.sellIn - 1;
    }

    private void updateBackstagePassQuality() {
        if (this.sellIn > 10) {
            this.quality = this.quality + SELL_IN_GREATER_THAN_TEN_QUALITY_INCREMENT;
        } else if (this.sellIn > 5) {
            this.quality = Math.min(this.quality + SELL_IN_GREATER_THAN_FIVE_QUALITY_INCREMENT, GildedRose.MAX_PRODUCT_QUALITY);
        } else if (this.sellIn > 0) {
            this.quality = this.quality + SELL_IN_GREATER_THAN_ZERO_QUALITY_INCREMENT;
        } else {
            this.quality = 0;
        }
    }

    public int getQuality() {
        return quality;
    }
}
