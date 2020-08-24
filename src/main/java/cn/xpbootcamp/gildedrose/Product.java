package cn.xpbootcamp.gildedrose;

public abstract class Product {
    protected int sellIn;
    protected int quality;

    abstract public void updateProductQualityAndSellIn();

    abstract protected void updateProductQuality();

    protected void updateProductSellIn() {
        this.sellIn = this.sellIn -1;
    }

    public int getQuality() {
        return quality;
    }
}
