package cn.xpbootcamp.gildedrose;

public class GeneralProduct extends Product{
    public static final int NON_EXPIRED_PRODUCT_QUALITY_REDUCTION = 1;
    public static final int EXPIRED_PRODUCT_QUALITY_REDUCTION = 2;

    public GeneralProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateProductQualityAndSellIn() {
        if (this.quality > GildedRose.MIN_PRODUCT_QUALITY) {
            updateProductQuality();
        }
        updateProductSellIn();
    }

    @Override
    protected void updateProductQuality() {
        if (this.sellIn <= 0) {
            updateExpiredProductQuality();
        } else {
            updateNonExpiredProductQuality();
        }
    }

    private void updateExpiredProductQuality() {
        this.quality = Math.max(this.quality - GeneralProduct.EXPIRED_PRODUCT_QUALITY_REDUCTION, GildedRose.MIN_PRODUCT_QUALITY);
    }

    private void updateNonExpiredProductQuality() {
        this.quality = this.quality - GeneralProduct.NON_EXPIRED_PRODUCT_QUALITY_REDUCTION;
    }
}
