package cn.xpbootcamp.gildedrose;

public class BackstagePass extends Product{

    public BackstagePass(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateProductQualityAndSellIn() {
        if (this.getQuality() < GildedRose.MAX_PRODUCT_QUALITY) {
            updateBackstagePassQuality();
        }
        this.sellIn = this.sellIn -1;
    }

    private void updateBackstagePassQuality() {
        if (this.sellIn > 10) {
            this.quality = this.quality + 1;
        } else if (this.sellIn > 5) {
            this.quality = this.quality + 2;
        } else if (this.sellIn > 0){
            this.quality = this.quality + 3;
        } else {
            this.quality = 0;
        }
    }

    public int getQuality() {
        return quality;
    }
}
