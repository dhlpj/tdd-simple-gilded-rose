package cn.xpbootcamp.gildedrose;

public class GeneralProduct {
    public static final int NON_EXPIRED_PRODUCT_QUALITY_REDUCTION = 1;
    public static final int EXPIRED_PRODUCT_QUALITY_REDUCTION = 2;

    private int sellIn;
    private int quality;

    public GeneralProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
}
