package cn.xpbootcamp.gildedrose;

public abstract class Product {
    protected int sellIn;
    protected int quality;

    abstract public void updateProductQualityAndSellIn();
}
