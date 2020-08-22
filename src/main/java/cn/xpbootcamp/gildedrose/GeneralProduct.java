package cn.xpbootcamp.gildedrose;

public class GeneralProduct {
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
}
