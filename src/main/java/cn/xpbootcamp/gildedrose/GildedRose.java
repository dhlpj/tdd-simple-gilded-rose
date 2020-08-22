package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    private List<GeneralProduct> generalProducts;

    public GildedRose(List<GeneralProduct> generalProducts) {
        this.generalProducts = generalProducts;
    }

    public void afterDays(int days) {
        for (GeneralProduct generalProduct : generalProducts) {
            if (generalProduct.getSellIn() <= 0) {
                generalProduct.setQuality(generalProduct.getQuality() - 2 * days);
            } else {
                generalProduct.setQuality(generalProduct.getQuality() - days);
            }
            generalProduct.setSellIn(generalProduct.getSellIn() - days);
        }
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }
}
